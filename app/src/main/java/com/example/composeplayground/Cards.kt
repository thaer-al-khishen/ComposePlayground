package com.example.composeplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SimpleCard() {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.Cyan
    ) {
        Text(
            text = "This is a simple card",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ImageCard(image: Painter, title: String, description: String) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Column {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Text(text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(8.dp))
            Text(text = description, modifier = Modifier.padding(8.dp))
        }
    }
}
