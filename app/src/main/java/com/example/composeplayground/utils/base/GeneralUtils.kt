package com.example.composeplayground.utils.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.example.composeplayground.event_bus_pattern.AppEvent
import com.example.composeplayground.event_bus_pattern.EventBusController
import com.example.composeplayground.utils.GenericData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

inline fun launchFastScope(crossinline action: suspend () -> Unit) {
    val job = SupervisorJob()
    val scope = CoroutineScope(Dispatchers.IO + job)
    scope.launch {
        action.invoke()
    }
}
