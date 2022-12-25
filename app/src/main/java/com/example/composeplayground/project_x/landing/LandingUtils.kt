package com.example.composeplayground.project_x.landing

sealed class LandingScreen(val route: String) {
    object Login : LandingScreen(route = "LOGIN")
    object SignUp : LandingScreen(route = "SIGN_UP")
    object Forgot : LandingScreen(route = "FORGOT")
}
