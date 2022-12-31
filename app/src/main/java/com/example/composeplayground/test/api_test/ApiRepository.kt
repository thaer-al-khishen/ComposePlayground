package com.example.composeplayground.test.api_test

import com.example.composeplayground.utils.wrapWithGenericData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://tenders.guru/api/hu/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: ApiInterface = retrofit.create(ApiInterface::class.java)

    suspend fun getTenders() = wrapWithGenericData {
        service.getTenders().data
    }
}
