package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class payment_success extends AppCompatActivity {
    private static final String LOG_TAG =
            payment_success.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);
    }

    public void return_homepage(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}