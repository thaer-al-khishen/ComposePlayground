package com.example.composeplayground.test

import com.example.composeplayground.utils.base.BaseViewModel
import kotlinx.coroutines.flow.asStateFlow
import java.util.*

class TestViewModel: BaseViewModel() {

    private var _uiState = createMutableStateFlow<List<ObjectInfo>>()
    val uiState = _uiState.asStateFlow()

    fun getObjects() {
        launchSmartScope(_uiState) {
            _uiState.updateDataWith {
                DataSource().getObjectsFromDataSource()
            }
        }
    }

    fun shuffleObjects() {
        launchSmartScope(_uiState) {
            _uiState.updateDataWith {
                DataSource().getShuffledObjectsFromDataSource()
            }
        }
    }

}

data class ObjectInfo(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String
)
