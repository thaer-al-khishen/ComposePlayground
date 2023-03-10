package com.example.composeplayground

//import com.example.composeplayground.youtube.part_20_request_permissions.RequestPermissionsScreen
import android.os.Bundle
import android.util.Log
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.basic_api.TestScreen
import com.example.composeplayground.capture_screenshot.CaptureScreen
import com.example.composeplayground.capture_screenshot.CheckPermissionsAndShowScreen
import com.example.composeplayground.complex_navigation.root.RootNavigationGraph
import com.example.composeplayground.utils.base.BaseComposeActivity
import com.example.composeplayground.utils.base.ExitListenerComposable
import com.example.composeplayground.utils.base.launchFastScope
import com.example.composeplayground.youtube.part_12_navigation.Screen
import com.example.composeplayground.youtube.part_21_clean_theming.spacing
import kotlinx.coroutines.*
import java.util.*
import kotlin.collections.ArrayList

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
//                com.example.composeplayground.youtube.part_12_navigation.Navigation()
                CheckPermissionsAndShowScreen()
            }
            val activityKiller: () -> Unit = {
                this.finishAndRemoveTask()
            }
            ExitListenerComposable {
                activityKiller.invoke()
            }


//            launchFastScope {
//                with(it) {
//                    groupTogether({
//                        delay(1000)
//                        Log.d("ThaerOutput","Logged after 1 second")
//                    }, {
//                        delay(2000)
//                        Log.d("ThaerOutput","Logged after 2 seconds")
//                    }, {
//                        delay(3000)
//                        Log.d("ThaerOutput","Logged after 3 seconds")
//                    })
//                }
//            }

        }

    }
}

@Composable
fun CustomViews() {
    AndroidView(factory = { ctx ->
        ImageView(ctx).apply {
            setImageResource(R.drawable.music_knob)
        }
    })
}

fun <T> SnapshotStateList<T>.swapList(newList: List<T>) {
    clear()
    addAll(newList)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SOList() {
    val list = remember { mutableStateListOf<CustomItem>() }
    val count = remember {
        mutableStateOf(0)
    }
    LazyColumn {

        item {
            Button(onClick = {
                list.swapList(
                    listOf(
                        CustomItem(name = "Item A", description = "Item A description"),
                        CustomItem(name = "Item B", description = "Item B description"),
                        CustomItem(name = "Item C", description = "Item C description"),
                    ).shuffled()
                )
            }) {
                Text("Shuffle $count")
            }
        }
        items(list,
            key = { it.id }
        ) {
            Text("Item $it")
            SideEffect {
                count.value++
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RandomList() {
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
//            key = { it.id }
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
