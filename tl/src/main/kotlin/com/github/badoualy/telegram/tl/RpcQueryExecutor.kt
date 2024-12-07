package com.github.badoualy.telegram.tl

import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import io.reactivex.rxjava3.core.Single

interface RpcQueryExecutor {
    fun <T : TLObject> executeMethod(method: TLMethod<T>): Single<T>
}

interface RpcQuerySyncExecutor {
    fun <T : TLObject> executeMethod(method: TLMethod<T>): T
}