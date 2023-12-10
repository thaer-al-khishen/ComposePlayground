package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composeplayground.bundle_arguments.BundleArgumentsNavigation
import com.example.composeplayground.json.JsonAppNavigation
import com.example.composeplayground.local_composition.CompositionLocalSample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BundleArgumentsNavigation()
        }
    }
}
