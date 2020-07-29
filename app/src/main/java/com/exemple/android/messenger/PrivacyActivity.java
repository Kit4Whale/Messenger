package com.exemple.android.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class PrivacyActivity extends AppCompatActivity {

    WebView privacyWebView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);

        privacyWebView = (WebView)findViewById(R.id.wedView);

        privacyWebView.loadUrl("https://docs.google.com/document/d/1zbuaKSpAr8q2UA4pj0n8Jmz6BU0ulCAm9RZobeYqJOI/edit");

        backButton = (Button)findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent privacyIntent = new Intent(PrivacyActivity.this, WelcomeActivity.class);
                startActivity(privacyIntent);
            }
        });


    }
}