package com.example.composeplayground.single_events_lib

import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed

data class MainViewState(
    val isLoading: Boolean = false,
    val processSuccessEvent: StateEvent = consumed,
    val processSuccessWithTimestampEvent: StateEventWithContent<String> = consumed(),
)
