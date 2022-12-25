package com.example.composeplayground.project_x.home.details

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.composeplayground.project_x.SimpleScreenContent

@Composable
fun NavController.DetailsInformation() {
    SimpleScreenContent(name = DetailsScreen.Information.route) {
        this.navigate(DetailsScreen.Overview.route)
    }
}

@Composable
fun NavController.DetailsOverview() {
    SimpleScreenContent(name = DetailsScreen.Overview.route) {
        this.popBackStack(
            route = DetailsScreen.Information.route,
            inclusive = false
        )
    }
}