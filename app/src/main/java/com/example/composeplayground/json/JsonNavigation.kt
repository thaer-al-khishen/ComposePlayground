package com.example.composeplayground.json

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson

@Preview
@Composable
fun JsonAppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = JsonDestinations.JSON_HOME_SCREEN) {
        composable(JsonDestinations.JSON_HOME_SCREEN) {
            JsonHomeScreen(onButtonClicked = { jsonData ->
                navController.navigate("${JsonDestinations.JSON_DETAILS_SCREEN}/$jsonData")
            })
        }
        composable("${JsonDestinations.JSON_DETAILS_SCREEN}/{jsonData}") { backStackEntry ->
            val data = backStackEntry.arguments?.getString("jsonData") ?: ""
            val dataObject = Gson().fromJson(data, JsonNavigationObject::class.java)
            JsonDetailsScreen(title = dataObject.title)
        }
    }
}

@Composable
fun JsonHomeScreen(onButtonClicked: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Example data object
        val dataObject = JsonNavigationObject(title = "Details Title")
        // Serialize data object to JSON
        val jsonData = Gson().toJson(dataObject)

        Text(text = "Home Screen", fontSize = 48.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            onButtonClicked.invoke(jsonData)
        }) {
            Text(text = "Go to details", fontSize = 16.sp)
        }
    }
}

@Composable
fun JsonDetailsScreen(title: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = title, fontSize = 48.sp)
    }
}

object JsonDestinations {
    const val JSON_HOME_SCREEN = "JSON_HOME_SCREEN"
    const val JSON_DETAILS_SCREEN = "JSON_DETAILS_SCREEN"
}

data class JsonNavigationObject(
    val title: String
)
