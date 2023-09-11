package com.example.myapplication

import ArticlesResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val repository: ArticlesRepository
) : ViewModel() {

    private val _articlesResponse = MutableLiveData<ArticlesResponse>()
    var articlesResponse: LiveData<ArticlesResponse> = _articlesResponse

    init {
        getArticles()
    }

    private fun getArticles() {
        val response = repository.getArticles()
        _articlesResponse.value = response
    }

}