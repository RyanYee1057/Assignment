package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Bloodshot extends AppCompatActivity {
    /*private FirebaseAuth mFirebaseAuth;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;*/
    private static final String MOVIE1 = "movie1";
    private Movie movie1, movie2;
    private TextView mN;
    private Button t1, t2;

    public static final String EXTRA_MESSAGE =
            ".Bloodshot.extra.MESSAGE";
    private static final String LOG_TAG =
            Bloodshot.class.getSimpleName();
    String seats, s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodshot);
        /*database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(MOVIE1);
        mFirebaseAuth = FirebaseAuth.getInstance();*/
        mN = findViewById(R.id.bstitle);
        t1 = findViewById(R.id.time1);
        t2 = findViewById(R.id.time2);
        s1 = "_UAAAAARRRR_/"
                + "_________________/"
                + "UU__AARRR__RR/"
                + "UA__UAAAA__AA/"
                + "AA__AAAAA__AA/"
                + "AA__AAURR__AA/"
                + "RU__UURRR__AA/"
                + "AA__AARAA__UU/"
                + "AA__AAUUU__RR/"
                + "AA__UAURR__RR/"
                + "_________________/"
                + "UU_AAAUUUU_RR/"
                + "RR_AAAAAAA_AA/"
                + "_________________/";
        s2 = "_UAUUUARRRR_/"
                + "_________________/"
                + "UU__AARRR__RR/"
                + "UA__UAAAA__AA/"
                + "AA__AAAAA__AA/"
                + "AA__RRRRR__AA/"
                + "RU__UURRR__AA/"
                + "AA__AARAA__UU/"
                + "AA__AAUUU__RR/"
                + "AA__UAURR__RR/"
                + "_________________/"
                + "UU_AAAUUUU_RR/"
                + "RR_AUUURRA_AA/"
                + "_________________/";
    }

    public void time1(View view) {
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "movie1");
        startActivity(intent);
    }

    public void time2(View view) {
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "movie2");
        startActivity(intent);
    }
}