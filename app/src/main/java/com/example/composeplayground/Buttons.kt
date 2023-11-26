package com.example.composeplayground

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BasicButtonExample() {
    Button(onClick = { /* Handle click */ }) {
        Text("Click Me")
    }
}

@Composable
fun TextButtonExample() {
    TextButton(onClick = { /* Handle click */ }) {
        Text("Text Button")
    }
}

@Composable
fun OutlinedButtonExample() {
    OutlinedButton(onClick = { /* Handle click */ }) {
        Text("Outlined Button")
    }
}

@Composable
fun CustomColorButton() {
    Button(
        onClick = { /* Handle click */ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Blue,
            contentColor = Color.White
        )
    ) {
        Text("Custom Color Button")
    }
}

@Composable
fun CustomShapeButton() {
    Button(
        onClick = { /* Handle click */ },
        shape = RoundedCornerShape(8.dp)
    ) {
        Text("Rounded Button")
    }
}

@Composable
fun IconButtonExample() {
    Button(onClick = { /* Handle click */ }) {
        Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like")
    }
}

@Composable
fun ElevatedButtonExample() {
    ElevatedButton(onClick = { /* Handle click */ }) {
        Text("Elevated Button")
    }
}

@Composable
fun FilledButtonExample() {
    Button(onClick = { /* Handle click */ }) {
        Text("Filled Button")
    }
}

@Composable
fun FilledTonalButtonExample() {
    FilledTonalButton(onClick = { /* Handle click */ }) {
        Text("Filled Tonal Button")
    }
}
