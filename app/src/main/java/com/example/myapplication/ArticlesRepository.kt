package com.example.myapplication

import ArticlesResponse
import javax.inject.Inject

class ArticlesRepository @Inject constructor(private val apiService: ApiService) {
    private val apiKey = "2dce4725644c4d1e8829ce6a6d14e175"

     fun getArticles() : ArticlesResponse {
        return apiService.getArticles("us", apiKey)
    }
}