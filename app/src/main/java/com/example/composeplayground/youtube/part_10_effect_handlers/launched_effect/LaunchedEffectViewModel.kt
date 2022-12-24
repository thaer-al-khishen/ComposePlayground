package com.example.composeplayground.youtube.part_10_effect_handlers.launched_effect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LaunchedEffectViewModel: ViewModel() {

    private val _sharedFlow = MutableSharedFlow<ScreenEvents>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            _sharedFlow.emit(ScreenEvents.ShowSnackBar("Hello World!"))
        }
    }

    sealed class ScreenEvents {
        data class ShowSnackBar(val message: String): ScreenEvents()
        data class Navigate(val route: String): ScreenEvents()
    }
}