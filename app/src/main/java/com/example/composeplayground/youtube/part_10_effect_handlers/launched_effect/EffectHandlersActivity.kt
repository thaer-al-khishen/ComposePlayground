package com.example.composeplayground.youtube.part_10_effect_handlers.launched_effect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

//Side effects escape the scope of a composable function
//Ex: Incrementing an integer in a compose function

class EffectHandlersActivity : ComponentActivity() {

    //We don't collect flows in a composable function because it is a side effect
    //It will be triggered on every recomposition

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember {
                mutableStateOf("")
            }
            Button(onClick = { text+= "#" }) {
                i++
                Text(text = text)
            }
            //We can use suspend functions here
            //Whenever this text changes, this coroutine would be cancelled and relaunched
            //With the new text value
            LaunchedEffect(key1 = text) {
                delay(1000L)
                println("The text is $text")
                text += "#"
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {

}