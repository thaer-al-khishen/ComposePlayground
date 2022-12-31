package com.example.composeplayground.test.api_test

import com.example.composeplayground.test.api_test.model.ChildModel
import com.example.composeplayground.test.api_test.model.ParentModel
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {

    @GET("tenders")
    suspend fun getTenders(): ParentModel<List<ChildModel>>

}
