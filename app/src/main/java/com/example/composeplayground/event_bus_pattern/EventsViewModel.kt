package com.example.composeplayground.event_bus_pattern

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EventsViewModel: ViewModel() {

    fun logout() {
        viewModelScope.launch {
            EventBusController.publishAppEvent(AppEvent.LOGOUT)
        }
    }
}