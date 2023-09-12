package com.example.myapplication

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getArticles(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
    ) : ArticlesResponse
}