package com.example.assignment;

import android.app.AppComponentFactory;
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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class add_on1 extends AppCompatActivity {

    private int numPromo1, numPromo2, numPromo3, numPromo4;
    private int numCombo1, numCombo2, numCombo3, numCombo4;
    private int numAlaCarte1, numAlaCarte2;
    private int numSnacks1, numSnacks2;
    private int numBeverages1, numBeverages2, numBeverages3, numBeverages4;

    private TextView textPromo1, textPromo2, textPromo3, textPromo4;
    private TextView textCombo1, textCombo2, textCombo3, textCombo4;
    private TextView textAlaCarte1, textAlaCarte2;
    private TextView textSnacks1, textSnacks2;
    private TextView textBeverages1, textBeverages2, textBeverages3, textBeverages4;

    //private static final String TAG = "add_on1";
    LinearLayout L1, L2, L3, L4, L5;
    ImageView a1, a2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_on1);
        L1 = (LinearLayout) findViewById(R.id.promo_screen);
        L2 = (LinearLayout) findViewById(R.id.combo_screen);
        L3 = (LinearLayout) findViewById(R.id.ala_carte_screen);
        L4 = (LinearLayout) findViewById(R.id.snacks_screen);
        L5 = (LinearLayout) findViewById(R.id.beverages_screen);
        a1 = (ImageView) findViewById(R.id.advertisement); //insert pic by search id

        textPromo1 = findViewById(R.id.num_promo1);
        textPromo2 = findViewById(R.id.num_promo2);
        textPromo3 = findViewById(R.id.num_promo3);
        textPromo4 = findViewById(R.id.num_promo4);

        textCombo1 = findViewById(R.id.num_combo1);
        textCombo2 = findViewById(R.id.num_combo2);
        textCombo3 = findViewById(R.id.num_combo3);
        textCombo4 = findViewById(R.id.num_combo4);

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
        textPromo4.setText(String.valueOf(numPromo4));

        textCombo1.setText(String.valueOf(numCombo1));
        textCombo2.setText(String.valueOf(numCombo2));
        textCombo3.setText(String.valueOf(numCombo3));
        textCombo4.setText(String.valueOf(numCombo4));

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
        // Get the ID of the button that was clicked.
        int viewID = view.getId();
        switch (viewID) {
            case R.id.promo1_minus:
                numPromo1--;
                textPromo1.setText(String.valueOf(numPromo1));
                break;
            case R.id.promo2_minus:
                numPromo2--;
               textPromo2.setText(String.valueOf(numPromo2));
               break;
            case R.id.promo3_minus:
                numPromo3--;
                textPromo3.setText(String.valueOf(numPromo3));
                break;
            case R.id.promo4_minus:
                numPromo4--;
                textPromo4.setText(String.valueOf(numPromo4));
                break;
        }

        switch (viewID) {
            case R.id.combo1_minus:
                numCombo1--;
                textCombo1.setText(String.valueOf(numCombo1));
                break;
            case R.id.combo2_minus:
                numCombo2--;
                textCombo2.setText(String.valueOf(numCombo2));
                break;
            case R.id.combo3_minus:
                numCombo3--;
                textCombo3.setText(String.valueOf(numCombo3));
                break;
            case R.id.combo4_minus:
                numCombo4--;
                textCombo4.setText(String.valueOf(numCombo4));
                break;
        }

        switch (viewID) {
            case R.id.alaCarte1_minus:
                numAlaCarte1--;
                textAlaCarte1.setText(String.valueOf(numAlaCarte1));
                break;
            case R.id.alaCarte2_minus:
                numAlaCarte2--;
                textAlaCarte2.setText(String.valueOf(numAlaCarte2));
                break;
            case R.id.snacks1_minus:
                numSnacks1--;
                textSnacks1.setText(String.valueOf(numSnacks1));
                break;
            case R.id.snacks2_minus:
                numSnacks2--;
                textSnacks2.setText(String.valueOf(numSnacks2));
                break;
        }

        switch (viewID) {
            case R.id.beverages1_minus:
                numBeverages1--;
                textBeverages1.setText(String.valueOf(numBeverages1));
                break;
            case R.id.beverages2_minus:
                numBeverages2--;
                textBeverages1.setText(String.valueOf(numBeverages2));
                break;
            case R.id.beverages3_minus:
                numBeverages3--;
                textBeverages3.setText(String.valueOf(numBeverages3));
                break;
            case R.id.beverages4_minus:
                numBeverages4--;
                textBeverages4.setText(String.valueOf(numBeverages4));
                break;
        }
    }

    public void increaseNum(View view) {
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
            case R.id.promo4_plus:
                numPromo4++;
                textPromo4.setText(String.valueOf(numPromo4));
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
            case R.id.combo4_plus:
                numCombo4++;
                textCombo4.setText(String.valueOf(numCombo4));
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
                textBeverages1.setText(String.valueOf(numBeverages2));
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
}
