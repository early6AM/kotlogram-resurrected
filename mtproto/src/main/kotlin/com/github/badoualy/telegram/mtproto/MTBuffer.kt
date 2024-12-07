package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.mtproto.log.LogTag
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.Subject
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class MTBuffer<T>(var bufferSize: Int,
                  var bufferTimeout: Long, var bufferTimeoutUnit: TimeUnit,
                  var tag: LogTag? = null) {

    private var bufferId = 0
    private var list = ArrayList<T>(bufferSize)

    private val subject: Subject<List<T>> = PublishSubject.create()
    val observable: Observable<List<T>>
        get() = subject.hide()
                .doOnNext { println("${Thread.currentThread().id} $tag doOnNext ${it.joinToString()}") }

    fun add(item: T) {
        var flush = false
        var startTimer = false
        var list: List<T> = emptyList()
        var id: Int = -1

        synchronized(this.list) {
            this.list.add(item)
            list = this.list
            id = bufferId
            println("${Thread.currentThread().id} $tag Adding msgId $item to bufferId $bufferId")

            when {
                list.size == 1 -> startTimer = true
                list.size < bufferSize -> return
                else -> {
                    newBuffer()
                    flush = true
                }
            }
        }

        if (startTimer) {
            Observable.just(id)
                    .delay(bufferTimeout, bufferTimeoutUnit)
                    .observeOn(Schedulers.computation())
                    .flatMapMaybe { get(it).takeIf { it.isNotEmpty() }?.let { Maybe.just(it) } ?: Maybe.empty() }
                    .subscribe(subject)
        }

        if (flush) {
            println("${Thread.currentThread().id} $tag Flushing buffer $bufferId")
            subject.onNext(list)
        }
    }

    fun get() = get(bufferId)

    fun reset() = synchronized(list) {
        list = ArrayList(bufferSize)
        bufferId = 0
    }

    private fun newBuffer() = synchronized(list) {
        list = ArrayList(bufferSize)
        bufferId++
    }

    private operator fun get(id: Int): List<T> {
        var list: List<T> = emptyList()

        synchronized(this.list) {
            if (id != bufferId) {
                // Already flushed
                return emptyList()
            }

            list = this.list
            newBuffer()
        }

        return list
    }
}