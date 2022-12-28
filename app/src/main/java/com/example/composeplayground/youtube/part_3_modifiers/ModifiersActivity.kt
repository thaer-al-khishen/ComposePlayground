package com.example.composeplayground.youtube.part_3_modifiers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.youtube.part_3_modifiers.ui.theme.ComposePlaygroundTheme

class ModifiersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme
            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxHeight(0.5f)
                    .width(300.dp)
                    .padding()
//                    .requiredWidth(200.dp)  //Force into this width
            ) {
                Text("Hello World")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting2() {
    Column(
        modifier = Modifier
                //These attributes will happen sequentially
            .background(Color.Green)
            .fillMaxHeight(0.5f)
            .width(300.dp)
            .padding(20.dp)
//                    .requiredWidth(200.dp)  //Force into this width
            .border(5.dp, Color.Magenta)
            .padding(5.dp)
            .border(5.dp, Color.Blue)
    ) {
        Text("Hello World", modifier = Modifier.clickable {

        })
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Hello")
    }
}
