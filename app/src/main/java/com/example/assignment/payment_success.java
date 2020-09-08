package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class payment_success extends AppCompatActivity {
    private static final String LOG_TAG =
            payment_success.class.getSimpleName();
    String userId;
    FirebaseAuth userFirebase = FirebaseAuth.getInstance();
    FirebaseDatabase add = FirebaseDatabase.getInstance();
    DatabaseReference add1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);
        userId = userFirebase.getCurrentUser().getUid();
        add1 = add.getReference("users").child(userId);
    }

    public void return_homepage(View view) {
        add1.child("AddCart").removeValue();
        Log.d(LOG_TAG, "Button clicked!");
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        add1.child("AddCart").removeValue();
    }


    
}