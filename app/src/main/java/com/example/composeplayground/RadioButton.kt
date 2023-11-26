package com.example.composeplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BasicRadioButtonExample() {
    val radioOptions = listOf("Option 1", "Option 2")
    var selectedOption by remember { mutableStateOf(radioOptions.first()) }

    Column {
        radioOptions.forEach { text ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    //The below selectable makes the whole row selectable
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { selectedOption = text }
                    )
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { selectedOption = text }
                )
                Text(text = text, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}

@Composable
fun Material3RadioButtonExample() {
    val radioOptions = listOf("Option 1", "Option 2")
    var selectedOption by remember { mutableStateOf(radioOptions.first()) }

    Column {
        radioOptions.forEach { text ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { selectedOption = text }
                    )
            ) {
                androidx.compose.material3.RadioButton(
                    selected = (text == selectedOption),
                    onClick = { selectedOption = text }
                )
                Text(text = text, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}
