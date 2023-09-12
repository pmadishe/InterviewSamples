package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("url") val url: String
)