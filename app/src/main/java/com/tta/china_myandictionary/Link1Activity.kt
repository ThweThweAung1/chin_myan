package com.tta.china_myandictionary

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_link1.*

class Link1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_link1)

        if (webView != null){
            val webSetting = webView!!.settings
            webSetting.javaScriptEnabled = true

            webView!!.webViewClient = WebViewClient()
            webView!!.webChromeClient = WebChromeClient()
            webView!!.loadUrl("http://www.dict.baidu.com")

            webView!!.webViewClient = object :WebViewClient(){
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {

                    super.onPageStarted(view, url, favicon)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                }
            }

        }

    }

    override fun onBackPressed() {
        if (webView!!.canGoBack()){
            webView!!.goBack()
        }
        else {


            super.onBackPressed()
        }

    }
}