package com.example.composeplayground.basic_api.api_test

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
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeplayground.complex_navigation.collectAsStateLifecycleAware
import com.example.composeplayground.utils.handleErrorState
import com.example.composeplayground.utils.handleSuccessState

class ApiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicApiTendersScreen()
        }
    }
}

@Composable
fun BasicApiTendersScreen(
    apiViewModel: ApiViewModel = viewModel()
) {

    val screenState = apiViewModel.uiState.collectAsStateLifecycleAware()

    //Place the following getTenders function in the init block of the recyclerview if you want it to survive config change
//    LaunchedEffect(key1 = true) {
//        apiViewModel.getTenders()
//    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        screenState
//            .handleLoadingState {
//                AnimatedVisibility(visible = (screenState.value.loading)) {
//                    CircularProgressIndicator(
//                        modifier = Modifier.fillMaxSize()
//                    )
//                }
//            }?
            .handleSuccessState { list ->
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

    val lifeCycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = lifeCycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                println("Composable resumed...")
            }
        }
        lifeCycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifeCycleOwner.lifecycle.removeObserver(observer)
        }
    }

}
