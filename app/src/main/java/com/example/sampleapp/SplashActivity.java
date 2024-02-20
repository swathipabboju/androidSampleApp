package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() -> {
            // Start the main activity after the splash screen
            startActivity(new Intent(SplashActivity.this, TaskActivity.class));
            finish(); // Close the splash activity so it won't appear in the back stack
        }, 2000);
    }
}