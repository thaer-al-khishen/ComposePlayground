package com.example.composeplayground

import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

data class AppTheme(
    val primaryColor: Color,
    val typography: Typography,
    // Add other theming properties as needed
)

// Example theme
val LightTheme = AppTheme(
    primaryColor = Color.Blue,
    typography = Typography(defaultFontFamily = FontFamily.SansSerif)
)

val LocalAppTheme = compositionLocalOf { LightTheme } // Default to light theme

@Composable
fun CompositionLocalSample() {
    // You can dynamically change the theme based on user preferences or system settings
    val currentTheme = LightTheme // This could be dynamic

    CompositionLocalProvider(LocalAppTheme provides currentTheme) {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "home") {
            composable("home") { HomeScreen() }
            // other destinations
        }
    }
}

@Composable
fun HomeScreen() {
    val appTheme = LocalAppTheme.current

    Text(
        text = "Welcome to the Home Screen",
        color = appTheme.primaryColor,
        style = appTheme.typography.h6
    )
    // Other UI elements that use the theme
}


//Generally used for app wide constants: DarkMode, fontsize...
//val LocalUserPreferences = compositionLocalOf { UserPreferences() }
//
//data class UserPreferences(val isDarkMode: Boolean, val fontSize: Float)
//
//@Composable
//fun MyApp(userPreferences: UserPreferences) {
//    CompositionLocalProvider(LocalUserPreferences provides userPreferences) {
//        // Your app content
//    }
//}
//
//@Composable
//fun UserProfile() {
//    val userPreferences = LocalUserPreferences.current
//    // Adjust UI based on user preferences
//}
