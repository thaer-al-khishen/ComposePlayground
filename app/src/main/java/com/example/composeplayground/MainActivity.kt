package com.example.composeplayground

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.project_x.root.RootNavigationGraph
import com.example.composeplayground.single_events_lib.SingleEventScreen
import com.example.composeplayground.youtube.base.*
import com.example.composeplayground.youtube.part_12_navigation.ComplexNavigation
import com.example.composeplayground.youtube.part_12_navigation.Screen
import com.example.composeplayground.youtube.part_15_animated_circular_progress.CircularProgressBar
import com.example.composeplayground.youtube.part_16_music_knob.MusicKnobScreen
import com.example.composeplayground.youtube.part_9_constraint_layouts.*
import kotlinx.coroutines.delay

var COMPLEX_OBJECT = "Complex_object"
var COMPLEX_OBJECT_2 = Screen.DetailScreen.route + "/?$COMPLEX_OBJECT={$COMPLEX_OBJECT}"

class MainActivity : BaseComposeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
//                RootNavigationGraph(navController = navController)
//                SingleEventScreen()
//                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                    CircularProgressBar(percentage = 0.8f, number = 100)
//                }
                MusicKnobScreen()
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

@Composable
fun Test() {
    
}
