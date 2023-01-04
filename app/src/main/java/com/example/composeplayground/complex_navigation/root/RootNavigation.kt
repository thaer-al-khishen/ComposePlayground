package com.example.composeplayground.complex_navigation.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.composeplayground.complex_navigation.landing.landingNavGraph
import com.example.composeplayground.utils.base.LoadingListenerComposable
import com.example.composeplayground.utils.base.LogoutListenerComposable

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
    LoadingListenerComposable()


}
