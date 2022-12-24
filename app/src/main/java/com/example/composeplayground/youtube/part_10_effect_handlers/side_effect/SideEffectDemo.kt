package com.example.composeplayground.youtube.part_10_effect_handlers.side_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

//SideEffect gets called whenever the composable gets recomposed
//If for some reason you're getting something that's not a state from a network call
//For example, with firebase users, whenever the firebase user gets updated, this gets recomposed and you update some firebase analytics id
@Composable
fun SideEffectDemo(nonComposeCounter: Int){
    SideEffect {
        println("Called after every successful recomposition")
    }
}