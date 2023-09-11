package com.example.myapplication

import ArticlesResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getArticles(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
    ) : ArticlesResponse
}