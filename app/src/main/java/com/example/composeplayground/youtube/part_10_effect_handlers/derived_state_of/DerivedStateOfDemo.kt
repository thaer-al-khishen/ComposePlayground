package com.example.composeplayground.youtube.part_10_effect_handlers.derived_state_of

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

//This would concatenate the whole counterText again instead of just the counter
@Composable
fun DerivedStateOfDemo() {
//    var counter by remember {
//        mutableStateOf(0)
//    }
//    val counterText = "The counter is $counter"
//    Button(onClick = { counter++ }) {
//        Text(text = counterText)
//    }
    var counter by remember {
        mutableStateOf(0)
    }
    //When counterText is accessed the first time, it will compute this string "The counter is $counter"
    //The string will be cached
    //The successive accesses will access the cache
    val counterText by derivedStateOf {
        "The counter is $counter"
    }
    Button(onClick = { counter++ }) {
        Text(text = counterText)
    }
}