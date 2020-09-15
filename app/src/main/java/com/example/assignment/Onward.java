package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class Onward extends AppCompatActivity {

    String dd, dd2;
    TextView date1,date2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onward);
        Date d = new Date();
        CharSequence s  = DateFormat.format("yyyy-MM-dd", d.getTime());
        CharSequence s2  = DateFormat.format("yyyy-MM-dd", d.getTime() + 86400000); // 1 day have 86400000 milli second
        dd = s.toString();
        dd2 = s2.toString();
        date1 = (TextView)findViewById(R.id.t2);
        date2 = (TextView)findViewById(R.id.t22);
        date1.setText(dd);
        date2.setText(dd2);
    }


    public void time3(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Onward");
        intent.putExtra("mn", "movie3");
        intent.putExtra("time", "1.15pm");
        intent.putExtra("date", dd);
        startActivity(intent);
    }

    public void time4(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Onward");
        intent.putExtra("mn", "movie4");
        intent.putExtra("time", "3.45pm");
        intent.putExtra("date", dd);
        startActivity(intent);
    }
    public void time32(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Onward");
        intent.putExtra("mn", "movie3");
        intent.putExtra("time", "1.15pm");
        intent.putExtra("date", dd2);
        startActivity(intent);
    }

    public void time42(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Onward");
        intent.putExtra("mn", "movie4");
        intent.putExtra("time", "3.45pm");
        intent.putExtra("date", dd2);
        startActivity(intent);
    }
}