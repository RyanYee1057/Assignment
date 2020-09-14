package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class Sonic extends AppCompatActivity {

    String dd, dd2;
    TextView date1,date2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonic);
        Date d = new Date();
        CharSequence s  = DateFormat.format("yyyy-MM-dd", d.getTime());
        CharSequence s2  = DateFormat.format("yyyy-MM-dd", d.getTime() + 86400000); // 1 day have 86400000 milli second
        dd = s.toString();
        dd2 = s2.toString();
        date1 = (TextView)findViewById(R.id.t3);
        date2 = (TextView)findViewById(R.id.t32);
        date1.setText(dd);
        date2.setText(dd2);
    }

    public void time5(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Sonic The Hedgedog");
        intent.putExtra("mn", "movie5");
        intent.putExtra("time", "9.00am");
        intent.putExtra("date", dd);
        startActivity(intent);
    }

    public void time6(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Sonic The Hedgedog");
        intent.putExtra("mn", "movie6");
        intent.putExtra("time", "11.00am");
        intent.putExtra("date", dd);
        startActivity(intent);
    }
    public void time52(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Sonic The Hedgedog");
        intent.putExtra("mn", "movie5");
        intent.putExtra("time", "9.00am");
        intent.putExtra("date", dd2);
        startActivity(intent);
    }

    public void time62(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Sonic The Hedgedog");
        intent.putExtra("mn", "movie6");
        intent.putExtra("time", "11.00am");
        intent.putExtra("date", dd2);
        startActivity(intent);
    }
}