package com.example.composeplayground

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun BasicTopAppBar() {
    androidx.compose.material.TopAppBar(
        title = { Text("TopAppBar") },
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation icon click */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { /* Handle action icon click */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Material3SmallTopAppBar() {
    /* Handle action icon click */
    androidx.compose.material3.TopAppBar(
        title = { Text("Small TopAppBar") },
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation icon click */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { /* Handle action icon click */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Material3CenterAlignedTopAppBar() {
    CenterAlignedTopAppBar(
        title = { Text("Center Aligned TopAppBar") },
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation icon click */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { /* Handle action icon click */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Material3LargeTopAppBar() {
    LargeTopAppBar(
        title = { Text("Large TopAppBar") },
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation icon click */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { /* Handle action icon click */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }
        }
    )
}
