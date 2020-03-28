package com.ibnuputra.covid19id

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_news_view.*

class NewsViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_PROGRESS)
        window.setFeatureInt( Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON)
        setContentView(R.layout.activity_news_view)

        val url = intent.getStringExtra("URL")


        val webView: WebView = findViewById(R.id.webview)

        webView.settings.loadsImagesAutomatically = true
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.progress
        webView.canGoForward()
        webView.canGoBack()
        webview.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(
                view: WebView,
                progress: Int
            ) { //Make the bar disappear after URL is loaded, and changes string to Loading...
                title = "Loading..."
                setProgress(progress * 100) //Make the bar disappear after URL is loaded
                // Return the app name after finish loading
            }
        }

        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)

    }
}
