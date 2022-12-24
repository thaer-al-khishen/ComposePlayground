package com.example.composeplayground.youtube.part_6_state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.youtube.part_6_state.ui.theme.ComposePlaygroundTheme
import java.util.*
import kotlin.random.Random

class StateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.fillMaxSize()) {
                val color =
                    remember {  //Remembers the value of this state from the last composition so that it doesn't reset it after every recomposition
                        mutableStateOf(Color.Yellow)
                    }

                ColorBox(
                    Modifier.weight(1f).fillMaxSize()
                ) {
                    color.value = it
                }

                Box(modifier = Modifier
                    .background(color.value)
                    .weight(1f)
                    .fillMaxSize())

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Column(Modifier.fillMaxSize()) {
        val color =
            remember {  //Remembers the value of this state from the last composition so that it doesn't reset it after every recomposition
                mutableStateOf(Color.Yellow)
            }

        ColorBox(
            Modifier.weight(1f).fillMaxSize()
        ) {
            color.value = it
        }

        Box(modifier = Modifier
            .background(color.value)
            .weight(1f)
            .fillMaxSize())

    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {

    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        })
}