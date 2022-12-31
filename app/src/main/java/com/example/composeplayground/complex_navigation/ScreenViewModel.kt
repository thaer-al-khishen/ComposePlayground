package com.example.composeplayground

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ScreenViewModel: ViewModel() {

//    private var _uiState = mutableStateOf(UIState())
//    val uiState: State<UIState> = _uiState

    private var _uiState = MutableStateFlow(UIState())
    val uiState = _uiState.asStateFlow()

    init {
        var counter = 0
        viewModelScope.launch {

            while (true) {
                delay(2000)
                onEvent(UIEvent.AccountChanged("${counter++}"))
                Log.d("TutorialViewModel", "Counter invocation: ${_uiState.value}")
            }
        }
    }

    fun onEvent(event: UIEvent) {
        when(event) {
            is UIEvent.AccountChanged -> {
                _uiState.update { currentState ->
                    currentState.copy(accountNumber = event.account)
                }
            }
            is UIEvent.ConfirmAccountChanged -> {
                _uiState.update { currentState ->
                    currentState.copy(confirmAccountNumber = event.confirmAccount)
                }
            }
            is UIEvent.CodeChanged -> {
                _uiState.update { currentState ->
                    currentState.copy(code = event.code)
                }
            }
            is UIEvent.NameChanged -> {
                _uiState.update { currentState ->
                    currentState.copy(ownerName = event.name)
                }
            }
//            is UIEvent.Submit -> {
//                validateInputs()
//            }
        }
    }

}

sealed class UIEvent {
    data class AccountChanged(val account: String): UIEvent()
    data class ConfirmAccountChanged(val confirmAccount: String): UIEvent()
    data class CodeChanged(val code: String): UIEvent()
    data class NameChanged(val name: String): UIEvent()
    object Submit: UIEvent()
}

data class UIState(
    val accountNumber: String = "",
    val confirmAccountNumber: String = "",
    val code: String = "",
    val ownerName: String = "",
    val hasAccountError: Boolean = false,
    val hasConfirmAccountError: Boolean = false,
    val hasCodeError: Boolean = false,
    val hasNameError: Boolean = false,
)