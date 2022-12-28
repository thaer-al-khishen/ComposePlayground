package com.example.composeplayground.youtube.part_12_navigation

//import android.os.Build
//import android.os.Parcelable
//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material.Button
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.style.TextAlign
//import com.example.composeplayground.youtube.part_12_navigation.destinations.PostScreenDestination
//import com.example.composeplayground.youtube.part_12_navigation.destinations.ProfileScreenDestination
//import com.ramcosta.composedestinations.annotation.Destination
//import com.ramcosta.composedestinations.navigation.DestinationsNavigator
//import kotlinx.parcelize.Parcelize
//import java.time.LocalDateTime
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Destination(start = true)
//@Composable
//fun LoginScreen(
//    navigator: DestinationsNavigator
//) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Login Screen")
//        Button(onClick = {
//            navigator.navigate(
//                ProfileScreenDestination(
//                    User(
//                        name = "Chris P. Bacon",
//                        id = "userid",
//                        created = LocalDateTime.now()
//                    )
//                )
//            )
////            {
////                popUpTo(LoginScreenDestination.route) {inclusive = true}
////            }
//        }) {
//            Text("Go to Profile Screen")
//        }
//    }
//}
//
//@Destination
//@Composable
//fun ProfileScreen(
//    navigator: DestinationsNavigator,
//    user: User
//) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Profile Screen: $user", textAlign = TextAlign.Center)
//        Button(onClick = {
//            navigator.navigate(PostScreenDestination()) {
//                popUpTo(ProfileScreenDestination.route) {inclusive = true}
//            }
//        }) {
//            Text("Go to Post Screen")
//        }
//    }
//}
//
//@Destination
//@Composable
//fun PostScreen(
//    showOnlyPostsByUser: Boolean = false
//) {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(text = "Post Screen, $showOnlyPostsByUser")
//    }
//}
//
//@Parcelize
//data class User(
//    val name: String,
//    val id: String,
//    val created: LocalDateTime
//): Parcelable
