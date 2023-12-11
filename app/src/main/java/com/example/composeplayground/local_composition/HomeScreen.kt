package com.example.composeplayground.local_composition

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

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
