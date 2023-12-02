package com.example.composeplayground

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BottomSheetViewModel: ViewModel() {
    // State to hold the open/close status of the bottom sheet
    var bottomSheetState = mutableStateOf(BottomSheetState())
        private set

    fun onEvent(bottomSheetEvent: BottomSheetEvent) {
        when(bottomSheetEvent) {
            is BottomSheetEvent.OpenBottomSheet -> {
                bottomSheetState.value = bottomSheetState.value.copy(
                    isBottomSheetOpen = true
                )
            }
            is BottomSheetEvent.CloseBottomSheet -> {
                bottomSheetState.value = bottomSheetState.value.copy(
                    isBottomSheetOpen = false
                )
            }
        }
    }

}

data class BottomSheetState(
    var isBottomSheetOpen: Boolean = false
)

sealed class BottomSheetEvent {
    data object OpenBottomSheet: BottomSheetEvent()
    data object CloseBottomSheet: BottomSheetEvent()
}
