package com.example.composeplayground.youtube.part_14_bottom_nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeplayground.youtube.part_14_bottom_nav.ui.theme.ComposePlaygroundTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.youtube.part_12_navigation.LoginScreen
import com.example.composeplayground.youtube.part_12_navigation.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost

class BottomNavActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetupBottomNav()
        }
    }
}

@Composable
fun SetupBottomNav() {
    val navController = rememberNavController()
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        "home" -> true // on this screen bottom bar should be shown
        "chat" -> true // here too
        "settings" -> true // here too
        else -> false // in all other cases hide bottom bar
    }

    Scaffold(bottomBar = {
        BottomNavigationBar(items = listOf(
            BottomNavItem(
                name = "Home",
                route = "home",
                icon = Icons.Default.Home
            ),
            BottomNavItem(
                name = "Chat",
                route = "chat",
                icon = Icons.Default.Notifications,
                badgeCount = 25
            ),
            BottomNavItem(
                name = "Settings",
                route = "settings",
                icon = Icons.Default.Settings
            )
        ),
            navController = navController,
            onItemClick = {
                navController.navigate(it.route) {
                    launchSingleTop = true
                    restoreState = true
                    //To handle onbackpressed and exit user when navigating between bottomnav items
                    popUpTo(navController.currentDestination?.route ?: "") { inclusive = true }
                }
            })
    }) {
        BottomNavigation(navHostController = navController)
    }
}

@Composable
fun BottomNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("chat") {
//            DestinationsNavHost(navGraph = NavGraphs.root)
            ChatScreen()
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                //Check if the route of our current destination is the same as the route of our item
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(
                                badge = { Badge { Text(item.badgeCount.toString()) } }) {
                                Icon(imageVector = item.icon, contentDescription = item.name)
                            }
                        } else {
                            Icon(imageVector = item.icon, contentDescription = item.name)
                        }
                        if (selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                })
        }
    }
}

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Home Screen")
    }
}

@Composable
fun ChatScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Chat Screen")
    }
}

@Composable
fun SettingsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Settings Screen")
    }
}