package com.example.composeplayground.utils.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeplayground.utils.GenericData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BaseViewModel: ViewModel() {

    inline fun <T : Any> launchSmartScope(inputUiState: MutableStateFlow<GenericResponse<T>>, crossinline action: suspend () -> Unit) {
        viewModelScope.launch {
            inputUiState.update { gr ->
                gr.copy(loading = true)
            }
            withContext(Dispatchers.Default) {
                action.invoke()
            }
            inputUiState.update { gr ->
                gr.copy(loading = false)
            }
        }
    }

    fun <T : Any> createMutableStateFlow() = MutableStateFlow(GenericResponse<GenericData<T>>(data = null))

    inline fun <T> MutableStateFlow<GenericResponse<T>>.updateDataWith(function: () -> T) {
        this.update { gr ->
            gr.copy(data = function.invoke())
        }
    }

}
