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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeplayground.youtube.base.*
import com.google.gson.Gson

var COMPLEX_OBJECT = "Complex_object"   //Object Key
var DETAILS = "details/"    //Nav destination
var DETAILS_COMPOSABLE_ROUTE = "$DETAILS{$COMPLEX_OBJECT}"

@Composable
fun ComplexNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = DETAILS_COMPOSABLE_ROUTE,
            arguments = listOf(
                navArgument(COMPLEX_OBJECT) {
                    type = NavType.StringType
                }
            )
        ) {
//            val genericData = it.arguments?.getParcelable<GenericData>(COMPLEX_OBJECT)
//            val complexObject = genericData?.data as ComplexObject
//            val complexObject = mapToObject((genericData?.data) as Map<String, Any?>, ComplexObject::class.java)
//            ObjectDetailScreen(complexObject)

//            val genericData = it.arguments?.getString(COMPLEX_OBJECT)
//            val complexObject = getObject<ComplexObject>(genericData ?: "")
//            ObjectDetailScreen(complexObject)

            val complexObject = it.deriveObjectWithTag<ComplexObject>(COMPLEX_OBJECT)
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
//                val complexObject = GenericData(ComplexObject(name, age))
//                val json = Uri.encode(Gson().toJson(complexObject))
//                navController.navigate("details/$json")

//                val complexObject = ComplexObject(name, age)
//                val json = Uri.encode(Gson().toJson(complexObject))
//                navController.navigate("$DETAILS$json")

                val complexObject = ComplexObject(name, age).toJsonString()
                navController.navigate("$DETAILS$complexObject")

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

fun <T> mapToObject(map: Map<String, Any?>?, type: Class<T>): T? {
    if (map == null) return null
    val json = Gson().toJson(map)
    return Gson().fromJson(json, type)
}
