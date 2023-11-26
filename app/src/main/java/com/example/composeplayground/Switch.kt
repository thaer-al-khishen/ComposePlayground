package com.example.composeplayground

import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun BasicSwitchExample() {
    var checked by remember { mutableStateOf(false) }

    Switch(
        checked = checked,
        onCheckedChange = { checked = it }
    )
}

@Composable
fun Material3SwitchExample() {
    var checked by remember { mutableStateOf(false) }

    androidx.compose.material3.Switch(
        checked = checked,
        onCheckedChange = { checked = it }
    )
}
