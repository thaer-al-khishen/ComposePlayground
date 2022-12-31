package com.example.composeplayground.utils.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.example.composeplayground.utils.GenericData

@Composable
fun <T : Any> State<GenericResponse<GenericData<T>>>.doWhileLoading(action: @Composable () -> Unit): State<GenericResponse<GenericData<T>>>{
    if (this.value.loading) {
        action.invoke()
    }
    return this
}

inline fun <T : Any> State<GenericResponse<GenericData<T>>>.doWhenDoneLoading(crossinline action: () -> GenericData<Any>?): State<GenericResponse<GenericData<T>>>{
    if (!this.value.loading) {
        action.invoke()
    }
    return this
}