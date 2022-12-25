package com.example.composeplayground.project_x.home.details

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.composeplayground.project_x.root.Graph

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {
            navController.DetailsInformation()
        }

        composable(route = DetailsScreen.Overview.route) {
            navController.DetailsOverview()
        }
    }
}