package com.example.composeplayground.basic_api.api_test

import com.example.composeplayground.basic_api.api_test.model.ChildModel
import com.example.composeplayground.utils.GenericData
import com.example.composeplayground.utils.base.BaseViewModel
import com.example.composeplayground.utils.base.GenericResponse
import kotlinx.coroutines.flow.*

class ApiViewModel: BaseViewModel() {

    private var _uiState = createMutableStateFlow<List<ChildModel>>()
    val uiState = _uiState.asStateFlow()

    init {
        getTenders()
    }

    fun getTenders() {
        launchSmartScope(_uiState) {
            _uiState.updateDataWith {
                ApiRepository().getTenders()
            }
        }
    }
}
