package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column_SpaceBetween_fill_height_scrollable()
//            ScrollableColumn(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.Start
//            ) {
//                for (item in 1..50) {
//                    Text(text = "Column item: $item")
//                }
//            }
        }
    }
}
