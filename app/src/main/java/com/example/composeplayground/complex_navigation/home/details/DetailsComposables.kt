package com.example.composeplayground.complex_navigation.home.details

import androidx.compose.runtime.Composable
import com.example.composeplayground.complex_navigation.SimpleScreenContent

@Composable
fun DetailsInformation(onInformationClicked: () -> Unit) {
    SimpleScreenContent(name = DetailsScreen.Information.route) {
        onInformationClicked.invoke()
    }
}

@Composable
fun DetailsOverview(onOverviewClicked: () -> Unit) {
    SimpleScreenContent(name = DetailsScreen.Overview.route) {
        onOverviewClicked.invoke()
    }
}