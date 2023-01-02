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

inline fun launchFastScope(crossinline action: suspend () -> Unit) {
    CoroutineScopeHelper.getCoroutineScope().launch {
        action.invoke()
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

@Composable
fun ExitListenerComposable(ExitEventTriggered: () -> Unit) {
    val lifeCycleOwner = LocalLifecycleOwner.current

    val coroutineScope = rememberCoroutineScope()

    DisposableEffect(key1 = lifeCycleOwner) {

        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                coroutineScope.launch {
                    EventBusController.eventBus.filter {
                        it == AppEvent.EXIT
                    }.collectLatest { logoutEvent ->
                        ExitEventTriggered.invoke()
                    }
                }
            }
        }
        lifeCycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifeCycleOwner.lifecycle.removeObserver(observer)
        }
    }

}
