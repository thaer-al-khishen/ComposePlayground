package com.example.composeplayground.youtube.part_22_support_screen_sizes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenAwareComposable()
        }
    }
}

@Composable
fun ScreenAwareComposable() {
    val windowInfo = rememberWindowInfo()
    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
        DoubleColumnLists()
    } else {
        DoubleRowLists()
    }
}

@Composable
fun DoubleColumnLists() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        //List 1
        items(10) {
            Text(
                text = "Item $it",
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Green)
                    .padding(16.dp)
            )
        }
        //List 2
        items(10) {
            Text(
                text = "Item $it",
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan)
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun DoubleRowLists() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(10) {
                Text(
                    text = "Item $it",
                    fontSize = 25.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green)
                        .padding(16.dp)
                )
            }
        }
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(10) {
                Text(
                    text = "Item $it",
                    fontSize = 25.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Cyan)
                        .padding(16.dp)
                )
            }
        }
    }
}