package com.shabayekdes.shabayekdes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebViewActivity extends AppCompatActivity {
    WebView webv;
    EditText editText;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webv = (WebView) findViewById(R.id.webv);
        webv.setWebViewClient(new WebViewClient());
        editText = (EditText) findViewById(R.id.ed_webv);

    }


    public void btnGoWeb(View view) {
        url = editText.getText().toString();
        if(!url.startsWith("www.") && !url.startsWith("http://"))
            url = "http://www." + url;
        else if(!url.startsWith("http://"))
            url = "http://" + url;
        webv.loadUrl(url);
    }
}
