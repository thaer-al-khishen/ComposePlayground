package com.example.composeplayground.basic_api

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeplayground.complex_navigation.collectAsStateLifecycleAware
import com.example.composeplayground.utils.*
import com.example.composeplayground.utils.base.returnedSuccessWith

class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestScreen()
        }
    }
}

@Composable
fun TestScreen(
    testViewModel: TestViewModel = viewModel()
) {

    val screenState = testViewModel.uiState.collectAsStateLifecycleAware()
    val firstState = testViewModel.firstState.collectAsStateLifecycleAware()
    val secondState = testViewModel.secondState.collectAsStateLifecycleAware()
    val thirdState = testViewModel.thirdState.collectAsStateLifecycleAware()

    LaunchedEffect(key1 = true) {
        testViewModel.getObjects()
        testViewModel.getFirstBatch()
        testViewModel.getSecondBatch()
        testViewModel.getThirdBatch()
    }

    if (firstState.returnedSuccessWith(secondState).returnedSuccessWith(thirdState)) {
        Log.d("ThaerOutput", "Retrieved all")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        screenState
            .handleLoadingState {
                AnimatedVisibility(visible = (screenState.value.loading)) {
                    CircularProgressIndicator(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            ?.handleSuccessState { list ->
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(list) {
                        key(it.id) {
                            Text(text = "${it.name} ${it.description}")
                        }
                    }
                }
                Button(onClick = testViewModel::shuffleObjects) {
                    Text(text = "Shuffle")
                }
                //Note: The following will not work, you need to remove the paranthesis
//                Button(onClick = { testViewModel::shuffleObjects }) {
//                    Text(text = "Shuffle")
//                }
                //The following might cause recomposition:
//                Button(onClick = { testViewModel.shuffleObjects() }) {
//                    Text(text = "Shuffle")
//                }
            }
            ?.handleErrorState {
                Text(text = "An error has occured: $it")
            }
    }
}
