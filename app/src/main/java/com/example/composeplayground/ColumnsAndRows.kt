package com.example.composeplayground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MixColumnAndRow() {
    CenterInColumn {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Left Text")
            Column {
                Text(text = "Top Text")
                Text(text = "Bottom Text")
            }
        }
    }
}

@Composable
fun MixColumnAndRow_Aligned_Center() {
    CenterInColumn {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Left Text")
            Column {
                Text(text = "Top Text")
                Text(text = "Bottom Text")
            }
        }
    }
}
