package com.example.composeplayground.youtube.part_12_navigation

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object DetailScreen: Screen("detail_screen")

    //For mandatory arguments
//    fun withArgs(vararg args: String): String {
//        return buildString {
//            append(route)
//            args.forEach { argument ->
//                append("/$argument")
//            }
//        }
//    }

    //For optional arguments
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { argument ->
                append("/?")
                append("$argument=$argument")
            }
        }
    }
}
