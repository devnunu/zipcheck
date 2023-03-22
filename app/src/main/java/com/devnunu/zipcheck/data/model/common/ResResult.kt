package com.devnunu.zipcheck.data.model.common

sealed class ResResult<out T> {

    data class Success<out T>(val data: T?) : ResResult<T>()
    data class Error(val error: Exception?) : ResResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Fail[code=$error]"
        }
    }

    fun getResultData(): T? {
        return when (this) {
            is Success<*> -> data as T?
            else -> null
        }
    }

    fun hasData(): Boolean {
        return when (this) {
            is Success<*> -> data != null
            else -> false
        }
    }
}

suspend fun <T> wrapAsResResult(task: suspend () -> T?): ResResult<T> {
    return try {
        ResResult.Success(task())
    } catch (e: Exception) {
        ResResult.Error(e)
    }
}