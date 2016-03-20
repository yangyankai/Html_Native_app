package com.example.administrator.html_native_app;

import android.support.v7.app.ActionBarActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.annotation.SuppressLint;
import android.os.Bundle;

/**
 *  方法写在原生里，暴露给js调用
 */

public class MainActivity extends ActionBarActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.webView = (WebView) this.findViewById(R.id.webView);
        this.initializeWebView();
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    private void initializeWebView() {
        webView.addJavascriptInterface(new JsOperator(MainActivity.this),"JsInteraction");
        /**
         * webView.addJavascriptInterface(new JsOperator(MainActivity.this),"JsInteraction");
         * 表示添加供JS调用的对象，其别名是JsInteraction，
         * 这样在JS中只要写JsInteraction.<方法名称>()就可以调用相应的方法了。
         * WebView将加载assets文件夹里LoginJs文件夹下的login.html，
         * 这个文件会在后面创建。
         */

        try {
            String url = "file:///android_asset/LoginJs/login.html";
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setAllowFileAccess(true);
            webSettings.setAllowFileAccessFromFileURLs(true);
            this.webView.loadUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
