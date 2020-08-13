package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.online_bank:
                if (checked)
                    displayMsg(getString(R.string.selected_bank));
                break;
            case R.id.credit_card:
                if (checked)
                    displayMsg(getString(R.string.selected_card));
                break;
            case R.id.TNG_Ewallet:
                if (checked)
                    displayMsg(getString(R.string.selected_Ewallet));
                break;
            default:
                // Do nothing.
                break;
        }
    }


    public void displayMsg(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}