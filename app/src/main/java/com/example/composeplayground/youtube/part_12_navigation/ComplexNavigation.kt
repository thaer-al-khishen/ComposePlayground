package com.example.composeplayground.youtube.part_12_navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.youtube.base.*

var COMPLEX_OBJECT = "Complex_object"   //Object Key
var DETAILS = "details/"    //Nav destination

@Composable
fun ComplexNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            HomeScreen(navController = navController)
        }
        composableWithObject(objectKey = COMPLEX_OBJECT, route = DETAILS) {
            val complexObject = it.deriveObjectWithKey<ComplexObject>(COMPLEX_OBJECT)
            ObjectDetailScreen(complexObject)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    var name by remember {
        mutableStateOf("")
    }
    var age by remember {
        mutableStateOf("")
    }
    var complexObj by remember {
        mutableStateOf(ComplexObject("", ""))
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = name, onValueChange = {
                name = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = age, onValueChange = {
                age = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                val complexObject = ComplexObject(name, age).toJsonString()
                navController.navigateWithObject(route = DETAILS, objectJson = complexObject)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To Detail Screen")
        }
    }
}

@Composable
fun ObjectDetailScreen(complexObject: ComplexObject?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello ${complexObject?.name}")
        Text(text = "Your age: ${complexObject?.age}")
    }
}

data class ComplexObject(
    var name: String?,
    var age: String?
)
