package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class ArticlesResponse(
    @SerializedName("articles") val articles: List<Article>,
)