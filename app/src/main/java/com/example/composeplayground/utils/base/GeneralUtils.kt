package com.example.composeplayground.utils.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.composeplayground.event_bus_pattern.AppEvent
import com.example.composeplayground.event_bus_pattern.EventBusController
import com.example.composeplayground.utils.GenericData
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter

object CoroutineScopeHelper {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)
    fun getCoroutineScope(): CoroutineScope {
        return scope
    }
}

inline fun launchFastScope(crossinline action: suspend (CoroutineScope) -> Unit) {
    CoroutineScopeHelper.getCoroutineScope().launch {
        action.invoke(this)
    }
//    scope.launch {
//        action.invoke()
//    }
//    scope.async {
//        action.invoke()
//    }.invokeOnCompletion {
//        scope.cancel()
//    }
}

fun <T : Any, R: Any> State<GenericResponse<GenericData<T>>>.returnedSuccessWith(otherState: State<GenericResponse<GenericData<R>>>): Boolean {
    if (this.value.data is GenericData.Success && otherState.value.data is GenericData.Success) {
        return true
    }
    return false
}

fun <T : Any> Boolean.returnedSuccessWith(otherState: State<GenericResponse<GenericData<T>>>): Boolean {
    if (this && otherState.value.data is GenericData.Success) {
        return true
    }
    return false
}
