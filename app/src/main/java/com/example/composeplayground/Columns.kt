package com.example.composeplayground

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun NormalColumn_Top_Left_Position() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.Top
    ) {
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
    }
}

@Composable
fun NormalColumn_Top_Center_Position() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
    }
}

@Composable
fun NormalColumn_Top_End_Position() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ) {
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
    }
}

@Composable
fun NormalColumn_Middle_Left_Position() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.Center
    ) {
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
    }
}

@Composable
fun NormalColumn_Middle_Center_Position() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
    }
}

@Composable
fun NormalColumn_Middle_End_Position() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
    }
}

@Composable
fun NormalColumn_Bottom_Left_Position() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.Bottom
    ) {
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
    }
}

@Composable
fun NormalColumn_Bottom_Center_Position() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
    }
}

@Composable
fun NormalColumn_Bottom_End_Position() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
    }
}

@Composable
fun NormalColumn_Middle_SpaceEvenly_Position() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.SpaceEvenly,  //Divides the content equally, in this case, you get 33% height, Text, 33% height, Text, 33% height
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Android")
        Text("Android")
    }
}

@Composable
fun NormalColumn_Middle_SpaceBetween_Position() {
    Column(
        modifier = Modifier.fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.SpaceBetween,  //Divides the content equally, like SpaceEvenly, but in this case, the start and end composables inside the content are at the edges of the screen
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android", modifier = Modifier.padding(bottom = 100.dp))
    }
}

@Composable
fun NormalColumn_Middle_SpaceBetween_Center_Text_Position() {
    Column(
        modifier = Modifier.fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.SpaceBetween,  //Divides the content equally, like SpaceEvenly, but in this case, the start and end composables inside the content are at the edges of the screen
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CenterInColumn(
            modifier = Modifier
                .padding(top = 100.dp)
                .height(150.dp)
                .fillMaxWidth()
                .background(
                    Color.Blue
                ),
        ) {
            Text(
                text = "Android",
                color = Color.White, textAlign = TextAlign.Center
            )
        }
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android", modifier = Modifier.padding(bottom = 100.dp))
    }
}

@Composable
fun NormalColumn_Middle_SpaceAround_Center_Text_Position() {
    Column(
        modifier = Modifier.fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.SpaceAround,  //Divides the content equally, like SpaceEvenly, but in this case, the start and end composables have a margin from the vertical ends of the screen, this margin is equal to half the space between every 2 composables inside this scope
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
    }
}

@Composable
fun NormalColumn_Middle_SpacedBy() {
    Column(
        modifier = Modifier.fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.spacedBy(50.dp),  //Divides the content with this margin between every 2 adjacent composables, no margins to the edges of the screen
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
        Text("Android")
    }
}

@Composable
fun CenterInColumn(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}

@Composable
fun NormalColumn_Middle_SpaceBetween_fill_height() {
    Column(
        modifier = Modifier.fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.SpaceBetween,  //Divides the content equally, like SpaceEvenly, but in this case, the start and end composables inside the content are at the edges of the screen
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Android")
        CenterInColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(0.5f)
                .background(
                    Color.Red
                ),
        ) {
            Text(
                text = "Android",
                color = Color.White, textAlign = TextAlign.Center
            )
        }
        Text("Android", modifier = Modifier.padding(bottom = 100.dp))
    }
}

@Composable
fun Column_SpaceBetween_fill_height_scrollable() {
    Column(
        modifier = Modifier.fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.SpaceBetween,  //Divides the content equally, like SpaceEvenly, but in this case, the start and end composables inside the content are at the edges of the screen
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Android")
        ScrollableColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(0.5f)
                .background(
                    Color.Red
                ),
        ) {
            for (item in 1..50) {
                Text(text = "Column item: $item")
            }
        }
        Text("Android", modifier = Modifier.padding(bottom = 100.dp))
    }
}

@Composable
fun NormalColumn_Top_Left_Position_Clickable() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //Main axis is the vertical axis, the cross axis is the horizontal axis
        verticalArrangement = Arrangement.Top
    ) {
        Text("Android", modifier = Modifier.clickable {
            Log.d("AndroidOutput", "Clicked on first Text")
        })
        Text("Android")
        Text("Android")
        Text("Android")
    }
}

@Composable
fun ScrollableColumn(
    modifier: Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Center,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable ColumnScope.() -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(scrollState),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
        //Main axis is the vertical axis, the cross axis is the horizontal axis
    ) {
        content()
    }
}
