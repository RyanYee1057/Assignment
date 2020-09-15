package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class Sonic extends AppCompatActivity {

    String dd, dd2, mName1, mDes1, mSum1, mActor1, mDir1;
    TextView date1, date2, mName, mDes, mSum, mActor, mDir;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference g1;
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

        g1 = firebaseDatabase.getReference("MovieDetail").child("movie3");

        g1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mName1 = dataSnapshot.child("movie_name").getValue(String.class);
                mDes1 = dataSnapshot.child("movie_description").getValue(String.class);
                mSum1 = dataSnapshot.child("movie_summary").getValue(String.class);
                mActor1 = dataSnapshot.child("movie_actor").getValue(String.class);
                mDir1 = dataSnapshot.child("movie_director").getValue(String.class);
                mName = (TextView)findViewById(R.id.sonTitle);
                mName.setText(mName1);
                mDes = (TextView)findViewById(R.id.sondescription);
                mDes.setText(mDes1);
                mSum = (TextView)findViewById(R.id.sonsummary);
                mSum.setText(mSum1);
                mActor = (TextView)findViewById(R.id.sonactors);
                mActor.setText(mActor1);
                mDir = (TextView)findViewById(R.id.sondirector);
                mDir.setText(mDir1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void time5(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", mName1);
        intent.putExtra("mn", "movie5");
        intent.putExtra("time", "9.00am");
        intent.putExtra("date", dd);
        startActivity(intent);
    }

    public void time6(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", mName1);
        intent.putExtra("mn", "movie6");
        intent.putExtra("time", "11.00am");
        intent.putExtra("date", dd);
        startActivity(intent);
    }
    public void time52(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", mName1);
        intent.putExtra("mn", "movie5");
        intent.putExtra("time", "9.00am");
        intent.putExtra("date", dd2);
        startActivity(intent);
    }

    public void time62(View view) {
        finish();
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", mName1);
        intent.putExtra("mn", "movie6");
        intent.putExtra("time", "11.00am");
        intent.putExtra("date", dd2);
        startActivity(intent);
    }
}