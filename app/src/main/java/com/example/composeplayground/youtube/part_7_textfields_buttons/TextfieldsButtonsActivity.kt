package com.example.composeplayground.youtube.part_7_textfields_buttons

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.youtube.part_7_textfields_buttons.ui.theme.ComposePlaygroundTheme
import kotlinx.coroutines.launch

class TextfieldsButtonsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scaffoldState = rememberScaffoldState()
            val textFieldState = remember {
                mutableStateOf("")
            }
            //The below represents a string directly instead of a mutableState
            var textFieldStateByDelegate by remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope()

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {    //A layout in compose which helps us work with material components
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(value = textFieldStateByDelegate, label = {
                        "Enter your name"
                    }, onValueChange = {
                        textFieldStateByDelegate = it
                    },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(
                                textFieldStateByDelegate, "",
                                SnackbarDuration.Short
                            )
                        }
                    }) {
                        Text(text = "Please Greet Me")
                    }
                }
            }
            Snackbar() {
                Text(text = "Hello")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    val scaffoldState = rememberScaffoldState()
    val textFieldState = remember {
        mutableStateOf("")
    }
    //The below represents a string directly instead of a mutableState
    var textFieldStateByDelegate by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {    //A layout in compose which helps us work with material components
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            //Initial text and hint
            TextField(value = textFieldStateByDelegate, label = {
                Text(text = "Enter your name")
            }, onValueChange = {
                textFieldStateByDelegate = it
            },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        textFieldStateByDelegate, "",
                        SnackbarDuration.Short
                    )
                }
            }) {
                Text(text = "Please Greet Me")
            }
        }
    }
}