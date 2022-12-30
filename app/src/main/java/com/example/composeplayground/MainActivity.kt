package com.example.composeplayground

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.youtube.base.*
import com.example.composeplayground.youtube.part_12_navigation.Screen
import com.example.composeplayground.youtube.part_21_clean_theming.spacing
import com.example.composeplayground.youtube.part_23_pagination.PaginatedScreen
import com.example.composeplayground.youtube.base.SynchronizedLock
import com.example.composeplayground.youtube.part_27_deeplinking.DeepLinkingScreen
//import com.example.composeplayground.youtube.part_20_request_permissions.RequestPermissionsScreen
import kotlinx.coroutines.delay

var COMPLEX_OBJECT = "Complex_object"
var COMPLEX_OBJECT_2 = Screen.DetailScreen.route + "/?$COMPLEX_OBJECT={$COMPLEX_OBJECT}"

class MainActivity : BaseComposeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val apiKey = BuildConfig.API_KEY

            Surface(color = Color.White, modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.spacing.default)) {
//                RootNavigationGraph(navController = navController)
//                PaginatedScreen(SynchronizedLock())
                DeepLinkingScreen()
            }


        }
    }
}

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
