package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Onward extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onward);
    }


    public void time3(View view) {
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "movie3");
        startActivity(intent);
    }

    public void time4(View view) {
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "movie4");
        startActivity(intent);
    }
}