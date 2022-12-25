package com.example.composeplayground.youtube.base

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.composeplayground.youtube.part_12_navigation.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ramcosta.composedestinations.utils.composable

inline fun <reified T> getObject(url: String): T {
    val type = object : TypeToken<T>() {}.type
    return Gson().fromJson(url, type)
}

inline fun <reified T> NavBackStackEntry.deriveObjectWithKey(key: String): T? {
    val genericData = this.arguments?.getString(key)
    if (genericData != null) {
        return getObject(genericData ?: "")
    } else return null
}

fun Any.toJsonString(): String {
    return Uri.encode(Gson().toJson(this))
}

fun NavGraphBuilder.composableWithObject(objectKey: String, route: String, action: @Composable (NavBackStackEntry) -> Unit) {
    with(this) {
        composable(route = "$route{$objectKey}",
            arguments = listOf(
                navArgument(objectKey) {
                    type = NavType.StringType
                }
            )
        ) {
            action.invoke(it)
        }
    }
}

fun NavController.navigateWithObject(route: String, objectJson: String, builder: (NavOptionsBuilder.() -> Unit)? = null) {
    this.navigate("$route$objectJson", builder?.let { navOptions(it) })
}
