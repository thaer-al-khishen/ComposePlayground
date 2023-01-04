package com.example.composeplayground.utils.base

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.composeplayground.event_bus_pattern.AppEvent
import com.example.composeplayground.event_bus_pattern.EventBusController
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

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

@Composable
fun LoadingListenerComposable() {

    val lifeCycleOwner = LocalLifecycleOwner.current
    val coroutineScope = rememberCoroutineScope()
    val showLoadingScreen = remember {
        mutableStateOf(false)
    }

    AnimatedVisibility(visible = showLoadingScreen.value) {
        CircularProgressIndicator(
            modifier = Modifier.fillMaxSize()
        )
    }

    DisposableEffect(key1 = lifeCycleOwner) {

        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                coroutineScope.launch {
                    EventBusController.loadingEvent.collectLatest { showRefresh ->
                        showLoadingScreen.value = showRefresh
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
