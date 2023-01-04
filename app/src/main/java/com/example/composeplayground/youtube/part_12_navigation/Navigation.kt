package com.example.composeplayground.youtube.part_12_navigation

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeplayground.utils.base.composableWithObject
import com.example.composeplayground.utils.base.deriveObjectWithKey
import com.example.composeplayground.utils.base.navigateWithObject

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) { backStackEntry ->
            // get data passed back from B
            val data = backStackEntry
                .savedStateHandle
                .getLiveData<String>("key")
                .value

            MainScreen(data = data ?: "", navController = navController)
        }
        composableWithObject("name", Screen.DetailScreen.route) {
            val data = it.deriveObjectWithKey<String>("name")
            DetailScreen(data, navController)
        }
    }
}

@Composable
fun MainScreen(data: String, navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = text, onValueChange = {
                text = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
//                navController.navigate(Screen.DetailScreen.withArgs(text))
                navController.navigateWithObject(Screen.DetailScreen.route, text)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To Detail Screen")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = data)
    }
}

@Composable
fun DetailScreen(name: String?, navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Hello $name")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                navController.previousBackStackEntry
                    ?.savedStateHandle
                    ?.set("key", name)
                navController.popBackStack()
            }) {
                Text(text = "Pop back")
            }
        }
    }
}
