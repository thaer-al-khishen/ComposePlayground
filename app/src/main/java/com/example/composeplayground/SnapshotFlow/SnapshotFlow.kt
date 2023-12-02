package com.example.composeplayground.SnapshotFlow

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow

//@Composable
//fun MyComposable(viewModel: MyViewModel) {
//    var text by remember { mutableStateOf("") }
//
//    LaunchedEffect(key1 = text) {
//        snapshotFlow { text }
//            .collect { newText ->
//                viewModel.updateText(newText)
//            }
//    }
//
//    TextField(value = text, onValueChange = { text = it })
//}
//
//
//@Composable
//fun LocationComposable(locationProvider: LocationProvider) {
//    var currentLocation by remember { mutableStateOf<Location?>(null) }
//
//    LaunchedEffect(key1 = currentLocation) {
//        snapshotFlow { currentLocation }
//            .filterNotNull()
//            .collect { location ->
//                locationProvider.updateLocation(location)
//            }
//    }
//
//    // UI code to update currentLocation
//}
//
//
//@Composable
//fun CombinedStateExample(a: State<Int>, b: State<String>) {
//    LaunchedEffect(key1 = a, key2 = b) {
//        snapshotFlow { a.value to b.value }
//            .collect { (newA, newB) ->
//                // Handle combined state change
//            }
//    }
//}
