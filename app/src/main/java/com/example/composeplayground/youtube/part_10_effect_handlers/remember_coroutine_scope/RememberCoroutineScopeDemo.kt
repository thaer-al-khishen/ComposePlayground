package com.example.composeplayground.youtube.part_10_effect_handlers.remember_coroutine_scope

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//If this composable leaves the composition, all the coroutines here are cancelled
//This should only be called on callback functions such as onclick, ontextchanged
//This shouldn't be used when the composable is initialized, instead, you should use LaunchedEffect
@Composable
fun RememberCoroutineScopeDemo() {
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
            delay(1000L)
            println("Hello World!")
        }
    }) {

    }
}