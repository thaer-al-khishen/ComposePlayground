package com.example.composeplayground.RememberCoroutineScope

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun MyButtonWithCoroutine() {
    val scope = rememberCoroutineScope()

    Button(onClick = {
        scope.launch {
            // Perform coroutine-based operations like network requests
        }
    }) {
        Text("Click Me")
    }
}


//@Composable
//fun UserProfile(userId: String, viewModel: UserViewModel) {
//    val scope = rememberCoroutineScope()
//
//    LaunchedEffect(key1 = userId) {
//        scope.launch {
//            viewModel.loadUserData(userId)
//        }
//    }
//
//    // UI code to display user data
//}


@Composable
fun AnimatedVisibilityExample() {
    val scope = rememberCoroutineScope()
    var isVisible by remember { mutableStateOf(false) }

    Button(onClick = { isVisible = !isVisible }) {
        Text("Toggle")
    }

    AnimatedVisibility(visible = isVisible) {
        // Content
    }

    LaunchedEffect(key1 = isVisible) {
        scope.launch {
            // Perform additional actions based on visibility
        }
    }
}


@Composable
fun NavigationButton(navController: NavController) {
    val scope = rememberCoroutineScope()

    Button(onClick = {
        scope.launch {
            navController.navigate("destination")
        }
    }) {
        Text("Navigate")
    }
}
