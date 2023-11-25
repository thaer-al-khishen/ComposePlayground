package com.example.composeplayground

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Boxes are like stacks, they begin at the bottom and then pile up

//Alignment and Positioning
//You can align children inside a Box using Modifier.align(). This is useful for positioning elements in corners, center, or any other alignment.
@Composable
fun BoxWithAlignedChildren() {
    Box(modifier = Modifier.size(200.dp)) {
        Text("Top Start", Modifier.align(Alignment.TopStart))
        Text("Center", Modifier.align(Alignment.Center))
        Text("Bottom End", Modifier.align(Alignment.BottomEnd))
    }
}

//Basic Overlapping
//Box can be used to overlap components, such as putting a Text over an Image.
@Composable
fun ImageWithTextOverlay() {
    Box {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Background Image")
        Text("Overlay Text", Modifier.align(Alignment.Center))
    }
}

//Box is ideal for creating complex UIs where components need to be layered on top of each other.
@Composable
fun ComplexLayering() {
    Box {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Background")
        Column(Modifier.align(Alignment.Center)) {
            Text("Title", style = TextStyle(fontSize = 24.sp))
            Text("Subtitle")
        }
        IconButton(onClick = {}, Modifier.align(Alignment.TopEnd)) {
            Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
        }
    }
}

//Use Box to add backgrounds or other decorations behind composables.
@Composable
fun DecoratedBox() {
    Box(modifier = Modifier.background(Color.Gray)) {
        Text("Content", Modifier.padding(16.dp))
    }
}

//Create a larger clickable area for a small component by wrapping it in a Box.
@Composable
fun ClickableBox() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(100.dp)
            .clickable { Log.d("ClickableBox", "Clicked!") }
    ) {
        Icon(Icons.Filled.Info, contentDescription = "Info")
    }
}

//Maintain an aspect ratio for a component, regardless of its size.
@Composable
fun AspectRatioBox() {
    Box(modifier = Modifier.aspectRatio(16f / 9f)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Aspect Ratio Image",
            modifier = Modifier.fillMaxSize() // This ensures the image scales to fill the Box
        )
    }
}