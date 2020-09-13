package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Sonic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonic);
    }

    public void time5(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Sonic The Hedgedog");
        intent.putExtra("mn", "movie5");
        intent.putExtra("time", "9.00am");
        startActivity(intent);
    }

    public void time6(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Sonic The Hedgedog");
        intent.putExtra("mn", "movie6");
        intent.putExtra("time", "11.00am");
        startActivity(intent);
    }
}