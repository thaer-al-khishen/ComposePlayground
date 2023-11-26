package com.example.composeplayground

import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun BasicCheckBoxExample() {
    var checked by remember { mutableStateOf(false) }

    Checkbox(
        checked = checked,
        onCheckedChange = { checked = it }
    )
}

@Composable
fun Material3CheckBoxExample() {
    var checked by remember { mutableStateOf(false) }

    androidx.compose.material3.Checkbox(
        checked = checked,
        onCheckedChange = { checked = it }
    )
}
