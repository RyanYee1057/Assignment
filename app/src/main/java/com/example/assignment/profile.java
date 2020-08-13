package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends AppCompatActivity{
        //implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        // Get the intent and its data.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.name);
        textView.setText(message);
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