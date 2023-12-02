package com.example.composeplayground.DerivedStateOf

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

//@Composable
//fun UserProfileScreen(user: User, isProfileComplete: Boolean) {
//    val displayName = derivedStateOf {
//        "${user.firstName} ${user.lastName}"
//    }
//
//    val profileStatus = derivedStateOf {
//        if (isProfileComplete) "Complete" else "Incomplete"
//    }
//
//    // UI code that uses displayName and profileStatus
//}


@Composable
fun ContentScreen(isLoading: Boolean, isError: Boolean) {
    val contentState = remember {
        derivedStateOf {
            when {
                isLoading -> "Loading..."
                isError -> "Error occurred"
                else -> "Content loaded"
            }
        }
    }

    Text(text = contentState.value)
}


//@Composable
//fun ComplexCalculationScreen(a: Int, b: Int, c: Int) {
//    val result = derivedStateOf {
//        // An expensive calculation based on a, b, and c
//        performComplexCalculation(a, b, c)
//    }
//
//    // UI code that displays the result
//}


//@Composable
//fun DataTransformation(items: List<Item>) {
//    val itemCount = derivedStateOf {
//        items.size
//    }
//
//    // UI code that uses itemCount
//}


//data class ScreenState(val items: List<Item>, val isLoading: Boolean, val user: User)
//
//@Composable
//fun MyScreen(state: ScreenState, onEvent: (MyEvent) -> Unit) {
//    // Composable content
//}
//
//
//@Composable
//fun MyScreen(state: ScreenState, onEvent: (MyEvent) -> Unit) {
//    val userGreeting = derivedStateOf {
//        if (state.isLoading) "Loading..." else "Hello, ${state.user.name}!"
//    }
//
//    Text(text = userGreeting.value)
//    // Other UI components
//}
