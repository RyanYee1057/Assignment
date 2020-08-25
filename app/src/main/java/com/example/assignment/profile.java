package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends AppCompatActivity{
        //implements AdapterView.OnItemSelectedListener {

    private static final int PERMISSION_REQUEST = 0;
    private static final int RESULT_LOAD_IMAGE = 1;

    EditText name, number, email;
    Button Nnn;
    ImageView imageView;
    Button button;

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

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST);
        }
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.insertPic);

        button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show();
                }  else{
                    Toast.makeText(this, "Permission not granted!", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_LOAD_IMAGE:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();
                    imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                }
        }
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