package com.example.composeplayground.event_bus_pattern

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object EventBusController {

    private val _eventBus = MutableSharedFlow<AppEvent>()
    val eventBus = _eventBus.asSharedFlow()

    suspend fun publishEvent(appEvent: AppEvent) {
        _eventBus.emit(appEvent)
    }
}