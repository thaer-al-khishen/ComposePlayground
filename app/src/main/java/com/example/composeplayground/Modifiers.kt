package com.example.composeplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

//Basic Layout Modifiers
//Size Modifiers: Control the size of a composable.
@Composable
fun SizeModifier() {
    Text("Hello, World!", modifier = Modifier.size(100.dp))
}

//Padding: Add space inside or outside the composable's bounds.
@Composable
fun PaddingModifier() {
    Text("Hello, World!", modifier = Modifier.padding(16.dp))
}

//Fill Size: Expand to fill the maximum size in a given dimension.
@Composable
fun FillSizeModifier() {
    Box(modifier = Modifier.fillMaxWidth()) {
        // Content
    }
}


//Alignment and Arrangement

//Align: Align a composable within its parent.
@Composable
fun AlignModifier() {
    Box(modifier = Modifier.size(100.dp)) {
        Text("Hello", Modifier.align(Alignment.Center))
    }
}

//Arrangement: Control the layout of children in Row or Column.
@Composable
fun ArrangementModifier() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text("Start")
        Text("End")
    }
}

//Drawing Modifiers
//Background: Set the background color or shape.
@Composable
fun BackgroundModifier() {
    Text("Hello, World!", modifier = Modifier.background(Color.Blue))
}

//Border: Add a border around the composable.
@Composable
fun BorderModifier() {
    Box(modifier = Modifier.border(2.dp, Color.Black)) {
        // Content
    }
}

//Shadow: Apply elevation to create a shadow.
@Composable
fun ShadowModifier() {
    Card(modifier = Modifier.shadow(4.dp)) {
        // Content
        Text(text = "Hello")
    }
}

//Interaction Modifiers

//Clickable: Make a composable respond to click events.
@Composable
fun ClickableModifier() {
    Text("Click Me", modifier = Modifier.clickable { /* Handle click */ })
}

//Scrolling: Add scrolling behavior to composables.
@Composable
fun ScrollingModifier() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        // Content
    }
}

//Advanced Modifiers

//Aspect Ratio: Maintain a specific aspect ratio.
@Composable
fun AspectRatioModifier() {
    Box(modifier = Modifier.aspectRatio(16f / 9f)) {
        // Content
    }
}

//GraphicsLayer: Apply advanced graphics like rotation or opacity.
@Composable
fun GraphicsLayerModifier() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Image",
        modifier = Modifier.graphicsLayer(alpha = 0.25f, rotationZ = 45f)
    )
}

//ConstraintLayout Modifiers: Use with ConstraintLayout for complex layouts.
@Composable
fun ConstraintLayoutModifier() {
    ConstraintLayout {
        val (text, button) = createRefs()

        Text("Text", Modifier.constrainAs(text) { top.linkTo(parent.top) })
        Button(onClick = {}, Modifier.constrainAs(button) { top.linkTo(text.bottom) }) {
            Text("Button")
        }
    }
}

//Combining Modifiers
@Composable
fun CombiningModifiers() {
    Text(
        "Hello, World!",
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Blue)
            .size(200.dp)
            .border(5.dp, Color.Red)
    )
}
