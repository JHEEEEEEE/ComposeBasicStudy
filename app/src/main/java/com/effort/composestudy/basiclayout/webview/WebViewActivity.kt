package com.effort.composestudy.basiclayout.webview

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.effort.composestudy.ui.theme.ComposeOnlineStudyTheme

class WebViewActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOnlineStudyTheme {
                MyWebView("https://www.daum.net/")
            }
        }
    }

}


@Composable
fun MyWebView(url: String) {
    AndroidView(
        factory = {
            WebView(it).apply {
                loadUrl(url)
            }
        }
    )
}

@Preview
@Composable
fun PreviewWebView() {
    ComposeOnlineStudyTheme {
        MyWebView("https://www.daum.net/")
    }
}