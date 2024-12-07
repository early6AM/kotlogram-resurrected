package com.github.badoualy.telegram.mtproto.rx

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleSource
import io.reactivex.rxjava3.kotlin.zipWith

fun <T, U> Single<T>.flatZip(other: (T) -> SingleSource<U>): Single<Pair<T, U>> = flatMap {
    Single.just(it).zipWith(other.invoke(it), ::Pair)
}