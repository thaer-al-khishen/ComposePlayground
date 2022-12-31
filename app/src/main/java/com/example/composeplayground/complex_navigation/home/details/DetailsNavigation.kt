package com.example.composeplayground.complex_navigation.home.details

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.composeplayground.complex_navigation.root.Graph

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {
            DetailsInformation(onInformationClicked = {
                navController.navigate(DetailsScreen.Overview.route)
            })
        }

        composable(route = DetailsScreen.Overview.route) {
            DetailsOverview(onOverviewClicked = {
                navController.popBackStack(
                    route = DetailsScreen.Information.route,
                    inclusive = false
                )
            })
        }
    }
}
