package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
        viewModelScope.launch {
            val response = repository.getArticles()
            _articlesResponse.value = response
        }
    }

}