package com.example.composeplayground.lazycolumn_with_search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.lazycolumn_with_search.ui.theme.ComposePlaygroundTheme
import java.util.*

class SearchableListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchableList()
        }
    }
}

@Composable
fun SearchableList() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val textState = remember { mutableStateOf(TextFieldValue("")) }
        val searchedText = textState.value.text

        SearchView(placeHolder = "Enter text") {
            textState.value = it
        }

        val inventoryList = listOf(
            InventoryItem(itemNumber = "1", itemDescription = "First"),
            InventoryItem(itemNumber = "2", itemDescription = "Second"),
            InventoryItem(itemNumber = "3", itemDescription = "Third"),
            InventoryItem(itemNumber = "4", itemDescription = "Fourth"),
        )

        LazyColumn() {
            items(inventoryList.filter {
                it.itemNumber.contains(searchedText, ignoreCase = true)
                        || it.itemDescription.contains(searchedText, ignoreCase = true)
            }, key = { it.id }) { item ->
                MainScreenItemRow(
                    itemNumber = item.itemNumber,
                    itemDescription = item.itemDescription,
                )
            }
        }
    }
}

data class InventoryItem(
    val id: String = UUID.randomUUID().toString(),
    val itemNumber: String,
    val itemDescription: String
)

@Composable
fun SearchView(
    modifier: Modifier = Modifier,
    placeHolder: String? = "",
    onTextChanged: (TextFieldValue) -> Unit
) {
    val textFieldState = remember {
        mutableStateOf(TextFieldValue(""))
    }
    TextField(
        value = textFieldState.value,
        onValueChange = { value ->
            textFieldState.value = value
            onTextChanged(value)
        },
        placeholder = {
            Text(text = placeHolder ?: "", color = Color.DarkGray)
        },
    )
}

@Composable
fun MainScreenItemRow(
    itemNumber: String,
    itemDescription: String
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = itemNumber, fontSize = 22.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = itemDescription, fontSize = 22.sp)
    }
}
