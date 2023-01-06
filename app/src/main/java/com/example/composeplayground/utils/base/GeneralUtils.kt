package com.example.composeplayground.utils.base

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.composeplayground.event_bus_pattern.AppEvent
import com.example.composeplayground.event_bus_pattern.EventBusController
import com.example.composeplayground.utils.GenericData
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.*

object CoroutineScopeHelper {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)
    fun getCoroutineScope(): CoroutineScope {
        return scope
    }
}

inline fun launchFastScope(crossinline action: suspend (CoroutineScope) -> Unit) {
    CoroutineScopeHelper.getCoroutineScope().launch {
        action.invoke(this)
    }
//    scope.launch {
//        action.invoke()
//    }
//    scope.async {
//        action.invoke()
//    }.invokeOnCompletion {
//        scope.cancel()
//    }
}

fun <T : Any, R: Any> State<GenericResponse<GenericData<T>>>.returnedSuccessWith(otherState: State<GenericResponse<GenericData<R>>>): Boolean {
    if (this.value.data is GenericData.Success && otherState.value.data is GenericData.Success) {
        return true
    }
    return false
}

fun <T : Any> Boolean.returnedSuccessWith(otherState: State<GenericResponse<GenericData<T>>>): Boolean {
    if (this && otherState.value.data is GenericData.Success) {
        return true
    }
    return false
}

// this method saves the image to gallery
fun saveMediaToStorage(context: Context, bitmap: Bitmap) {
    // Generating a file name
    val filename = "Compose_background_${System.currentTimeMillis()}.jpg"

    // Output stream
    var fos: OutputStream? = null

    // For devices running android >= Q
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        // getting the contentResolver
        context.contentResolver?.also { resolver ->

            // Content resolver will process the contentvalues
            val contentValues = ContentValues().apply {

                // putting file information in content values
                put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
                put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
                put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
            }

            // Inserting the contentValues to
            // contentResolver and getting the Uri
            val imageUri: Uri? = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

            // Opening an outputstream with the Uri that we got
            fos = imageUri?.let { resolver.openOutputStream(it) }
        }
    } else {
        // These for devices running on android < Q
        val imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val image = File(imagesDir, filename)
        fos = FileOutputStream(image)
    }

    fos?.use {
        // Finally writing the bitmap to the output stream that we opened
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
        Toast.makeText(context , "Captured View and saved to Gallery" , Toast.LENGTH_SHORT).show()
    }
}

fun Bitmap.saveBitmap(context: Context?): Boolean {
    val fileName = "MBankWallet_" + Date().time + ".jpeg"
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) { // To Download File for Android 10 and above
        val content = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
        }
        val uri: Uri? = context?.contentResolver?.insert(
            MediaStore.Downloads.EXTERNAL_CONTENT_URI,
            content
        )
        uri?.apply {
            context.contentResolver?.openOutputStream(uri)?.use { fileOutStream ->
                try {
                    if (!this@saveBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutStream)) {
                        return false
                    }
                    return true
                } catch (ex: Exception) {
                    return false
                }
            }

        }
        return false
    } else { // For Android versions below than 10
        val directory = File(
            Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS
            ).absolutePath
        ).apply {
            if (!exists()) {
                mkdir()
            }
        }
        val file = File(directory, fileName)
        if (file.exists()) file.delete()
        try {
            val out = FileOutputStream(file)
            this.compress(Bitmap.CompressFormat.JPEG, 90, out)
            out.flush()
            out.close()
            return true
        } catch (e: java.lang.Exception) {
            return false
        }
    }
}