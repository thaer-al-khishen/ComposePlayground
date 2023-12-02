package com.example.composeplayground.DisposableEffect

import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect

//@Composable
//fun SensorListenerExample(sensorManager: SensorManager) {
//    DisposableEffect(key1 = sensorManager) {
//        val listener = SensorEventListener { /* Handle sensor updates */ }
//        sensorManager.registerListener(listener, /* sensor */, /* delay */)
//
//        onDispose {
//            sensorManager.unregisterListener(listener)
//        }
//    }
//}

//@Composable
//fun FlowSubscriptionExample(flow: Flow<String>) {
//    DisposableEffect(key1 = flow) {
//        val subscription = flow.onEach { /* Handle flow emissions */ }.launchIn(CoroutineScope(Dispatchers.Main))
//
//        onDispose {
//            subscription.cancel()
//        }
//    }
//}

//@Composable
//fun AnimationExample(animation: Animation) {
//    DisposableEffect(key1 = animation) {
//        animation.start()
//
//        onDispose {
//            animation.stop()
//        }
//    }
//}

//@Composable
//fun SdkUsageExample(sdk: SomeExternalSdk) {
//    DisposableEffect(key1 = sdk) {
//        sdk.initialize()
//
//        onDispose {
//            sdk.release()
//        }
//    }
//}
