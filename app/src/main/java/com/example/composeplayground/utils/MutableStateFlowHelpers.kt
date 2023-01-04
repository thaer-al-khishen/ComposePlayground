package com.example.composeplayground.utils

import androidx.compose.runtime.State
import com.example.composeplayground.utils.base.GenericResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.lang.Exception

sealed class GenericData<out T : Any> {
    data class Success<T : Any>(val result : T) : GenericData<T>()
    data class Error(val msg : String) : GenericData<Nothing>()
    object Initial : GenericData<Nothing>()
}

suspend inline fun <T: Any> wrapWithGenericData(crossinline action: suspend () -> T): GenericData<T> {
    return withContext(Dispatchers.IO) {
        try {
            GenericData.Initial
            GenericData.Success(action.invoke())
        } catch (e: Exception) {
            GenericData.Error(e.message ?: "Some error occurred")
        }
    }
}

inline fun <T:Any, R> GenericData<T>.handleSuccessState(crossinline action: (T) -> R) : GenericData<T> {
    if (this is GenericData.Success) {
        action.invoke(this.result)
    }
    return this
}

inline fun <T:Any> GenericData<T>.handleErrorState(crossinline action: (error: String) -> T) : GenericData<T> {
    if (this is GenericData.Error) {
        action.invoke(this.msg)
    }
    return this
}

inline fun <T:Any> State<GenericResponse<GenericData<T>>>.handleLoadingState(crossinline action: () -> Unit) : GenericData<T>? {
    if (this.value.loading) {
        action.invoke()
    }
    return this.value.data
}

inline fun <T:Any, R> State<GenericResponse<GenericData<T>>>.handleSuccessState(crossinline action: (T) -> R) : GenericData<T>? {
    if (this.value.data is GenericData.Success) {
        action.invoke((this.value.data as GenericData.Success<T>).result)
    }
    return this.value.data
}

inline fun <T:Any> State<GenericResponse<GenericData<T>>>.handleErrorState(crossinline action: (error: String) -> T) : GenericData<T>? {
    if (this.value.data is GenericData.Error) {
        action.invoke((this.value.data as GenericData.Error).msg)
    }
    return this.value.data
}