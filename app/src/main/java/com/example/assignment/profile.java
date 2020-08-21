package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends AppCompatActivity{
        //implements AdapterView.OnItemSelectedListener {

    EditText name, number, email;
    Button Nnn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        // Get the intent and its data.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


        name = (EditText) findViewById(R.id.enter_name);
        number = (EditText) findViewById(R.id.enter_phone_num);
        email = (EditText) findViewById(R.id.enter_EmailAddress);
        Nnn = (Button) findViewById(R.id.Nnn);  //
        Nnn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {    //click Button
                String n = name.getText().toString();
                String m = number.getText().toString();
                String e = email.getText().toString();

                if(n.isEmpty()){
                    name.setError("Please enter your name!");
                    name.requestFocus();
                }
                else if(e.isEmpty()){
                    email.setError("Please enter your email address!");
                    email.requestFocus();
                }
                else if(m.isEmpty()){
                    number.setError("Please enter your phone number!");
                    number.requestFocus();
                }
                else if(m.length()> 12){
                    number.setError("Please enter correct phone number!");
                    number.requestFocus();
                }
                else {
                    Toast.makeText(profile.this, "Done!", Toast.LENGTH_SHORT).show(); //For Test (pop-up)
                }
            }

        });
        ///
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