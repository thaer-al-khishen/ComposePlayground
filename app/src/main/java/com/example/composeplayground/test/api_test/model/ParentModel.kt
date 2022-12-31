package com.example.composeplayground.test.api_test.model

data class ParentModel <T>(
    val page_count: Int,
    val page_number: Int,
    val page_size: Int,
    val total: Int,
    val data: T
)
