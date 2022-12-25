package com.example.composeplayground.project_x.home.details

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.composeplayground.project_x.SimpleScreenContent

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