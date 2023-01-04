package com.example.composeplayground.complex_navigation.home

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.complex_navigation.home.details.detailsNavGraph
import com.example.composeplayground.complex_navigation.root.Graph

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        HomeNavGraph(navController = navController)
    }
}

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            Home(onDetailsClicked = {
                navController.navigate(Graph.DETAILS)
            })
        }
        composable(route = BottomBarScreen.Profile.route) {
            Profile()
        }
        composable(route = BottomBarScreen.Settings.route) {
            Settings()
        }
        detailsNavGraph(navController = navController)

    }
}
