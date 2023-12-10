package com.example.composeplayground.bundle_arguments

import android.os.Parcelable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.parcelize.Parcelize

@Composable
fun BundleArgumentsNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "ScreenA") {
        composable("ScreenA") {
            ScreenA { sharedObject ->
                navController.navigateWithArgument("ScreenB", "sharedObject", sharedObject)
            }
        }
        composable("ScreenB") {
            val sharedObject: SharedObject = navController.getArgument("sharedObject") ?: SharedObject("")
            ScreenB(sharedObject) {
                navController.navigate("ScreenA")
            }
        }
    }
}

@Composable
fun ScreenA(onButtonClicked: (SharedObject) -> Unit) {
    val sharedObject = SharedObject(url = "https://example.com")

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            onButtonClicked(sharedObject)
        }) {
            Text("Go to Screen B")
        }
    }

}

@Composable
fun ScreenB(sharedObject: SharedObject, onButtonClicked: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("URL: ${sharedObject.url ?: "No URL"}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            onButtonClicked.invoke()
        }) {
            Text("Back to Screen A")
        }
    }

}

private fun <T> NavHostController.navigateWithArgument(destination: String, key: String, data: T) {
    this.currentBackStackEntry?.savedStateHandle?.apply {
        set(key, data)
    }
    this.navigate(destination)
}

private fun <T> NavHostController.getArgument(key: String): T? {
    return this.previousBackStackEntry?.savedStateHandle?.get<T>(
        key
    )
}

@Parcelize
data class SharedObject(
    val url: String
) : Parcelable
