package com.example.composeplayground.youtube.part_24_bottom_sheets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class BottomSheetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomSheetScreen()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetScreen() {   //You can define a composable parameter here
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed,
//                animationSpec = spring(
//                    dampingRatio = Spring.DampingRatioHighBouncy
//                )
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            Card(
                elevation = 4.dp,
                shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp),
                backgroundColor = Color.Cyan,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp) //Not specifying this is like wrap content
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Bottom sheet", fontSize = 60.sp)
                }
            }


        },
//        sheetBackgroundColor = Color.Green,
        sheetPeekHeight = 0.dp  //Responsible for initially hiding the bottom sheet
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        )
        {
            Button(onClick = {
                scope.launch {
                    if (sheetState.isCollapsed)
                        sheetState.expand()
                    else sheetState.collapse()
                }
            }) {
                Text(text = "Bottom sheet fraction: ${sheetState.progress.fraction}")
            }
        }
    }
}