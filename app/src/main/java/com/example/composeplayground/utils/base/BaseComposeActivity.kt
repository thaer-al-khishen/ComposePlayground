package com.example.composeplayground.utils.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.*

open class BaseComposeActivity : ComponentActivity() {

    protected var composables: ArrayList<@Composable () -> Unit> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }

//    fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.withComposable(composable: Composable) {
//        composables.add(composable)
//    }
//
//    @Composable
//    fun ConstraintSet.CreateConstraintLayout() =
//        ConstraintLayout(constraintSet = this, modifier = Modifier.fillMaxSize()) {
//            for (composable in composables) {
//                composable
//            }
//            composables.clone()
//        }

    fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.assignComposable(composable: @Composable () -> Unit) {
        composables.add((composable))
    }

    @Composable
    fun ConstraintSet.ExtractComposables() {
        ConstraintLayout(constraintSet = this, modifier = Modifier.fillMaxSize()) {
            for (composable in composables) {
                composable.invoke()
            }
        }
    }

    @Composable
    fun ExtractComposables() {
        for (composable in composables) {
            composable.invoke()
        }
    }

}
