package com.example.composeplayground

import androidx.compose.runtime.Composable

@Composable
fun FAQScreen() {
    val faqItems = listOf(
        FAQItem("Question 1", "Answer 1"),
        FAQItem("Question 2", "Answer 2"),
        FAQItem("Question 3", "Answer 3"),
        FAQItem("Question 4", "Answer 4"),
        FAQItem("Question 5", "Answer 5"),
        // Add more items
    )

    FAQList(faqItems = faqItems)
}
