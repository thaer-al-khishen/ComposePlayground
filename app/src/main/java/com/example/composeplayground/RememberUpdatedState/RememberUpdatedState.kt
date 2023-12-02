package com.example.composeplayground.RememberUpdatedState

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

@Composable
fun MyComposable(onEvent: (String) -> Unit) {
    var text by remember { mutableStateOf("Initial") }

    val currentText = rememberUpdatedState(text)

    Button(onClick = { onEvent(currentText.value) }) {
        Text("Send Text")
    }
}


//@Composable
//fun UserInput(viewModel: UserViewModel) {
//    var input by remember { mutableStateOf("") }
//
//    val currentInput = rememberUpdatedState(input)
//
//    LaunchedEffect(key1 = Unit) {
//        viewModel.submitData(currentInput.value)
//    }
//
//    TextField(
//        value = input,
//        onValueChange = { input = it }
//    )
//}
//
//
//@Composable
//fun AsyncDataLoader() {
//    var data by remember { mutableStateOf("Loading...") }
//    val currentData = rememberUpdatedState(data)
//
//    LaunchedEffect(key1 = Unit) {
//        loadData { newData -> data = newData }
//
//        // Use currentData.value to get the latest data
//    }
//
//    Text(text = currentData.value)
//}
//
//
//@Composable
//fun LocationListener(locationService: LocationService) {
//    var location by remember { mutableStateOf("Unknown") }
//    val currentLocation = rememberUpdatedState(location)
//
//    DisposableEffect(key1 = locationService) {
//        val listener = LocationListener { newLocation ->
//            location = newLocation
//            // Use currentLocation.value to get the latest location
//        }
//        locationService.addListener(listener)
//
//        onDispose {
//            locationService.removeListener(listener)
//        }
//    }
//}


//Splash screen example, you show a splash screen for 3 seconds, then remove it
//The problem without using rememberUpdatedState, is that if the onTimeOut function changes for some reason
//The change won't reflect inside the launchedEffect, since it was launched with the old onTimeOut
//This rememberUpdateState can listen to the onTimeOutVariable and change before being called in the function
@Composable
fun RememberUpdatedStateDemo(
    onTimeOut: () -> Unit
) {
    val updatedOnTimeout by rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(key1 = true) {
        delay(3000L)
        updatedOnTimeout()
    }
}

