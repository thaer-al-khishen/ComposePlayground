package com.example.composeplayground

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter text") }
    )
}

@Composable
fun StyledTextField() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Styled Text") },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Blue,
            backgroundColor = Color.LightGray,
            cursorColor = Color.Red
        )
    )
}

@Composable
fun InputHandlingTextField() {
    var text by remember { mutableStateOf("") }
    val context = LocalContext.current

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter text") },
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            Toast.makeText(context, "Input: $text", Toast.LENGTH_SHORT).show()
        })
    )
}

@Composable
fun ValidatingTextField() {

    var text by remember { mutableStateOf("") }
    val isValid = text.length >= 5
    val context = LocalContext.current

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter at least 5 characters") },
        isError = !isValid,
        trailingIcon = {
            if (!isValid) Icon(
                Icons.Filled.Close, contentDescription = "Error",
//                modifier = Modifier.clickable { Toast.makeText(context, "Input: $text", Toast.LENGTH_SHORT).show() }
            )
        }
    )
}

@Composable
fun PasswordTextField() {
    var text by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Password") },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.CheckCircle else Icons.Filled.Close
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(image, "Toggle password visibility")
            }
        }
    )
}

@Composable
fun BareTextField(
    modifier: Modifier = Modifier,
    placeHolderText: String = "Enter Text",
) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Gray) // Ensure TextField background is transparent
            .padding(8.dp),

        placeholder = { Text(placeHolderText) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent, // Remove underline when focused
            unfocusedIndicatorColor = Color.Transparent // Remove underline when not focused
        )
    )
}
