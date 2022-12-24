package com.example.composeplayground.youtube.part_10_effect_handlers.launched_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.LaunchedEffect

//In this effect, the animateTo function will render a new animation when the counter is changed
//The example was a calorie counter application, where the user selects a day and the calorie counter changes according to that day
@Composable
fun LaunchedEffectAnimation(
    counter: Int
) {
    val animatable = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = counter) {
        animatable.animateTo(counter.toFloat())
    }
}