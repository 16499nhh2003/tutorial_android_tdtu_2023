package com.example.lab3.ex23;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab3.R;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity4 extends AppCompatActivity {
    String combine = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_4);
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        String action = intent.getAction();
        if(Intent.ACTION_VIEW.equals(action) && (intent.getData() != null)){
            Uri data = intent.getData();
            String scheme = data.getScheme();
            String fullPath = data.getEncodedSchemeSpecificPart();
            combine =  scheme + "://" +  fullPath;
        }

        String url = null;
        if(!combine.isEmpty()){
            url = combine;
            webView.loadUrl(url);
        }
    }
}
