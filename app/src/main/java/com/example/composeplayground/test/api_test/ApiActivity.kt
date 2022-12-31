package com.example.composeplayground.test.api_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeplayground.project_x.collectAsStateLifecycleAware
import com.example.composeplayground.utils.handleErrorState
import com.example.composeplayground.utils.handleLoadingState
import com.example.composeplayground.utils.handleSuccessState

class ApiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TendersScreen()
        }
    }
}

@Composable
fun TendersScreen(
    apiViewModel: ApiViewModel = viewModel()
) {

    val screenState = apiViewModel.uiState.collectAsStateLifecycleAware()

    LaunchedEffect(key1 = true) {
        apiViewModel.getTenders()
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
                            Text(text = "${it.category} ${it.phase_en}")
                        }
                    }
                }
            }
            ?.handleErrorState {
                Text(text = "An error has occured: $it")
            }
    }

}
