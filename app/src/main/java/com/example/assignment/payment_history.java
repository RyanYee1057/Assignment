package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class payment_history extends AppCompatActivity {

    FirebaseAuth userFirebase = FirebaseAuth.getInstance();
    FirebaseDatabase df = FirebaseDatabase.getInstance();
    DatabaseReference his;
    String userId, text, movieName, movieTime;
    TextView show;
    double moviePrice = 0, ttp;
    int count = 0;
    //int[] selectId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);

        show = (TextView)findViewById(R.id.show);
        userId = userFirebase.getCurrentUser().getUid();
        his = df.getReference("users").child(userId).child("history");
        text = "";
        his.orderByChild("history_id").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    ttp = 0;
                    if (childSnapshot.child("Movie").child("movie_price").exists() && childSnapshot.child("Movie").child("seatCount").exists()) {
                        moviePrice = childSnapshot.child("Movie").child("movie_price").getValue(double.class);
                        count = childSnapshot.child("Movie").child("seatCount").getValue(int.class);
                    }
                    movieName = childSnapshot.child("Movie").child("movie_name").getValue(String.class);
                    movieTime = childSnapshot.child("Movie").child("movie_time").getValue(String.class);
                    String movieSeat = childSnapshot.child("Movie").child("seat").getValue(String.class);
                    text += "Movie\n" + movieName + " ---- " + String.format("RM%.2f", moviePrice) + " ---- " + movieTime + "\n";
                    for (int index = 0; index < count; index++) {
                        if (movieSeat.charAt(index) == '1') {
                            //selectId[index] = 1;
                            text += String.format("Seat %d\n", index + 1);
                            ttp += moviePrice;
                        }
                    }
                    if (childSnapshot.child("AddOn").exists()) {
                        text+= "\nAdd On - Movie Name : " + movieName + " : " + movieTime + "\n";
                        for (DataSnapshot CS : childSnapshot.child("AddOn").getChildren())
                        {
                            String n = CS.child("name").getValue(String.class);
                            int q = CS.child("quantity").getValue(int.class);
                            double p = CS.child("price").getValue(double.class);
                            double tp = q * p;
                            ttp += tp;
                            text += n + String.format("-> %d (RM%.2f) : (Total: RM%.2f)\n", q, p, tp);
                        }
                    }
                    text += "--------------------------------------------\n"+
                            "   " + String.format("RM %.2f\n",ttp) +
                            "--------------------------------------------\n\n";
                }
                show.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}