package com.example.composeplayground.utils.base

data class GenericResponse <T>(
    var loading: Boolean = false,
    val data: T?
)
