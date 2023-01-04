package com.example.composeplayground.basic_api

import android.util.Log
import com.example.composeplayground.utils.*
import kotlinx.coroutines.delay

class DataSource {

    suspend fun getObjectsFromDataSource(): GenericData<List<ObjectInfo>> {
        return wrapWithGenericData {
            listOf(
                ObjectInfo(name = "First Object", description = "First Description"),
                ObjectInfo(name = "Second Object", description = "Second Description"),
                ObjectInfo(name = "Third Object", description = "Third Description")
            )
        }
    }

    suspend fun getShuffledObjectsFromDataSource(): GenericData<List<ObjectInfo>> {
        return wrapWithGenericData {
            listOf(
                ObjectInfo(name = "First Object", description = "First Description"),
                ObjectInfo(name = "Second Object", description = "Second Description"),
                ObjectInfo(name = "Third Object", description = "Third Description")
            ).shuffled()
        }
    }

    suspend fun getFirstBatch() = wrapWithGenericData {
        delay(1000)
        Log.d("ThaerOutput", "Retrieved first")
        1
    }

    suspend fun getSecondBatch() = wrapWithGenericData {
        delay(2000)
        Log.d("ThaerOutput", "Retrieved second")
        "1"
    }

    suspend fun getThirdBatch() = wrapWithGenericData {
        delay(3000)
        Log.d("ThaerOutput", "Retrieved third")
        true
    }

//    suspend fun <T: Any> getThirdBatch(): GenericData<T> {
//        delay(3000)
//        Log.d("ThaerOutput", "Failed to retrieve third")
//        return GenericData.Error("Error")
//    }

}
