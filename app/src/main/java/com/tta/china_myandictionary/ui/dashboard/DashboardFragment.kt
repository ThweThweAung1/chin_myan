package com.tta.china_myandictionary.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.tta.china_myandictionary.R



class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
//        val textView: TextView = root.findViewById(R.id.navigation_dashboard)
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root

//        webView = findViewById(R.id.web_view)
//        webView.setWebViewClient(WebViewClient())
//        webView.getSettings().setLoadsImagesAutomatically(true)
//        webView.getSettings().setJavaScriptEnabled(true)
//        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY)
//        webView.loadUrl(url)

    }
}