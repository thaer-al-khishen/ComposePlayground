package com.example.composeplayground.single_events_lib

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.palm.composestateevents.EventEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeplayground.project_x.collectAsStateLifecycleAware

class SingleEventActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                SingleEventScreen()
            }
        }
    }
}

@Composable
fun SingleEventScreen(viewModel: MainViewModel = viewModel()) {

    val viewState: MainViewState by viewModel.viewState.collectAsStateLifecycleAware()

    val snackbarHostState = remember { SnackbarHostState() }

    EventEffect(
        event = viewState.processSuccessEvent,
        onConsumed = viewModel::setShowMessageConsumed
    ) {
        snackbarHostState.showSnackbar("Event success")
    }

    EventEffect(
        event = viewState.processSuccessWithTimestampEvent,
        onConsumed = viewModel::setShowMessageConsumed
    ) { timestamp ->
        snackbarHostState.showSnackbar("Event success at: $timestamp")
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding: PaddingValues ->

        MainContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            onStartProcessWithoutTimestamp = { viewModel.startProcess(useTimestamp = false) },
            onStartProcessWithTimestamp = { viewModel.startProcess(useTimestamp = true) },
            isLoading = viewState.isLoading
        )
    }
}

@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    onStartProcessWithoutTimestamp: () -> Unit,
    onStartProcessWithTimestamp: () -> Unit,
    isLoading: Boolean
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopAppBar(
            title = { Text("Compose State Events Test App") }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(visible = isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onStartProcessWithoutTimestamp,
                enabled = !isLoading
            ) {
                Text(text = "Trigger event without timestamp")
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onStartProcessWithTimestamp,
                enabled = !isLoading
            ) {
                Text(text = "Trigger event with timestamp")
            }
        }
    }
}
