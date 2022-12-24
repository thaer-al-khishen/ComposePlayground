package com.example.composeplayground.youtube.part_10_effect_handlers.disposable_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

//In the following example, the variables would be reinstantiated on every recomposition
//Using launched effect won't help, because the observer needs to be cleaned up after recompositoin (Disposed)
@Composable
fun DisposableEffectDemo() {

    val lifeCycleOwner = LocalLifecycleOwner.current
    val observer = LifecycleEventObserver { _, event ->
        if (event == Lifecycle.Event.ON_PAUSE) {
            println("On pause called")
        }
    }
    lifeCycleOwner.lifecycle.addObserver(observer)

    DisposableEffect(key1 = lifeCycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_PAUSE) {
                println("On pause called")
            }
        }
        lifeCycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifeCycleOwner.lifecycle.removeObserver(observer)
        }
    }
}