package com.example.composeplayground.youtube.part_20_request_permissions

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState


@OptIn(ExperimentalPermissionsApi::class)
fun PermissionState.isPermanentlyDenied(): Boolean {
    return !hasPermission && !shouldShowRationale
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionState.handleCameraPermission() {
    when {
        hasPermission -> {
            Text(text = "Camera permission accepted")
        }
        shouldShowRationale -> {
            Text(text = "Camera permission is needed to access the camera")
        }
        isPermanentlyDenied() -> {
            Text(text = "Cemera permission was permanantly denied. You can enable it in the app settings")
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionState.handleRecordAudioPermission() {
    when {
        hasPermission -> {
            Text(text = "Record audio permission accepted")
        }
        shouldShowRationale -> {
            Text(text = "Record audio permission is needed to Record audio")
        }
        isPermanentlyDenied() -> {
            Text(text = "Record audio was permanantly denied. You can enable it in the app settings")
        }
    }
}