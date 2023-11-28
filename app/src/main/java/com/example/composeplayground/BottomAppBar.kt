package com.example.composeplayground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FabPosition
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BasicBottomAppBar() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                // Optional cutout for the FAB
                cutoutShape = MaterialTheme.shapes.small.copy(
                    androidx.compose.foundation.shape.CornerSize(
                        percent = 50
                    )
                ),
                content = {
                    IconButton(onClick = { /* Handle navigation icon click */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                    // The actions in the BottomAppBar
                    Spacer(Modifier.weight(1f, true))
                    IconButton(onClick = { /* Handle action icon click */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { /* Handle action icon click */ }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "More")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Handle FAB click */ }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.Center, // Position the FAB in the center
        isFloatingActionButtonDocked = true, // Dock the FAB in the BottomAppBar
        content = { innerPadding ->
            // Your main content goes here
            MainContent(paddingValues = innerPadding)
        }
    )
}

@Composable
fun MainContent(paddingValues: PaddingValues) {
    // Use paddingValues to adjust your layout
    Box(modifier = Modifier.padding(paddingValues)) {
        // Your main content
    }
}

@Composable
fun Material3BottomAppBar() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Check, contentDescription = "Localized description")
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = "Localized description",
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* do something */ },
                        backgroundColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.elevation()
                    ) {
                        Icon(Icons.Filled.Add, "Localized description")
                    }
                }
            )
        },
    ) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = "Example of a scaffold with a bottom app bar."
        )
    }
}
