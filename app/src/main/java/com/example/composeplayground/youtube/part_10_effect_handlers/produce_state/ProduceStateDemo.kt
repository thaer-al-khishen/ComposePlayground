package com.example.composeplayground.youtube.part_10_effect_handlers.produce_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay

//This function produces state that changes over time, like a flow
@Composable
fun produceStateDemo(countUpTo: Int): State<Int> {
    return produceState(initialValue = 0) { //This is a coroutine scope
        while (value < countUpTo) {
            delay(1000L)
            value++
        }
    }
}