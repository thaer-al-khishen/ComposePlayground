package com.example.composeplayground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun SimpleLazyGrid() {
    // Define your data list
    val dataList = (1..100).toList()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // Fixed column count
        // For adaptive columns: GridCells.Adaptive(minSize = 128.dp)
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(dataList) { item ->
            // Your item content
            Text(text = "Item $item")
        }
    }
}
