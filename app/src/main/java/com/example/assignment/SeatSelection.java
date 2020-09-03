package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SeatSelection extends AppCompatActivity implements View.OnClickListener {
    ViewGroup layoutGroup;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference m1;

    ViewGroup viewLayout;

    List<TextView> seatViewList = new ArrayList<>();
    int seatSize = 70;
    int seatGaping = 10;
    int count = 0;
    int countSelect;
    int seatSelected = 0;
    String seats = "";
    String text = "You selected ";
    LinearLayout layout;
    LinearLayout layoutSeat;

    int STATUS_AVAILABLE = 1;
    int STATUS_BOOKED = 2;
    int STATUS_RESERVED = 3;
    String selectedIds = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String MovieName = getIntent().getStringExtra("name");
        m1 = firebaseDatabase.getReference("Movie").child(MovieName);
        setContentView(R.layout.activity_main);

        //Intent intent = getIntent();
        //seats = intent.getStringExtra(Bloodshot.EXTRA_MESSAGE);

        viewLayout = findViewById(R.id.layoutSeat);



        layoutSeat = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutSeat.setOrientation(LinearLayout.VERTICAL);
        layoutSeat.setLayoutParams(params);
        layoutSeat.setPadding(8 * seatGaping, 8 * seatGaping, 8 * seatGaping, 8 * seatGaping);
        viewLayout.addView(layoutSeat);

        layout = null;

        /*for (int index = 0; index < seats.length(); index++) {

            if (seats.charAt(index) == '/') {
                layout = new LinearLayout(this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layoutSeat.addView(layout);
            } else if (seats.charAt(index) == 'U') {
                count++;
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_booked);
                view.setTextColor(Color.WHITE);
                view.setBackgroundColor(Color.RED);
                view.setTag(STATUS_BOOKED);
                view.setText(count + "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
            } else if (seats.charAt(index) == 'R') {
                count++;
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_reserved);
                view.setBackgroundColor(Color.GRAY);
                view.setText(count + "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                view.setTextColor(Color.BLACK);
                view.setTag(STATUS_RESERVED);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
            } else if (seats.charAt(index) == 'A') {
                count++;
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_book);
                view.setBackgroundColor(Color.BLUE);
                view.setText(count + "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                view.setTextColor(Color.WHITE);
                view.setTag(STATUS_AVAILABLE);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
                seats = seats.substring(0,count)+'U'+seats.substring(count+1);
            } else if (seats.charAt(index) == '_') {
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setBackgroundColor(Color.TRANSPARENT);
                view.setText("");
                layout.addView(view);
            }
        }*/

        m1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seats = dataSnapshot.child("movie_seat").getValue(String.class);
                seats = "/" + seats;
                for (int index = 0; index < seats.length(); index++) {

                    if (seats.charAt(index) == '/') {
                        layout = new LinearLayout(SeatSelection.this);
                        layout.setOrientation(LinearLayout.HORIZONTAL);
                        layoutSeat.addView(layout);
                    } else if (seats.charAt(index) == 'U') {
                        count++;
                        TextView view = new TextView(SeatSelection.this);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                        layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                        view.setLayoutParams(layoutParams);
                        view.setPadding(0, 0, 0, 2 * seatGaping);
                        view.setId(count);
                        view.setGravity(Gravity.CENTER);
                        view.setBackgroundResource(R.drawable.ic_seats_booked);
                        view.setTextColor(Color.WHITE);
                        view.setBackgroundColor(Color.RED);
                        view.setTag(STATUS_BOOKED);
                        view.setText(count + "");
                        view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                        layout.addView(view);
                        seatViewList.add(view);
                        view.setOnClickListener(SeatSelection.this);
                    } else if (seats.charAt(index) == 'R') {
                        count++;
                        TextView view = new TextView(SeatSelection.this);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                        layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                        view.setLayoutParams(layoutParams);
                        view.setPadding(0, 0, 0, 2 * seatGaping);
                        view.setId(count);
                        view.setGravity(Gravity.CENTER);
                        view.setBackgroundResource(R.drawable.ic_seats_reserved);
                        view.setBackgroundColor(Color.GRAY);
                        view.setText(count + "");
                        view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                        view.setTextColor(Color.BLACK);
                        view.setTag(STATUS_RESERVED);
                        layout.addView(view);
                        seatViewList.add(view);
                        view.setOnClickListener(SeatSelection.this);
                    } else if (seats.charAt(index) == 'A') {
                        count++;
                        TextView view = new TextView(SeatSelection.this);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                        layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                        view.setLayoutParams(layoutParams);
                        view.setPadding(0, 0, 0, 2 * seatGaping);
                        view.setId(count);
                        view.setGravity(Gravity.CENTER);
                        view.setBackgroundResource(R.drawable.ic_seats_book);
                        view.setBackgroundColor(Color.BLUE);
                        view.setText(count + "");
                        view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                        view.setTextColor(Color.WHITE);
                        view.setTag(STATUS_AVAILABLE);
                        layout.addView(view);
                        seatViewList.add(view);
                        view.setOnClickListener(SeatSelection.this);
                        seats = seats.substring(0,count)+'U'+seats.substring(count+1);
                    } else if (seats.charAt(index) == '_') {
                        TextView view = new TextView(SeatSelection.this);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                        layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                        view.setLayoutParams(layoutParams);
                        view.setBackgroundColor(Color.TRANSPARENT);
                        view.setText("");
                        layout.addView(view);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



    @Override
    public void onClick(View view) {


        if ((int) view.getTag() == STATUS_AVAILABLE) {
            if (selectedIds.contains(view.getId() + ",")) {
                selectedIds = selectedIds.replace(+view.getId() + ",", "");
                view.setBackgroundResource(R.drawable.ic_seats_book);
                view.setBackgroundColor(Color.BLUE);
            } else {
                selectedIds = selectedIds + view.getId() + ",";
                view.setBackgroundResource(R.drawable.ic_seats_selected);
                view.setBackgroundColor(Color.GREEN);
                Toast.makeText(this, "Seat " + view.getId() + " is Selected", Toast.LENGTH_SHORT).show();
                countSelect = view.getId();
                seatSelected+=1;
                text += "seat " + countSelect + " ";
            }
        } else if ((int) view.getTag() == STATUS_BOOKED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
        } else if ((int) view.getTag() == STATUS_RESERVED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Reserved", Toast.LENGTH_SHORT).show();
        }
    }

    public void confirm(View view) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "seat selected = " + seatSelected, Toast.LENGTH_SHORT).show();
    }
}