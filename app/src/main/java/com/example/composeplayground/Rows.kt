package com.example.composeplayground

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Simple_Row() {
    Row {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Simple_Row_Top_Start() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Top
    ) {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Simple_Row_Middle_Start() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Simple_Row_Bottom_Start() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Simple_Row_Top_Center() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Simple_Row_Middle_Center() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Simple_Row_Bottom_Center() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Simple_Row_Top_End() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.End
    ) {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Simple_Row_Middle_End() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Simple_Row_Bottom_End() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End
    ) {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Row_Middle_SpaceEvenly() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Row_Middle_SpaceBetween() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Row_Middle_SpaceAround() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Row_Middle_SpacedBy() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(60.dp)
    ) {
        Text(text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Row_SpaceBetween_fill_Width() {
    Row(
        modifier = Modifier.fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        horizontalArrangement = Arrangement.SpaceBetween,  //Divides the content equally, like SpaceEvenly, but in this case, the start and end composables inside the content are at the edges of the screen
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text("Android")
        Text(
            "Android",
            modifier = Modifier
                .weight(1f) // This will make the Text composable fill the available space
                .padding(horizontal = 8.dp) // Optional padding for better visual appearance
                .background(Color.Cyan) // Set the background color to Cyan
        )
        Text("Android", modifier = Modifier.padding(end = 100.dp))
    }
}

@Composable
fun Row_SpaceBetween_Center_Text_fill_Width() {
    Row(
        modifier = Modifier.fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        horizontalArrangement = Arrangement.SpaceBetween,  //Divides the content equally, like SpaceEvenly, but in this case, the start and end composables inside the content are at the edges of the screen
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text("Android")
        Center_Row(
            modifier = Modifier
                .weight(1f) // This will make the Text composable fill the available space
                .padding(horizontal = 8.dp) // Optional padding for better visual appearance
                .background(Color.Cyan) // Set the background color to Cyan
        ) {
            Text("Android")
        }
        Text("Android", modifier = Modifier.padding(end = 100.dp))
    }
}

@Composable
fun Simple_Row_Bottom_Start_Clickable() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(modifier = Modifier.clickable { Log.d("Simple_Row", "Clicked on text") }, text = "Android")
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun Center_Row(modifier: Modifier = Modifier, content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        content = content
    )
}

@Composable
fun ScrollableRow(
    modifier: Modifier,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    content: @Composable RowScope.() -> Unit
) {
    val scrollState = rememberScrollState()
    Row(
        modifier = modifier
            .horizontalScroll(scrollState),
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement,
    ) {
        content()
    }
}
