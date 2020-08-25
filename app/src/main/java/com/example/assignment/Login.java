package com.example.assignment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    EditText ed1,ed2;
    Button btn;
    TextView text;
    TextView fPwd;
    CheckBox rmb;
    private ProgressDialog loadingBar;

     @Override
      protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.login);
             mFirebaseAuth=FirebaseAuth.getInstance();
             ed1 = findViewById(R.id.email);
             ed2 = findViewById(R.id.password);
             btn = findViewById(R.id.login_button);
             text = findViewById(R.id.sign_up);
             fPwd = findViewById(R.id.forgot);
             rmb = findViewById(R.id.rememberMe);
         loadingBar = new ProgressDialog(this);
         // Remember me
         SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
         String checkbox = preferences.getString("rememberMe", "");
         if (checkbox.equals("false")){
             FirebaseAuth.getInstance().signOut();
         }else{
             SharedPreferences.Editor editor = preferences.edit();
             editor.putString("rememberMe","true");
             editor.apply();
         }

        btn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            String email =ed1.getText().toString();
            String pwd =ed2.getText().toString();

            if (email.isEmpty()&&pwd.isEmpty()){
                ed1.setError("Please enter your email");
                ed1.requestFocus();
                ed2.setError("Please enter your password");
                ed2.requestFocus();
                Toast.makeText(Login.this,"Fields Are Empty",Toast.LENGTH_SHORT).show();
            }
            else if(!(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())){
                ed1.setError("invalid email");
                ed1.requestFocus();
            }
            else if(email.isEmpty()){
                ed1.setError("Please enter your email");
                ed1.requestFocus();
            }
            else if(pwd.isEmpty()){
                ed2.setError("Please enter your password");
                ed2.requestFocus();
            }
            else if(!(email.isEmpty()&&pwd.isEmpty())){
                loadingBar.setTitle("\tLogin");
                loadingBar.setMessage("Loading...");
                loadingBar.show();
                loadingBar.setCanceledOnTouchOutside(true);
                mFirebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(Login.this,"Login Failed!",Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                        }
                        else{
                            Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this,profile.class));
                            loadingBar.dismiss();
                        }
                    }
                });
            }else{
                Toast.makeText(Login.this,"Error!",Toast.LENGTH_SHORT).show();
            }
        }

    });
         mAuthStateListener=new FirebaseAuth.AuthStateListener() {
             @Override
             public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                 FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                 /*if(mFirebaseUser!=null){
                    Toast.makeText(Login.this,"You are logged in",Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(Login.this,profile.class));
                 }
                 else{
                     Toast.makeText(Login.this,"Please Login",Toast.LENGTH_SHORT).show();
                 }*/
             }
         };
        text.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(Login.this,SignUp.class);
                 startActivity(i);
             }
         });
        fPwd.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(Login.this,ForgotPwd.class));
             }
         });
         rmb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if(compoundButton.isChecked()){
                     SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                     SharedPreferences.Editor editor = preferences.edit();
                     editor.putString("rememberMe","true");
                     editor.apply();
                 }else if (!compoundButton.isChecked()){
                     SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                     SharedPreferences.Editor editor = preferences.edit();
                     editor.putString("rememberMe","false");
                     editor.apply();
                 }
             }
         });
}
@Override
    protected void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
