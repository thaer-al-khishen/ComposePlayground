package com.example.composeplayground

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DropdownFAQItem(faqItem: FAQItem) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable( //This clickable is modified with a null indication and an implementation for interactionSource to remove the grey background onclick
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) { expanded = !expanded }
    ) {
        Text(
            text = faqItem.question,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
        AnimatedVisibility(visible = expanded) {
            Text(
                text = faqItem.answer,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
