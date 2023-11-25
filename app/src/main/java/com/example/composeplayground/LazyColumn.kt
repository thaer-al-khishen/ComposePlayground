package com.example.composeplayground

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//Basic Implementation
@Composable
fun SimpleLazyColumn() {
    val list = (1..100).map { "Item #$it" }
    LazyColumn {
        items(list) { item ->
            Text(text = item, modifier = Modifier.padding(8.dp))
        }
    }
}
//In this example, LazyColumn takes a lambda where you define how each item in the list should be displayed.
// The items function is used to loop over the list, and for each item, a Text composable is used to display the item.


//Handling User Input
//To handle clicks or other interactions within items of a LazyColumn, you can add modifiers to the item composables. Here's an example:

@Composable
fun ClickableLazyColumn() {
    val list = (1..100).map { "Clickable Item #$it" }

    LazyColumn {
        items(list) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { onItemClicked(item) }
                    .background(Color.LightGray)
                    .padding(16.dp)
            )
        }
    }
}

private fun onItemClicked(item: String) {
    // Handle the item click
    Log.d("ClickableLazyColumn", "Clicked on $item")
}

//In this ClickableLazyColumn, each Text composable is wrapped with a clickable modifier.
// When an item is clicked, the onItemClicked function is called with the item as its argument.

//Customization: LazyColumn can be customized further. You can add headers, footers, or even grid-like arrangements using LazyVerticalGrid.
//Performance Tips: For complex items or items with images, consider using remember and key to maintain state and performance.
//Scroll State: You can control or observe the scroll position using rememberLazyListState.

@Composable
fun LazyColumnWithHeaderAndFooter() {
    val list = (1..50).map { "Item #$it" }
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        item { Text("Header", modifier = Modifier.padding(8.dp)) }
        items(list, key = {it}) { item ->
            Text(text = item, modifier = Modifier.padding(8.dp))
        }
        item { Text("Footer", modifier = Modifier.padding(8.dp)) }
    }
}
