package com.example.composeplayground.youtube.part_23_pagination

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeplayground.youtube.base.SynchronizedLock

class PaginationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaginatedScreen(SynchronizedLock())
        }
    }
}

@Synchronized
@Composable
fun PaginatedScreen(
    synchronizedLock: SynchronizedLock
) {
    val viewModel = viewModel<MainViewModel>()

    val state = viewModel.state

    var counter by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = counter) {
        Log.d("ThaerOutput", "Counter inside launched effect: $counter")
        viewModel.loadNextItems()
        synchronizedLock.releaseLock()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            state.items.size,
            key = {
                state.items[it].key
            }
        ) { i ->

            val item = state.items[i]

            synchronizedLock.lockWithCondition(condition = i >= state.items.size - 1 && !state.endReached && !state.isLoading) {
                counter++
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = item.title, fontSize = 20.sp, color = Color.Black)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.description)
            }
        }
        item {
            if (state.isLoading) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }

}

fun Boolean.toggle(): Boolean {
    return !this
}

fun LazyListState.isLastItemVisible(): Boolean {
    val lastItem = this.layoutInfo.visibleItemsInfo.lastOrNull()
    return lastItem == null || lastItem.size + lastItem.offset <= this.layoutInfo.viewportEndOffset
}