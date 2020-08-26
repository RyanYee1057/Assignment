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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class add_on1 extends AppCompatActivity {
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


/*@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_on1, container, false);
        frag1 = (Button) view.findViewById(R.id.promo);
        frag2 = (Button) view.findViewById(R.id.comboPop);
        Log.d(TAG, "onCreateView: started");

        frag1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getActivity(), "Going to add_on1", Toast.LENGTH_SHORT).show();

                ((MainActivity)getActivity()).setViewPager(0);
            }
        });

        frag2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getActivity(), "Going to add_on2", Toast.LENGTH_SHORT).show();

                ((MainActivity)getActivity()).setViewPager(1);
            }
        });

        return view;
    }*/
}
