package com.example.composeplayground.youtube.part_10_effect_handlers.remember_updated_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

//Splash screen example, you show a splash screen for 3 seconds, then remove it
//The problem without using rememberUpdatedState, is that if the onTimeOut function changes for some reason
//The change won't reflect inside the launchedEffect, since it was launched with the old onTimeOut
//This rememberUpdateState can listen to the onTimeOutVariable and change before being called in the function
@Composable
fun RememberUpdatedStateDemo(
    onTimeOut: () -> Unit
) {
    val updatedOnTimeout by rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(key1 = true) {
        delay(3000L)
        updatedOnTimeout()
    }
}