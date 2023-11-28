package com.example.composeplayground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

/**
 * Represents an item in the bottom navigation bar.
 *
 * @property name The display name of the item.
 * @property route The navigation route associated with the item.
 * @property icon The icon to display for the item.
 * @property badgeCount The count to display in a badge (0 means no badge).
 */
data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
)

/**
 * Main entry point for the bottom navigation bar example using Material2 design.
 */
@Composable
fun Material2BottomNavigation() {
    val navController = rememberNavController()
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // Define the items in the bottom navigation bar
    val bottomNavItems = listOf(
        BottomNavItem(
            name = "Home",
            route = "home",
            icon = ImageVector.vectorResource(id = R.drawable.ic_launcher_background)
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
    )

    // Logic to control the visibility of the bottom bar
    showBottomBar = when (navBackStackEntry?.destination?.route) {
        "home" -> true // on this screen bottom bar should be shown
        "chat" -> true // here too
        "settings" -> true // here too
        else -> false // in all other cases hide bottom bar
    }

    Scaffold(bottomBar = {
        BottomNavigationBar(
            items = bottomNavItems,
            navController = navController,
            onItemClick = {
                // Navigation configuration
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

/**
 * Composable function to render the bottom navigation bar.
 *
 * @param items The list of items to display in the bottom navigation bar.
 * @param navController The NavController for handling navigation events.
 * @param modifier The modifier to be applied to the BottomNavigation.
 * @param onItemClick The callback to be invoked when an item is clicked.
 */
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()

    androidx.compose.material.BottomNavigation(
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
                icon = { BottomNavItemIcon(item, selected) }
            )
        }
    }
}

/**
 * Composable function to render the icon for a bottom navigation item.
 *
 * @param item The BottomNavItem to render.
 * @param isSelected Whether the item is currently selected.
 */
@Composable
fun BottomNavItemIcon(item: BottomNavItem, isSelected: Boolean) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (item.badgeCount > 0) {
            BadgedBox(badge = { Badge { Text(item.badgeCount.toString()) } }) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.name,
                    modifier = Modifier.size(24.dp)
                )
            }
        } else {
            Icon(
                imageVector = item.icon,
                contentDescription = item.name,
                modifier = Modifier.size(24.dp)
            )
        }
        if (isSelected) {
            Text(
                text = item.name,
                textAlign = TextAlign.Center,
                fontSize = 10.sp
            )
        }
    }
}

/**
 * Sets up the navigation graph for the bottom navigation.
 *
 * This function creates a [NavHost] that switches between different composables
 * based on the current navigation route. It's used in conjunction with a [BottomNavigationBar]
 * to enable switching between different screens like Home, Chat, and Settings.
 *
 * @param navHostController The [NavHostController] that controls the navigation.
 */
@Composable
fun BottomNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("chat") {
            ChatScreen()
        }
        composable("settings") {
            SettingsScreen()
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
