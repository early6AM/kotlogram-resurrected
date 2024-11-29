package com.github.badoualy.telegram.sample

import com.github.badoualy.telegram.api.Kotlogram
import com.github.badoualy.telegram.mtproto.exception.RpcErrors.FLOOD_WAIT_3
import com.github.badoualy.telegram.sample.config.Config
import com.github.badoualy.telegram.sample.config.FileApiStorage
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization
import com.github.badoualy.telegram.tl.api.auth.TLSentCode
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import java.io.IOException
import java.util.Scanner

object SignInSample {

    @JvmStatic
    fun main(args: Array<String>) {
        // This is a synchronous client, that will block until the response arrive (or until timeout)
        val client = Kotlogram.getClient(Config.application, FileApiStorage())

        // You can start making requests
        try {
            // Send code to account
            val sentCode = client.authSendCode(false, Config.phoneNumber, true).blockingGet() as TLSentCode
            println("${Thread.currentThread().id} Authentication code: ")
            val code = Scanner(System.`in`).nextLine()

            // Auth with the received code
            val authorization: TLAuthorization =
                try {
                    var attempt = 0
                    var result: TLAuthorization? = null
                    while (attempt < 3) {
                        try {
                            result = client.authSignIn(Config.phoneNumber, sentCode.phoneCodeHash, code, null)
                                .blockingGet() as TLAuthorization
                            break
                        } catch (e: RuntimeException) {
                            val cause = e.cause
                            if (cause is RpcErrorException) {
                                when (cause.code) {
                                    420 -> {
                                        println("${Thread.currentThread().id} FLOOD_WAIT_3 420")
                                        Thread.sleep(3000)
                                    }

                                    else -> throw cause
                                }
                            }
                            attempt++
                            if (attempt == 3) throw e
                        }
                    }
                    result!!
                } catch (e: RpcErrorException) {
                    if (e.type.equals("SESSION_PASSWORD_NEEDED", true)) {
                        // We receive this error is two-step auth is enabled
                        println("${Thread.currentThread().id} Two-step auth password: ")
                        val password = Scanner(System.`in`).nextLine()
//                            client.authCheckPassword(password).blockingGet()
                        TODO()
                    } else if (e.type.equals("PHONE_NUMBER_UNOCCUPIED", true)) {
                        client.authSignUp(Config.phoneNumber, sentCode.phoneCodeHash, "Марат", "Джеманкулов")
                            .blockingGet()
                    } else throw e
                } as TLAuthorization

            authorization.user.asUser()!!.apply {
                println("${Thread.currentThread().id} You are now signed in as $firstName $lastName @$username")
            }
        } catch (e: RpcErrorException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            client.close() // Important, do not forget this, or your process won't finish
        }
    }

}