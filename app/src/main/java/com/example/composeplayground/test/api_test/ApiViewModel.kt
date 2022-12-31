package com.example.composeplayground.test.api_test

import androidx.lifecycle.ViewModel
import com.example.composeplayground.test.DataSource
import com.example.composeplayground.test.ObjectInfo
import com.example.composeplayground.test.api_test.model.ChildModel
import com.example.composeplayground.utils.base.BaseViewModel
import kotlinx.coroutines.flow.asStateFlow

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
