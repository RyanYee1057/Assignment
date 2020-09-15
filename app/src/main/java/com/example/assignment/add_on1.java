package com.example.assignment;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class add_on1 extends AppCompatActivity {

    private int numPromo1, numPromo2, numPromo3;
    private int numCombo1, numCombo2, numCombo3;
    private int numAlaCarte1, numAlaCarte2;
    private int numSnacks1, numSnacks2;
    private int numBeverages1, numBeverages2, numBeverages3, numBeverages4;

    private TextView textPromo1, textPromo2, textPromo3;
    private TextView textCombo1, textCombo2, textCombo3;
    private TextView textAlaCarte1, textAlaCarte2;
    private TextView textSnacks1, textSnacks2;
    private TextView textBeverages1, textBeverages2, textBeverages3, textBeverages4;

    //private static final String TAG = "add_on1";
    LinearLayout L1, L2, L3, L4, L5;
    ImageView a1, a2;

    //new
    String userId;
    FirebaseAuth userFirebase = FirebaseAuth.getInstance();
    FirebaseDatabase add = FirebaseDatabase.getInstance();
    DatabaseReference add1, add2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_on1);
        //add1 = add.getReference("addOn");
        userId = userFirebase.getCurrentUser().getUid();
        L1 = (LinearLayout) findViewById(R.id.promo_screen);
        L2 = (LinearLayout) findViewById(R.id.combo_screen);
        L3 = (LinearLayout) findViewById(R.id.ala_carte_screen);
        L4 = (LinearLayout) findViewById(R.id.snacks_screen);
        L5 = (LinearLayout) findViewById(R.id.beverages_screen);
        a1 = (ImageView) findViewById(R.id.advertisement); //insert pic by search id

        textPromo1 = findViewById(R.id.num_promo1);
        textPromo2 = findViewById(R.id.num_promo2);
        textPromo3 = findViewById(R.id.num_promo3);

        textCombo1 = findViewById(R.id.num_combo1);
        textCombo2 = findViewById(R.id.num_combo2);
        textCombo3 = findViewById(R.id.num_combo3);

        textAlaCarte1 = findViewById(R.id.num_alaCarte1);
        textAlaCarte2 = findViewById(R.id.num_alaCarte2);
        textSnacks1 = findViewById(R.id.num_snacks1);
        textSnacks2 = findViewById(R.id.num_snacks2);

        textBeverages1 = findViewById(R.id.num_beverages1);
        textBeverages2 = findViewById(R.id.num_beverages2);
        textBeverages3 = findViewById(R.id.num_beverages3);
        textBeverages4 = findViewById(R.id.num_beverages4);

        textPromo1.setText(String.valueOf(numPromo1));
        textPromo2.setText(String.valueOf(numPromo2));
        textPromo3.setText(String.valueOf(numPromo3));

        textCombo1.setText(String.valueOf(numCombo1));
        textCombo2.setText(String.valueOf(numCombo2));
        textCombo3.setText(String.valueOf(numCombo3));

        textAlaCarte1.setText(String.valueOf(numAlaCarte1));
        textAlaCarte2.setText(String.valueOf(numAlaCarte2));
        textSnacks1.setText(String.valueOf(numSnacks1));
        textSnacks2.setText(String.valueOf(numSnacks2));

        textBeverages1.setText(String.valueOf(numBeverages1));
        textBeverages2.setText(String.valueOf(numBeverages2));
        textBeverages3.setText(String.valueOf(numBeverages3));
        textBeverages4.setText(String.valueOf(numBeverages4));
    }

    public void onPromo(View view){
        L1.setVisibility(View.VISIBLE);
        L2.setVisibility(View.GONE);
        L3.setVisibility(View.GONE);
        L4.setVisibility(View.GONE);
        L5.setVisibility(View.GONE);
        /*add1.orderByChild("Promo").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()){
                    String m = childSnapshot.child("name").getValue(String.class);
                    double p = childSnapshot.child("price").getValue(double.class);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {            }
        });*/
    }

    public void onCombo(View view){
        L1.setVisibility(View.GONE);
        L2.setVisibility(View.VISIBLE);
        L3.setVisibility(View.GONE);
        L4.setVisibility(View.GONE);
        L5.setVisibility(View.GONE);
    }

    public void onAlaCarte(View view){
        L1.setVisibility(View.GONE);
        L2.setVisibility(View.GONE);
        L3.setVisibility(View.VISIBLE);
        L4.setVisibility(View.GONE);
        L5.setVisibility(View.GONE);
    }

    public void onSnacks(View view){
        L1.setVisibility(View.GONE);
        L2.setVisibility(View.GONE);
        L3.setVisibility(View.GONE);
        L4.setVisibility(View.VISIBLE);
        L5.setVisibility(View.GONE);
    }

    public void onBeverages(View view){
        L1.setVisibility(View.GONE);
        L2.setVisibility(View.GONE);
        L3.setVisibility(View.GONE);
        L4.setVisibility(View.GONE);
        L5.setVisibility(View.VISIBLE);
    }

    public void decreaseNum(View view) {
        numPromo1 = Integer.parseInt(textPromo1.getText().toString());
        numPromo2 = Integer.parseInt(textPromo2.getText().toString());
        numPromo3 = Integer.parseInt(textPromo3.getText().toString());
        numCombo1 = Integer.parseInt(textCombo1.getText().toString());
        numCombo2 = Integer.parseInt(textCombo2.getText().toString());
        numCombo3 = Integer.parseInt(textCombo3.getText().toString());
        numAlaCarte1 = Integer.parseInt(textAlaCarte1.getText().toString());
        numAlaCarte2 = Integer.parseInt(textAlaCarte2.getText().toString());
        numSnacks1 = Integer.parseInt(textSnacks1.getText().toString());
        numSnacks2 = Integer.parseInt(textSnacks2.getText().toString());
        numBeverages1 = Integer.parseInt(textBeverages1.getText().toString());
        numBeverages2 = Integer.parseInt(textBeverages2.getText().toString());
        numBeverages3 = Integer.parseInt(textBeverages3.getText().toString());
        numBeverages4 = Integer.parseInt(textBeverages4.getText().toString());
        // Get the ID of the button that was clicked.
        int viewID = view.getId();
        switch (viewID) {
            case R.id.promo1_minus:
                numPromo1--;
                if (numPromo1 <0)
                    numPromo1 = 0;
                textPromo1.setText(String.valueOf(numPromo1));
                break;
            case R.id.promo2_minus:
                numPromo2--;
                if (numPromo2 <0)
                    numPromo2 = 0;
               textPromo2.setText(String.valueOf(numPromo2));
               break;
            case R.id.promo3_minus:
                numPromo3--;
                if (numPromo3 <0)
                    numPromo3 = 0;
                textPromo3.setText(String.valueOf(numPromo3));
                break;
        }

        switch (viewID) {
            case R.id.combo1_minus:
                numCombo1--;
                if (numCombo1 <0)
                    numCombo1 = 0;
                textCombo1.setText(String.valueOf(numCombo1));
                break;
            case R.id.combo2_minus:
                numCombo2--;
                if (numCombo2 <0)
                    numCombo2 = 0;
                textCombo2.setText(String.valueOf(numCombo2));
                break;
            case R.id.combo3_minus:
                numCombo3--;
                if (numCombo3 <0)
                    numCombo3 = 0;
                textCombo3.setText(String.valueOf(numCombo3));
                break;
        }

        switch (viewID) {
            case R.id.alaCarte1_minus:
                numAlaCarte1--;
                if (numAlaCarte1 <0)
                    numAlaCarte1 = 0;
                textAlaCarte1.setText(String.valueOf(numAlaCarte1));
                break;
            case R.id.alaCarte2_minus:
                numAlaCarte2--;
                if (numAlaCarte2 <0)
                    numAlaCarte2 = 0;
                textAlaCarte2.setText(String.valueOf(numAlaCarte2));
                break;
            case R.id.snacks1_minus:
                numSnacks1--;
                if (numSnacks1 <0)
                    numSnacks1 = 0;
                textSnacks1.setText(String.valueOf(numSnacks1));
                break;
            case R.id.snacks2_minus:
                numSnacks2--;
                if (numSnacks2 <0)
                    numSnacks2 = 0;
                textSnacks2.setText(String.valueOf(numSnacks2));
                break;
        }

        switch (viewID) {
            case R.id.beverages1_minus:
                numBeverages1--;
                if (numBeverages1 <0)
                    numBeverages1 = 0;
                textBeverages1.setText(String.valueOf(numBeverages1));
                break;
            case R.id.beverages2_minus:
                numBeverages2--;
                if (numBeverages2 <0)
                    numBeverages2 = 0;
                textBeverages1.setText(String.valueOf(numBeverages2));
                break;
            case R.id.beverages3_minus:
                numBeverages3--;
                if (numBeverages3 <0)
                    numBeverages3 = 0;
                textBeverages3.setText(String.valueOf(numBeverages3));
                break;
            case R.id.beverages4_minus:
                numBeverages4--;
                if (numBeverages4 <0)
                    numBeverages4 = 0;
                textBeverages4.setText(String.valueOf(numBeverages4));
                break;
        }
    }

    public void increaseNum(View view) {
        numPromo1 = Integer.parseInt(textPromo1.getText().toString());
        numPromo2 = Integer.parseInt(textPromo2.getText().toString());
        numPromo3 = Integer.parseInt(textPromo3.getText().toString());
        numCombo1 = Integer.parseInt(textCombo1.getText().toString());
        numCombo2 = Integer.parseInt(textCombo2.getText().toString());
        numCombo3 = Integer.parseInt(textCombo3.getText().toString());
        numAlaCarte1 = Integer.parseInt(textAlaCarte1.getText().toString());
        numAlaCarte2 = Integer.parseInt(textAlaCarte2.getText().toString());
        numSnacks1 = Integer.parseInt(textSnacks1.getText().toString());
        numSnacks2 = Integer.parseInt(textSnacks2.getText().toString());
        numBeverages1 = Integer.parseInt(textBeverages1.getText().toString());
        numBeverages2 = Integer.parseInt(textBeverages2.getText().toString());
        numBeverages3 = Integer.parseInt(textBeverages3.getText().toString());
        numBeverages4 = Integer.parseInt(textBeverages4.getText().toString());
        // Get the ID of the button that was clicked.
        int viewID = view.getId();
        switch (viewID) {
            case R.id.promo1_plus:
                numPromo1++;
                textPromo1.setText(String.valueOf(numPromo1));
                break;
            case R.id.promo2_plus:
                numPromo2++;
                textPromo2.setText(String.valueOf(numPromo2));
                break;
            case R.id.promo3_plus:
                numPromo3++;
                textPromo3.setText(String.valueOf(numPromo3));
                break;
        }

        switch (viewID) {
            case R.id.combo1_plus:
                numCombo1++;
                textCombo1.setText(String.valueOf(numCombo1));
                break;
            case R.id.combo2_plus:
                numCombo2++;
                textCombo2.setText(String.valueOf(numCombo2));
                break;
            case R.id.combo3_plus:
                numCombo3++;
                textCombo3.setText(String.valueOf(numCombo3));
                break;
        }

        switch (viewID) {
            case R.id.alaCarte1_plus:
                numAlaCarte1++;
                textAlaCarte1.setText(String.valueOf(numAlaCarte1));
                break;
            case R.id.alaCarte2_plus:
                numAlaCarte2++;
                textAlaCarte2.setText(String.valueOf(numAlaCarte2));
                break;
            case R.id.snacks1_plus:
                numSnacks1++;
                textSnacks1.setText(String.valueOf(numSnacks1));
                break;
            case R.id.snacks2_plus:
                numSnacks2++;
                textSnacks2.setText(String.valueOf(numSnacks2));
                break;
        }

        switch (viewID) {
            case R.id.beverages1_plus:
                numBeverages1++;
                textBeverages1.setText(String.valueOf(numBeverages1));
                break;
            case R.id.beverages2_plus:
                numBeverages2++;
                textBeverages2.setText(String.valueOf(numBeverages2));
                break;
            case R.id.beverages3_plus:
                numBeverages3++;
                textBeverages3.setText(String.valueOf(numBeverages3));
                break;
            case R.id.beverages4_plus:
                numBeverages4++;
                textBeverages4.setText(String.valueOf(numBeverages4));
                break;
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        add1 = add.getReference("users").child(userId).child("AddCart");
        add1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child("Promo1").exists())
                    textPromo1.setText(String.valueOf(snapshot.child("Promo1").child("quantity").getValue(int.class)));
                if (snapshot.child("Promo2").exists())
                    textPromo2.setText(String.valueOf(snapshot.child("Promo2").child("quantity").getValue(int.class)));
                if (snapshot.child("Promo3").exists())
                    textPromo3.setText(String.valueOf(snapshot.child("Promo3").child("quantity").getValue(int.class)));
                if (snapshot.child("Combo1").exists())
                    textCombo1.setText(String.valueOf(snapshot.child("Combo1").child("quantity").getValue(int.class)));
                if (snapshot.child("Combo2").exists())
                    textCombo2.setText(String.valueOf(snapshot.child("Combo2").child("quantity").getValue(int.class)));
                if (snapshot.child("Combo3").exists())
                    textCombo3.setText(String.valueOf(snapshot.child("Combo3").child("quantity").getValue(int.class)));
                if (snapshot.child("AlaCarte1").exists())
                    textAlaCarte1.setText(String.valueOf(snapshot.child("AlaCarte1").child("quantity").getValue(int.class)));
                if (snapshot.child("AlaCarte2").exists())
                    textAlaCarte2.setText(String.valueOf(snapshot.child("AlaCarte2").child("quantity").getValue(int.class)));
                if (snapshot.child("Snacks1").exists())
                    textSnacks1.setText(String.valueOf(snapshot.child("Snacks1").child("quantity").getValue(int.class)));
                if (snapshot.child("Snacks2").exists())
                    textSnacks2.setText(String.valueOf(snapshot.child("Snacks2").child("quantity").getValue(int.class)));
                if (snapshot.child("Beverages1").exists())
                    textBeverages1.setText(String.valueOf(snapshot.child("Beverages1").child("quantity").getValue(int.class)));
                if (snapshot.child("Beverages2").exists())
                    textBeverages2.setText(String.valueOf(snapshot.child("Beverages2").child("quantity").getValue(int.class)));
                if (snapshot.child("Beverages3").exists())
                    textBeverages3.setText(String.valueOf(snapshot.child("Beverages3").child("quantity").getValue(int.class)));
                if (snapshot.child("Beverages4").exists())
                    textBeverages4.setText(String.valueOf(snapshot.child("Beverages4").child("quantity").getValue(int.class)));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void addCart(View view){
        add1 = add.getReference("users").child(userId).child("AddCart");
        numPromo1 = Integer.parseInt(textPromo1.getText().toString());
        numPromo2 = Integer.parseInt(textPromo2.getText().toString());
        numPromo3 = Integer.parseInt(textPromo3.getText().toString());
        numCombo1 = Integer.parseInt(textCombo1.getText().toString());
        numCombo2 = Integer.parseInt(textCombo2.getText().toString());
        numCombo3 = Integer.parseInt(textCombo3.getText().toString());
        numAlaCarte1 = Integer.parseInt(textAlaCarte1.getText().toString());
        numAlaCarte2 = Integer.parseInt(textAlaCarte2.getText().toString());
        numSnacks1 = Integer.parseInt(textSnacks1.getText().toString());
        numSnacks2 = Integer.parseInt(textSnacks2.getText().toString());
        numBeverages1 = Integer.parseInt(textBeverages1.getText().toString());
        numBeverages2 = Integer.parseInt(textBeverages2.getText().toString());
        numBeverages3 = Integer.parseInt(textBeverages3.getText().toString());
        numBeverages4 = Integer.parseInt(textBeverages4.getText().toString());
        if(numPromo1 != 0) {
            add1.child("Promo1").child("name").setValue("Promo1");
            add1.child("Promo1").child("quantity").setValue(numPromo1);
            add1.child("Promo1").child("price").setValue(9.00);
        }else
            add1.child("Promo1").removeValue();
        if(numPromo2 != 0) {
            add1.child("Promo2").child("name").setValue("Promo2");
            add1.child("Promo2").child("quantity").setValue(numPromo2);
            add1.child("Promo2").child("price").setValue(7.50);
        }else
            add1.child("Promo2").removeValue();
        if(numPromo3 != 0) {
            add1.child("Promo3").child("name").setValue("Promo3");
            add1.child("Promo3").child("quantity").setValue(numPromo3);
            add1.child("Promo3").child("price").setValue(3.50);
        }else
            add1.child("Promo3").removeValue();
        if(numCombo1 != 0) {
            add1.child("Combo1").child("name").setValue("Combo1");
            add1.child("Combo1").child("quantity").setValue(numCombo1);
            add1.child("Combo1").child("price").setValue(7.00);
        }else
            add1.child("Combo1").removeValue();
        if(numCombo2 != 0) {
            add1.child("Combo2").child("name").setValue("Combo2");
            add1.child("Combo2").child("quantity").setValue(numCombo2);
            add1.child("Combo2").child("price").setValue(10.00);
        }else
            add1.child("Combo2").removeValue();
        if(numCombo3 != 0) {
            add1.child("Combo3").child("name").setValue("Combo3");
            add1.child("Combo3").child("quantity").setValue(numCombo3);
            add1.child("Combo3").child("price").setValue(7.00);
        }else
            add1.child("Combo3").removeValue();
        if(numAlaCarte1 != 0) {
            add1.child("AlaCarte1").child("name").setValue("AlaCarte1");
            add1.child("AlaCarte1").child("quantity").setValue(numAlaCarte1);
            add1.child("AlaCarte1").child("price").setValue(8.00);
        }else
            add1.child("AlaCarte1").removeValue();
        if(numAlaCarte2 != 0) {
            add1.child("AlaCarte2").child("name").setValue("AlaCarte2");
            add1.child("AlaCarte2").child("quantity").setValue(numAlaCarte2);
            add1.child("AlaCarte2").child("price").setValue(5.00);
        }else
            add1.child("AlaCarte2").removeValue();
        if(numSnacks1 != 0) {
            add1.child("Snacks1").child("name").setValue("Snacks1");
            add1.child("Snacks1").child("quantity").setValue(numSnacks1);
            add1.child("Snacks1").child("price").setValue(5.00);
        }else
            add1.child("Snacks1").removeValue();
        if(numSnacks2 != 0) {
            add1.child("Snacks2").child("name").setValue("Snacks2");
            add1.child("Snacks2").child("quantity").setValue(numSnacks2);
            add1.child("Snacks2").child("price").setValue(3.00);
        }else
            add1.child("Snacks2").removeValue();
        if(numBeverages1 != 0) {
            add1.child("Beverages1").child("name").setValue("Beverages1");
            add1.child("Beverages1").child("quantity").setValue(numBeverages1);
            add1.child("Beverages1").child("price").setValue(3.50);
        }else
            add1.child("Beverages1").removeValue();
        if(numBeverages2 != 0) {
            add1.child("Beverages2").child("name").setValue("Beverages2");
            add1.child("Beverages2").child("quantity").setValue(numBeverages2);
            add1.child("Beverages2").child("price").setValue(3.50);
        }else
            add1.child("Beverages2").removeValue();
        if(numBeverages3 != 0) {
            add1.child("Beverages3").child("name").setValue("Beverages3");
            add1.child("Beverages3").child("quantity").setValue(numBeverages3);
            add1.child("Beverages3").child("price").setValue(2.50);
        }else
            add1.child("Beverages3").removeValue();
        if(numBeverages4 != 0) {
            add1.child("Beverages4").child("name").setValue("Beverages4");
            add1.child("Beverages4").child("quantity").setValue(numBeverages4);
            add1.child("Beverages4").child("price").setValue(2.50);
        }else
            add1.child("Beverages4").removeValue();
        //finish();

        Intent nextIntent = new Intent(view.getContext(), credit_card_payment.class);
        startActivity(nextIntent);
    }

}
