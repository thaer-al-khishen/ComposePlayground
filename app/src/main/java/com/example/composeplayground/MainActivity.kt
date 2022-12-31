package com.example.composeplayground

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.test.TestScreen
import com.example.composeplayground.utils.base.*
import com.example.composeplayground.youtube.part_12_navigation.Screen
import com.example.composeplayground.youtube.part_21_clean_theming.spacing
//import com.example.composeplayground.youtube.part_20_request_permissions.RequestPermissionsScreen
import kotlinx.coroutines.delay
import java.util.*

var COMPLEX_OBJECT = "Complex_object"
var COMPLEX_OBJECT_2 = Screen.DetailScreen.route + "/?$COMPLEX_OBJECT={$COMPLEX_OBJECT}"

class MainActivity : BaseComposeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val apiKey = BuildConfig.API_KEY

            Surface(
                color = Color.White, modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.spacing.default)
            ) {
//                RootNavigationGraph(navController = navController)
                TestScreen()
            }
        }
    }
}

fun <T> SnapshotStateList<T>.swapList(newList: List<T>) {
    clear()
    addAll(newList)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SOList() {

    val list = remember { mutableStateListOf<CustomItem>() }

    LazyColumn {
        item {
            Button(onClick = {
                list.swapList(
                    listOf(
                        CustomItem(name = "Item A", description = "Item A description"),
                        CustomItem(name = "Item B", description = "Item B description"),
                        CustomItem(name = "Item C", description = "Item C description"),
                        CustomItem(name = "Item D", description = "Item D description")
                    ).shuffled()
                )
            }) {
                Text("Shuffle")
            }
        }
        items(list,
            key = { it.id }
        ) {
            Text("Item $it")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RandomList() {

//    val mainViewModel: MainViewModel = viewModel()
//
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.75f)
//        ) {
//            items(mainViewModel.viewState.value.items) {
//                key(it.id)
//                {
//                    Text(
//                        text = "Item ${it} with description: ${it.description}",
//                        fontSize = 32.sp,
//                        fontWeight = FontWeight.Bold,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(24.dp)
//                    )
//                }
//            }
//        }
//        Button(onClick = {
//            mainViewModel.shuffle()
//        }, modifier = Modifier.align(Alignment.BottomCenter)) {
//            Text(text = "Shuffle")
//        }
//    }

    var list by remember {
        mutableStateOf(
            listOf(
                CustomItem(name = "Item A", description = "Item A description"),
                CustomItem(name = "Item B", description = "Item B description"),
                CustomItem(name = "Item C", description = "Item C description"),
                CustomItem(name = "Item D", description = "Item D description")
            )
        )
    }

    LazyColumn {
        item {
            Button(onClick = { list = list.shuffled() }) {
                Text("Shuffle")
            }
        }
        items(list,
            key = { it.id }
        ) {
            Text("Item $it", Modifier.animateItemPlacement())
        }
    }
}

data class CustomItem(
    val id: String = UUID.randomUUID().toString(),
    var name: String,
    val description: String
)

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("main_screen") {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Main Screen", color = Color.White)
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate("main_screen")
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value)
        )
    }
}
