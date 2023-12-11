package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composeplayground.bundle_arguments.BundleArgumentsNavigation
import com.example.composeplayground.json.JsonAppNavigation
import com.example.composeplayground.local_composition.CompositionLocalSample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalSample()
        }
    }
}
