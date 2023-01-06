package com.example.composeplayground.capture_screenshot

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.composeplayground.utils.base.saveBitmap
import com.example.composeplayground.utils.base.saveMediaToStorage
import com.example.composeplayground.youtube.part_20_request_permissions.handleCameraPermission
import com.example.composeplayground.youtube.part_20_request_permissions.handleReadExternalStoragePermission
import com.example.composeplayground.youtube.part_20_request_permissions.handleRecordAudioPermission
import com.example.composeplayground.youtube.part_20_request_permissions.handleWriteExternalStoragePermission
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import dev.shreyaspatil.capturable.Capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController

class CaptureScreenshotActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckPermissionsAndShowScreen()
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CheckPermissionsAndShowScreen() {

    val permissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    )

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                permissionState.launchMultiplePermissionRequest()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        permissionState.permissions.forEach { permission ->
            when (permission.permission) {
                Manifest.permission.READ_EXTERNAL_STORAGE -> {
                    permission.handleReadExternalStoragePermission {}
                }
                Manifest.permission.WRITE_EXTERNAL_STORAGE -> {
                    permission.handleWriteExternalStoragePermission {
                        CaptureScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun CaptureScreen() {

    val captureController = rememberCaptureController()
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Capturable(
            controller = captureController,
            onCaptured = { bitmap, error ->
                // This is captured bitmap of a content inside Capturable Composable.
                if (bitmap != null) { // Bitmap is captured successfully. Do something with it!
                    saveMediaToStorage(context, bitmap = bitmap.asAndroidBitmap())
//                    bitmap.asAndroidBitmap().saveBitmap(context = context)
                    Log.d("ThaerOutput", "Saved")
                }

                if (error != null) {
                    // Error occurred. Handle it!
                    Log.d("ThaerOutput", "Failed to save")
                }
            }
        ) {
            // Composable content to be captured.
            // Here, `MovieTicketContent()` will be get captured
            ContentToCapture()
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            captureController.capture()}
        ) {
            Text(text = "Take screenshot")
        }
    }

}

@Composable
fun ContentToCapture() {
    Column(
        modifier = Modifier.fillMaxWidth().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the content we want to capture")
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "This could display an image")
    }
}
