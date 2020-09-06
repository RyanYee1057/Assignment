package com.example.assignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardEditText;

public class credit_card_payment extends Activity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    CardEditText cardnum;
    CheckBox agree;
    EditText cardholderName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_payment);
        cardnum = findViewById(R.id.bt_card_form_card_number);
        agree=findViewById(R.id.agree_payment);
        cardholderName=findViewById(R.id.cardName_input);
    }
    public void launchSecondActivity(View view) {

        String cardNum = String.valueOf(cardnum.getText());
        String cardType = cardnum.getCardType().name();
        String regex = "^[a-zA-Z ]*$";
        String temp_ch = cardholderName.toString();
        if(cardType == "UNKNOWN"){
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
            Log.d(LOG_TAG, "Button clicked!");
            Intent intent = new Intent(this, payment_success.class);
            startActivity(intent);
        }
    }

    public void returnAddOn(View view){
        finish();
    }
}
