package com.example.composeplayground.basic_api

import com.example.composeplayground.utils.*

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
