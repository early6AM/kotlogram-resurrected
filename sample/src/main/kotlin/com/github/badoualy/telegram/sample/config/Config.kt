package com.github.badoualy.telegram.sample.config

import com.github.badoualy.telegram.api.TelegramApp
import java.io.File
import java.io.FileInputStream
import java.util.*

object Config {

    val ROOT_DIR = File("sample${File.separator}src${File.separator}main${File.separator}resources${File.separator}")
    private val CONFIG_FILE = "config.properties"
    val AUTH_KEY_FILE = File(ROOT_DIR, "auth.key")
    val TEMP_AUTH_KEY_FILE = File(ROOT_DIR, "temp_auth.key")
    val NEAREST_DC_FILE = File(ROOT_DIR, "dc.save")

    private val properties = Properties().apply {
        load(FileInputStream(File(ROOT_DIR,
                                  CONFIG_FILE)))
    }

    val apiId: Int
        get() {
            val prop = getProp("apiId", "21394225").toIntOrNull() ?: 0
            println("${Thread.currentThread().id} apiId: $prop")
            return prop
        }
    val apiHash = getProp("apiHash", "6a4cd2bbb452b95a96692f86ccd2eeda")

    val deviceModel = getProp("deviceModel",
                              "Nexus 5X")
    val systemVersion = getProp("systemVersion",
                                "Android 8.1")
    val appVersion = getProp("appVersion",
                             "0.0.1")
    val langCode = getProp("langCode", "en")

    val phoneNumber = getProp("phoneNumber",
                              "+79093394929")

    val application = TelegramApp(apiId,
                                  apiHash,
                                  deviceModel,
                                  systemVersion,
                                  appVersion,
                                  langCode,
                                  "",
                                  langCode)

    init {
        println("${Thread.currentThread().id} Application config: $application")
        //Kotlogram.testMode = true
    }

    private fun getProp(key: String, default: String) = properties.getProperty(key, default)!!
}