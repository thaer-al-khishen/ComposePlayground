package com.example.composeplayground

import android.app.Activity
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

@Composable
fun checkPermissionStatus(permission: String): PermissionStatus {
    val context = LocalContext.current
    val activity = LocalContext.current as? Activity

    val isGranted = ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
    val shouldShowRationale = activity?.let { ActivityCompat.shouldShowRequestPermissionRationale(it, permission) } ?: false

    return when {
        isGranted -> PermissionStatus.Granted
        shouldShowRationale -> PermissionStatus.DeniedShouldShowRationale
        else -> PermissionStatus.Denied
    }
}

enum class PermissionStatus {
    Granted,
    Denied,
    DeniedShouldShowRationale
}

@Composable
fun PermissionRequester(
    permission: String,
    onPermissionResult: (Boolean) -> Unit
) {
    val context = LocalContext.current
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted: Boolean ->
            onPermissionResult(isGranted)
        }
    )

    val checkPermission = remember {
        {
            if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
                onPermissionResult(true)
            } else {
                permissionLauncher.launch(permission)
            }
        }
    }

    PermissionRequestButton(onClick = checkPermission)
}

@Composable
fun PermissionRequestButton(onClick: () -> Unit) {
    // Your UI for requesting permission, e.g., a button
    Button(onClick = onClick) {
        Text("Request Permission")
    }
}

@Composable
fun PermissionScreen() {
    val cameraPermissionStatus = checkPermissionStatus(android.Manifest.permission.CAMERA)

    when (cameraPermissionStatus) {
        PermissionStatus.Granted -> {
            // Permission is granted, proceed with the camera functionality
        }
        PermissionStatus.DeniedShouldShowRationale -> {
            // Show rationale and ask for permission again
            PermissionRequester(
                permission = android.Manifest.permission.CAMERA,
                onPermissionResult = { isGranted ->
                    if (isGranted) {
                        Log.d("Permissions", "Permission granted")
                    } else {
                        Log.d("Permissions", "Permission denied")
                    }
                }
            )
        }
        PermissionStatus.Denied -> {
            // Permission denied permanently, direct to settings or disable functionality
            Text("Permission denied. Update your settings to continue.")
            // Optionally, provide a button to open app settings
        }
    }
}
