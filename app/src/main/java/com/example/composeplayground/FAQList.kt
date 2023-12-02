package com.example.composeplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun FAQList(faqItems: List<FAQItem>) {
    Column {
        faqItems.forEach { faqItem ->
            DropdownFAQItem(faqItem = faqItem)
        }
    }
}
