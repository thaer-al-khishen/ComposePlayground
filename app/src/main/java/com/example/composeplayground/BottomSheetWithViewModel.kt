package com.example.composeplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.launch

@Composable
fun DisplayMaterial3ModalBottomSheetWithViewModel(
    viewModel: BottomSheetViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    DisplayMaterial3ModalBottomSheetWithViewModelContent(
        viewModel.bottomSheetState.value,
        viewModel::onEvent
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayMaterial3ModalBottomSheetWithViewModelContent(
    state: BottomSheetState,
    event: (BottomSheetEvent) -> Unit = {},
) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        val sheetState = rememberModalBottomSheetState()

        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                event(BottomSheetEvent.OpenBottomSheet)
            }) {
                Text(text = "Open sheet")
            }
        }

        if (state.isBottomSheetOpen) {
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = {
                    event(BottomSheetEvent.CloseBottomSheet)
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
