package com.example.composeplayground.youtube.part_23_pagination

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    suspend fun reset()
}