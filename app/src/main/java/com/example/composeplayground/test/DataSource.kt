package com.example.composeplayground.test

import com.example.composeplayground.utils.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

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

}
