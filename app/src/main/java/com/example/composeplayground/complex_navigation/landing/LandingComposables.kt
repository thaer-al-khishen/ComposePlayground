package com.example.composeplayground.complex_navigation.landing

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeplayground.ScreenViewModel
import com.example.composeplayground.complex_navigation.SimpleScreenContent
import com.example.composeplayground.complex_navigation.collectAsStateLifecycleAware

@Composable
fun SignUp() {
    SimpleScreenContent(name = LandingScreen.SignUp.route) {}
}

@Composable
fun Forgot() {
    SimpleScreenContent(name = LandingScreen.Forgot.route) {}
}

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotClick: () -> Unit,
    screenViewModel: ScreenViewModel = viewModel()
) {
//    val screenState = screenViewModel.uiState
    val screenState = screenViewModel.uiState.collectAsStateLifecycleAware()
    Log.d("TutorialTest","---> counter update: ${screenState.value.accountNumber}")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.clickable { onLoginClick() },
            text = "LOGIN",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.clickable { onSignUpClick() },
            text = "Sign Up",
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Medium
        )
        Text(
            modifier = Modifier.clickable { onForgotClick() },
            text = screenState.value.accountNumber,
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Medium
        )
    }
}