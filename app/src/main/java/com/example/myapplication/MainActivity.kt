package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ArticlesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize the ViewModel
        viewModel = ViewModelProvider(this)[ArticlesViewModel::class.java]

        val webView = findViewById<View>(R.id.webview) as WebView
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        extracted(webView)

    }

    private fun extracted(webView: WebView) {
        viewModel.articlesResponse.observe(this, Observer { it ->

            val articles: List<Article> = it.articles
            val url = articles[0].url
            webView.loadUrl(url)
        })
    }
}
