package com.msc.dev.alwaysawakeapp.awake

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import com.msc.dev.alwaysawakeapp.Constants
import com.msc.dev.alwaysawakeapp.R
import kotlinx.android.synthetic.main.fragment_awake_webview.*
import android.widget.Toast


class AwakeWebviewFragment : Fragment(), AwakeContract.View {

    var presenter: AwakePresenter = AwakePresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_awake_webview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.setView(this)
        presenter.setImageData(arguments?.getString(Constants.EXTRA_URL)!!)
    }

    override fun showImage(urlStr: String) {
        val webView: WebView = wv_content
        webView.webViewClient = AwakeWebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
        webView.settings.setSupportZoom(true)
        webView.settings.useWideViewPort = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.settings.domStorageEnabled = true
        webView.loadUrl(urlStr)
    }

    override fun showImageError() {
        Toast.makeText(activity?.applicationContext, getString(R.string.not_possible_load), Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance(intent: Intent?): AwakeWebviewFragment {
            var url = intent?.getStringExtra(Intent.EXTRA_TEXT)
            var bundle = Bundle()
            if (url != null) {
                bundle.putString(Constants.EXTRA_URL, getUrlFromString(url))
            }
            var fragment = AwakeWebviewFragment()
            fragment.arguments = bundle
            return fragment
        }

        private fun getUrlFromString(strContainingUrl: String): String? {
            val m = Patterns.WEB_URL.matcher(strContainingUrl)
            return when (m.find()) {
                true -> strContainingUrl.substring(m.start(), m.end())
                false -> null
            }
        }
    }

    private inner class AwakeWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }

        override fun onLoadResource(view: WebView?, url: String?) {
            super.onLoadResource(view, url)
            progress.visibility = View.VISIBLE

        }
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            progress.visibility = View.GONE
        }

        override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
            super.onReceivedError(view, request, error)
            presenter.errorLoadingUrl()
        }

    }
}