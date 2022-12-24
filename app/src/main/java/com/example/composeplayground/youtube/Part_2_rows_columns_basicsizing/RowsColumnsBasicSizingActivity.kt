package com.example.composeplayground.youtube.Part_2_rows_columns_basicsizing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class RowsColumnsBasicSizingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxSize(),
                //Main axis is the vertical axis, the cross axis is the horizontal axis
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Android")
                Text("Android")
            }
        }
    }

    @Composable
    fun ColumnHelper() {
        Column(
            modifier = Modifier
                .background(Color.Green)
                .fillMaxSize(),
            //Main axis is the vertical axis, the cross axis is the horizontal axis
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Android")
            Text("Android")
        }
    }

    @Composable
    fun RowHelper() {
        Row(
            modifier = Modifier
                .background(Color.Green)
                .fillMaxSize(),
//                .fillMaxHeight()
//                .fillMaxWidth(0.2f),
//                .fillMaxSize(),
//                .width(200.dp)
//                .height(100.dp),
//                .fillMaxSize(0.5f),   //Percentage of width and height
            //Main axis is the vertical axis, the cross axis is the horizontal axis
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Android")
            Text("Android")
        }
    }
}
