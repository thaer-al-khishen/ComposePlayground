package com.example.composeplayground.LaunchedEffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.launch

//1. Data Fetching on Composable Entry
//Use LaunchedEffect to fetch data when a composable enters the composition.
// This is common in scenarios like displaying a screen that requires data from a network or database.
//@Composable
//fun UserProfileScreen(userId: String, viewModel: UserViewModel) {
//    LaunchedEffect(key1 = userId) {
//        viewModel.loadUserData(userId)
//    }
//
//    // UI code to display user data
//}


//2. Reacting to State Changes
//React to changes in state by using the state as a key. When the state changes, LaunchedEffect will restart its block.
//@Composable
//fun TimerScreen(timerValue: Int) {
//    LaunchedEffect(key1 = timerValue) {
//        // Perform an action when timerValue changes
//    }
//
//    // UI code for the timer
//}


//3. Synchronizing with ViewModel
//Use LaunchedEffect to trigger actions in a ViewModel when a composable appears or certain conditions change.
//@Composable
//fun ContentScreen(viewModel: ContentViewModel) {
//    LaunchedEffect(key1 = Unit) {
//        viewModel.loadInitialContent()
//    }
//
//    // UI code to display content
//}


//4. Timer or Delayed Actions
//Implement a timer or a delay using LaunchedEffect. This can be useful for splash screens or delayed animations.
//@Composable
//fun SplashScreen(navController: NavController) {
//    LaunchedEffect(key1 = Unit) {
//        delay(3000)  // 3-second delay
//        navController.navigate("main")
//    }
//
//    // UI code for splash screen
//}

