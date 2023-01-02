package com.example.composeplayground.event_bus_pattern

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

@Composable
fun LogoutListenerComposable(logoutEventTriggered: () -> Unit) {
    val lifeCycleOwner = LocalLifecycleOwner.current

    val coroutineScope = rememberCoroutineScope()

    DisposableEffect(key1 = lifeCycleOwner) {

        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                coroutineScope.launch {
                    EventBusController.eventBus.filter {
                        it == AppEvent.LOGOUT
                    }.collectLatest { logoutEvent ->
                        logoutEventTriggered.invoke()
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
