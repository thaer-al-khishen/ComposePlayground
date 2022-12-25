package com.example.composeplayground.project_x.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.composeplayground.project_x.landing.landingNavGraph

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.LANDING
    ) {
        landingNavGraph(navController = navController)
    }
}
