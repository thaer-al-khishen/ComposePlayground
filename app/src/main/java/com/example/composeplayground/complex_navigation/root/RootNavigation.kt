package com.example.composeplayground.complex_navigation.root

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeplayground.complex_navigation.home.details.DetailsScreen
import com.example.composeplayground.complex_navigation.landing.LandingScreen
import com.example.composeplayground.complex_navigation.landing.LoginScreen
import com.example.composeplayground.complex_navigation.landing.landingNavGraph
import com.example.composeplayground.event_bus_pattern.LogoutListenerComposable
import com.example.composeplayground.youtube.part_12_navigation.DetailScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.LANDING
    ) {
        landingNavGraph(navController = navController)
//        composable(route = LandingScreen.Login.route) {
//            LoginScreen(
//                onLoginClick = {
//                    navController.popBackStack()
//                    navController.navigate(Graph.HOME)
//                },
//                onSignUpClick = {
//                    navController.navigate(LandingScreen.SignUp.route)
//                },
//                onForgotClick = {
//                    navController.navigate(LandingScreen.Forgot.route)
//                }
//            )
//        }
    }
    LogoutListenerComposable {
        navController.navigate(route = Graph.LANDING) {
            popUpTo(navController.currentDestination?.route ?: "") { inclusive = true }
        }
//        navController.navigate(route = LandingScreen.Login.route) {
//            popUpTo(navController.currentDestination?.route ?: "") { inclusive = true }
//        }
    }

}
