package com.example.hammersystemstest.domain.retrofit

import com.example.hammersystemstest.domain.ServerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServerResponseApi {

    @GET("planetary/apod")
    suspend fun fetchServerResponse(
        @Query("api_key") apiKey: String = "DEMO_KEY",
        @Query("count") count: Int = 15
    ): List<ServerResponse>
}