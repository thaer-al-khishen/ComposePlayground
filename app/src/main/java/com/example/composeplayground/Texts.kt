package com.example.composeplayground

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleText() {
    Text("Hello, Jetpack Compose!")
}

//You can style the text in various ways, including font size, color, weight, and more:
@Composable
fun StyledText() {
    Text(
        text = "Stylish Text",
        color = Color.Blue,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic
    )
}

//To apply multiple styles within the same Text element, use AnnotatedString:
@Composable
fun MultiStyledText() {
    val annotatedText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Red)) {
            append("Red ")
        }
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)) {
            append("Bold ")
        }
        append("Text")
    }

    Text(annotatedText)
}

//You can align text and handle how text overflows its container:
@Composable
fun AlignedText() {
    Text(
        "Aligned Text Aligned Text Aligned Text Aligned Text Aligned Text Aligned Text Aligned Text Aligned Text",
        modifier = Modifier.width(150.dp),
        textAlign = TextAlign.Center,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

//Text can also be made interactive, such as making a part of the text clickable:
@Composable
fun ClickableTextComposable() {
    val context = LocalContext.current
    val annotatedText = buildAnnotatedString {
        append("Click ")
        pushStringAnnotation(tag = "URL", annotation = "https://www.example.com")
        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
            append("here")
        }
        pop()
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(tag = "URL", start = 0, end = annotatedText.length)
                .firstOrNull { annotation ->
                    offset in annotation.start..annotation.end
                }?.let { annotation ->
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item)))
                }
        }
    )
}

//You can use custom fonts for your text:
@Composable
fun CustomFontText() {
    val customFont = FontFamily(Font(R.font.rockb, FontWeight.Normal))
    Text("Custom Font Text", fontFamily = customFont, fontSize = 16.sp)
}
