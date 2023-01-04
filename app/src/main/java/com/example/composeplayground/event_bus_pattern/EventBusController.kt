package com.example.composeplayground.event_bus_pattern

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object EventBusController {

    private val _eventBus = MutableSharedFlow<AppEvent>()
    val eventBus = _eventBus.asSharedFlow()

    private val _loadingEvent = MutableSharedFlow<Boolean>()
    val loadingEvent = _loadingEvent.asSharedFlow()

    suspend fun publishAppEvent(appEvent: AppEvent) {
        _eventBus.emit(appEvent)
    }

    suspend fun publishLoadingEvent(loading: Boolean) {
        _loadingEvent.emit(loading)
    }

}
