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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
            ScreenA { screenAOutput ->
                val screenBData = ScreenBData(screenAOutput.url)
                navController.navigateWith(ScreenInput.ScreenBInput(screenBData))
            }
        }
        composable(ScreenBData.SCREEN_B_DESTINATION) {
            val screenBData: ScreenBData = navController.getInput(ScreenBData.SCREEN_B_KEY) ?: ScreenBData("")
            ScreenB(screenBData) {
                navController.navigate("ScreenA")
            }
        }
    }
}

@Composable
fun ScreenA(onButtonClicked: (ScreenAOutput) -> Unit) {

    val screenAOutput by remember {
        mutableStateOf(ScreenAOutput(url = "https://example.com"))
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            onButtonClicked(screenAOutput)
        }) {
            Text("Go to Screen B")
        }
    }

}

@Composable
fun ScreenB(screenBData: ScreenBData, onButtonClicked: () -> Unit) {

    val url by remember {
        mutableStateOf(screenBData.url)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("URL: $url")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            onButtonClicked.invoke()
        }) {
            Text("Back to Screen A")
        }
    }

}

data class ScreenAOutput(
    val url: String
)

@Parcelize
data class ScreenBData(
    val url: String
) : Parcelable {
    companion object {
        const val SCREEN_B_DESTINATION = "SCREEN_B_DESTINATION"
        const val SCREEN_B_KEY = "SCREEN_B_KEY"
    }
}

sealed class ScreenInput<T>(val destination: String, val key: String, open val data: T) {
    data class ScreenBInput(override val data: ScreenBData) :
        ScreenInput<ScreenBData>(
            ScreenBData.SCREEN_B_DESTINATION,
            ScreenBData.SCREEN_B_KEY,
            data
        )
}

private fun <T> NavHostController.navigateWith(screenInput: ScreenInput<T>) {
    this.currentBackStackEntry?.savedStateHandle?.apply {
        set(screenInput.key, screenInput.data)
    }
    this.navigate(screenInput.destination)
}

fun <T> NavController.getInput(key: String): T? {
    return this.previousBackStackEntry?.savedStateHandle?.get<T>(
        key
    )
}
