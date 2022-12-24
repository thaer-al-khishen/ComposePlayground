package com.example.composeplayground.youtube.base

import android.net.Uri
import androidx.navigation.NavBackStackEntry
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> getObject(url: String): T {
    val type = object : TypeToken<T>() {}.type
    return Gson().fromJson(url, type)
}

inline fun <reified T> NavBackStackEntry.deriveObjectWithTag(tag: String): T? {
    val genericData = this.arguments?.getString(tag)
    if (genericData != null) {
        return getObject(genericData ?: "")
    } else return null
}

fun Any.toJsonString(): String {
    return Uri.encode(Gson().toJson(this))
}
