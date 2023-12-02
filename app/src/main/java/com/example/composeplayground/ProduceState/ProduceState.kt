package com.example.composeplayground.ProduceState

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import kotlinx.coroutines.flow.Flow

//@Composable
//fun UserProfileScreen(userId: String, viewModel: UserViewModel) {
//    val userData = produceState<String?>(initialValue = null, key1 = userId) {
//        value = viewModel.getUserData(userId)
//    }
//
//    userData.value?.let { user ->
//        // UI code to display user data
//    }
//}


//@Composable
//fun ContentScreen(apiService: ApiService) {
//    val contentState = produceState<Content?>(initialValue = null) {
//        value = apiService.fetchContent()
//    }
//
//    // UI code to display the content
//}


@Composable
fun FlowExample(flow: Flow<String>) {
    val flowState = produceState(initialValue = "", key1 = flow) {
        flow.collect { value = it }
    }

    Text(text = flowState.value)
}


//@Composable
//fun LocationExample(locationProvider: LocationProvider) {
//    val locationState = produceState<Location?>(initialValue = null) {
//        locationProvider.requestLocation { location ->
//            value = location
//        }
//    }
//
//    // UI code to display location
//}
