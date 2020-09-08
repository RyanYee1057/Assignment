package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Sonic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonic);
    }

    /*s1 = "_UAARRRRRAA_/_________________/UU__AARRR__RR/UA__UAAAA__RR/UU__AUUAA__AA/AA__AAURR__AA/RU__UURRR__AA/AA__AARAA__UU/UA__RRUUU__RR/AA__UAURR__AA/_________________/UU_AAAUUUU_RR/RR_AUURRAA_AA/_________________/"
    s2 = "_AUUUUARRRR_/_________________/UU__AUARR__RR/UA__UAAUR__AR/AA__AUUUA__UA/AA__RRRRR__AA/RU__UURRR__AA/UU__RAARA__UU/AA__RRUUU__RR/AA__UAARR__RR/_________________/RU_AAAURRU_RR/RR_AUUUAAA_UU/_________________/"*/

    public void time5(View view) {
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "movie5");
        startActivity(intent);
    }

    public void time6(View view) {
        Intent intent = new Intent(view.getContext(), SeatSelection.class);
        intent.putExtra("name", "movie6");
        startActivity(intent);
    }
}