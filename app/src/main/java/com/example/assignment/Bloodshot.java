package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Date;

public class Bloodshot extends AppCompatActivity {

    String dd, dd2;
    TextView date1,date2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodshot);
        Date d = new Date();
        CharSequence s  = DateFormat.format("yyyy-MM-dd", d.getTime());
        CharSequence s2  = DateFormat.format("yyyy-MM-dd", d.getTime() + 86400000); // 1 day have 86400000 milli second
        dd = s.toString();
        dd2 = s2.toString();
        date1 = (TextView)findViewById(R.id.t1);
        date2 = (TextView)findViewById(R.id.t12);
        date1.setText(dd);
        date2.setText(dd2);
    }

    public void time1(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Bloodshot");
        intent.putExtra("mn", "movie1");
        intent.putExtra("time", "4.30pm");
        intent.putExtra("date", dd);
        startActivity(intent);
    }

    public void time2(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Bloodshot");
        intent.putExtra("mn", "movie2");
        intent.putExtra("time", "7.00pm");
        intent.putExtra("date", dd);
        startActivity(intent);
    }
    public void time12(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Bloodshot");
        intent.putExtra("mn", "movie1");
        intent.putExtra("time", "4.30pm");
        intent.putExtra("date", dd2);
        startActivity(intent);
    }
    public void time22(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "Bloodshot");
        intent.putExtra("mn", "movie2");
        intent.putExtra("time", "7.00pm");
        intent.putExtra("date", dd2);
        startActivity(intent);
    }
}