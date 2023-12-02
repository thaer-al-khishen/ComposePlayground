package com.example.composeplayground

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Button(onClick = { count++ }) {
        Text("Clicked $count times")
    }
}

@Composable
fun Greeting(name: String) {
    val greeting = mutableStateOf("Hello, $name")

    // Use greeting.value to read or modify the state
    Text(text = greeting.value)
}

@Composable
fun CounterScreen() {
    var count by remember { mutableStateOf(0) }
    StatelessCounter(count, onCountChanged = { count = it })
}

@Composable
fun StatelessCounter(count: Int, onCountChanged: (Int) -> Unit) {
    Button(onClick = { onCountChanged(count + 1) }) {
        Text("Clicked $count times")
    }
}

@Composable
fun UserInputForm() {
    var name by remember { mutableStateOf("") }

    TextField(
        value = name,
        onValueChange = { name = it },
        label = { Text("Enter your name") }
    )
}
