package com.example.composeplayground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.launch

@Composable
fun SimpleScaffold() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Simple Scaffold") }) }
    ) { innerPadding ->
        Content(innerPadding)
    }
}

@Composable
fun Content(padding: PaddingValues) {
    Box(modifier = Modifier.padding(padding)) {
        Text("Hello from Scaffold!")
    }
}

@Composable
fun FABScaffold() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("FAB Scaffold") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Handle click */ }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        Content(innerPadding)
    }
}

@Composable
fun ComplexScaffold() {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = { Text("Complex Scaffold") }) },
        bottomBar = { BottomAppBar { /* Bottom bar content */ } },
        drawerContent = { DrawerContent() },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Handle click */ }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        Content(innerPadding)
    }
}

@Composable
fun DrawerContent() {
    // Drawer content goes here
}

@Composable
fun StatefulScaffold() {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Stateful Scaffold") },
                navigationIcon = {
                    IconButton(onClick = { coroutineScope.launch { scaffoldState.drawerState.open() } }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        drawerContent = { DrawerContent() }
    ) { innerPadding ->
        Content(innerPadding)
    }
}
