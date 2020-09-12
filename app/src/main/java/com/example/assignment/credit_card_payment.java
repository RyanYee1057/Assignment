package com.example.assignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.braintreepayments.cardform.view.CardEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class credit_card_payment extends Activity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    TextView Detail,totalPrice;
    CardEditText cardnum;
    CheckBox agree;
    EditText cardholderName;
    String userId, detailText = "", dd, historyID, cardNum;
    int hid;
    FirebaseAuth userFirebase = FirebaseAuth.getInstance();
    FirebaseDatabase add = FirebaseDatabase.getInstance();
    DatabaseReference add1, add2, takeid, history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_payment);
        Detail = (TextView)findViewById(R.id.detail);
        totalPrice = (TextView)findViewById(R.id.tolPr);
        cardnum = findViewById(R.id.bt_card_form_card_number);
        agree=findViewById(R.id.agree_payment);
        cardholderName=findViewById(R.id.cardName_input);
        userId = userFirebase.getCurrentUser().getUid();
        add1 = add.getReference("users").child(userId);
        takeid = add.getReference("takeID").child("historyID");
        history = add.getReference("AllHistory");
        takeid.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                hid = snapshot.getValue(int.class);
                hid += 1;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        add1.child("AddCart").orderByChild("name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                double ttp = 0;
                for (DataSnapshot childSnapshot : snapshot.getChildren()){
                    if(childSnapshot.child("quantity").exists()&&childSnapshot.child("price").exists()) {
                        String n = childSnapshot.child("name").getValue(String.class);
                        int q = childSnapshot.child("quantity").getValue(int.class);
                        double p = childSnapshot.child("price").getValue(double.class);
                        double tp = q * p;
                        detailText += n + String.format(" %d (RM%.2f) : (Total: RM%.2f)\n", q, p, tp);
                        Detail.setText(detailText);
                        ttp += tp;
                    }
                }
                totalPrice.setText(String.format("RM%.2f", ttp));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void launchSecondActivity(View view) {
        cardNum = String.valueOf(cardnum.getText());
        String cardType = cardnum.getCardType().name();
        String regex = "^[a-zA-Z ]*$";
        String temp_ch = cardholderName.getText().toString();
        String getPrice = totalPrice.getText().toString();
        double getPri = Double.parseDouble(getPrice.replace("RM",""));
        if(getPri==0){
            Toast.makeText(this, "No item payment", Toast.LENGTH_SHORT).show();
            finish();
        }else if(cardType == "UNKNOWN"){
            Toast.makeText(credit_card_payment.this, "Credit Card UNKNOWN !!!", Toast.LENGTH_SHORT).show();
        }else if (cardholderName.length()==0){
            Toast.makeText(credit_card_payment.this,"Name cannot be empty",Toast.LENGTH_SHORT).show();
        }else if(!(temp_ch.matches("^[a-zA-Z ]*$"))){
            Toast.makeText(credit_card_payment.this,"Card holder name cannot contain symbol",Toast.LENGTH_SHORT).show();
        }else if(cardType == "EMPTY"){
            Toast.makeText(credit_card_payment.this, "Credit Card EMPTY !!!", Toast.LENGTH_SHORT).show();
        }else if(cardNum == null){
            Toast.makeText(credit_card_payment.this, " UNKNOWN !!!", Toast.LENGTH_SHORT).show();
        }else if(cardNum.length()!=16){
            Toast.makeText(credit_card_payment.this, " 16 Number of Credit Card !!!", Toast.LENGTH_SHORT).show();
        } else if (!agree.isChecked()) {
            Toast.makeText(credit_card_payment.this, " Agreement box is unchecked !!!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Date d = new Date();
            CharSequence s  = DateFormat.format("yyyy-MM-dd", d.getTime());
            dd = s.toString();
            add2 = add1.child("history");
            add1.child("AddCart").orderByChild("name").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    double ttp = 0;
                    historyID = String.format("H%d",hid);
                    for (DataSnapshot childSnapshot : snapshot.getChildren()){
                        if(childSnapshot.child("quantity").exists()&&childSnapshot.child("price").exists()) {
                            String n = childSnapshot.child("name").getValue(String.class);
                            int q = childSnapshot.child("quantity").getValue(int.class);
                            double p = childSnapshot.child("price").getValue(double.class);
                            double tp = q * p;
                            history.child(dd).child(historyID).child("AddOn").child(n).child("name").setValue(n);
                            history.child(dd).child(historyID).child("AddOn").child(n).child("quantity").setValue(q);
                            history.child(dd).child(historyID).child("AddOn").child(n).child("price").setValue(p);
                            history.child(dd).child(historyID).child("cardNum").setValue(cardNum);

                            add2.child(historyID).child("AddOn").child(n).child("name").setValue(n);
                            add2.child(historyID).child("AddOn").child(n).child("quantity").setValue(q);
                            add2.child(historyID).child("AddOn").child(n).child("price").setValue(p);
                        }
                    }
                    totalPrice.setText(String.format("RM%.2f", ttp));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            takeid.setValue(hid);
            Log.d(LOG_TAG, "Button clicked!");
            finish();
            Intent intent = new Intent(this, payment_success.class);
            startActivity(intent);
        }
    }

    public void returnAddOn(View view){
        finish();
    }
}
