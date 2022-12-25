package com.example.composeplayground.project_x.landing

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.composeplayground.project_x.home.HomeScreen
import com.example.composeplayground.project_x.root.Graph

fun NavGraphBuilder.landingNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.LANDING,
        startDestination = LandingScreen.Login.route
    ) {
        composable(route = LandingScreen.Login.route) {
            LoginScreen(
                onLoginClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                },
                onSignUpClick = {
                    navController.navigate(LandingScreen.SignUp.route)
                },
                onForgotClick = {
                    navController.navigate(LandingScreen.Forgot.route)
                }
            )
        }
        composable(route = Graph.HOME) {
            HomeScreen()
        }
        composable(route = LandingScreen.SignUp.route) {
            SignUp()
        }
        composable(route = LandingScreen.Forgot.route) {
            Forgot()
        }
    }
}
