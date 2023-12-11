package com.example.composeplayground.local_composition

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
