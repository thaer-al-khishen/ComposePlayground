package com.example.composeplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DisplayMaterial3BottomSheetWithBottomSheetScaffold() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        val scaffoldState = rememberBottomSheetScaffoldState()
        val scope = rememberCoroutineScope()

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetContent = {
                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.kermitt),
                        contentDescription = null
                    )
                }
            },
            sheetPeekHeight = 0.dp
        ) {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    scope.launch {
                        scaffoldState.bottomSheetState.expand()
                    }
                }) {
                    Text(text = "Open sheet")
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayMaterial3ModalBottomSheet() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        val sheetState = androidx.compose.material3.rememberModalBottomSheetState()
        var isSheetOpen by rememberSaveable {
            mutableStateOf(false)
        }

        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                isSheetOpen = true
            }) {
                Text(text = "Open sheet")
            }
        }

        if (isSheetOpen) {
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = {
                    isSheetOpen = false
                },
//                dragHandle = {}   //Use this to remove the drag handle at the top and make the content stick to the top of the sheet
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.kermitt),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetScreen() {   //You can define a composable parameter here
//    val sheetState = rememberBottomSheetState(
//        initialValue = BottomSheetValue.Collapsed,
////                animationSpec = spring(
////                    dampingRatio = Spring.DampingRatioHighBouncy
////                )
//    )
//    val scaffoldState = rememberBottomSheetScaffoldState(
//        bottomSheetState = sheetState
//    )
//    val scope = rememberCoroutineScope()
//
//    BottomSheetScaffold(
//        scaffoldState = scaffoldState, sheetContent = {
//            Card(
//                elevation = 4.dp,
//                shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp),
//                backgroundColor = Color.Cyan,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(300.dp) //Not specifying this is like wrap content
//            ) {
//                Box(
//                    contentAlignment = Alignment.Center
//                ) {
//                    androidx.compose.material.Text(text = "Bottom sheet", fontSize = 60.sp)
//                }
//            }
//
//
//        },
////        sheetBackgroundColor = Color.Green,
//        sheetPeekHeight = 0.dp  //Responsible for initially hiding the bottom sheet
//    ) {
//        Box(
//            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
//        ) {
//            androidx.compose.material.Button(onClick = {
//                scope.launch {
//                    if (sheetState.isCollapsed) sheetState.expand()
//                    else sheetState.collapse()
//                }
//            }) {
//                androidx.compose.material.Text(text = "Bottom sheet fraction: ${sheetState.progress}")
//            }
//        }
//    }
}
