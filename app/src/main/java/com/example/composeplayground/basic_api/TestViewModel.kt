package com.example.composeplayground.basic_api

import com.example.composeplayground.utils.base.BaseViewModel
import com.example.composeplayground.utils.base.launchFastScope
import kotlinx.coroutines.flow.asStateFlow
import java.util.*

class TestViewModel: BaseViewModel() {

    private var _uiState = createMutableStateFlow<List<ObjectInfo>>()
    val uiState = _uiState.asStateFlow()

    private var _firstState = createMutableStateFlow<Int>()
    val firstState = _firstState.asStateFlow()

    private var _secondState = createMutableStateFlow<String>()
    val secondState = _secondState.asStateFlow()

    private var _thirdState = createMutableStateFlow<Boolean>()
    val thirdState = _thirdState.asStateFlow()

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

    fun getFirstBatch() {
        launchSmartScope(_firstState) {
            _firstState.updateDataWith {
                DataSource().getFirstBatch()
            }
        }
    }

    fun getSecondBatch() {
        launchSmartScope(_secondState) {
            _secondState.updateDataWith {
                DataSource().getSecondBatch()
            }
        }
    }

    fun getThirdBatch() {
        launchSmartScope(_thirdState) {
            _thirdState.updateDataWith {
                DataSource().getThirdBatch()
            }
        }
    }

}

data class ObjectInfo(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String
)
