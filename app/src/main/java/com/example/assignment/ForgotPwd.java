package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPwd extends AppCompatActivity {
   private FirebaseAuth mFirebaseAuth;
    private EditText rEmail;
    private Button rPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_pwd);
        mFirebaseAuth = FirebaseAuth.getInstance();
        rPwd = findViewById(R.id.reset);
        rEmail = findViewById(R.id.editEmail);
        rPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail=rEmail.getText().toString().trim();
                if(userEmail.equals("")){
                    Toast.makeText(ForgotPwd.this,"Please enter your registered email ID",Toast.LENGTH_SHORT).show();
                }
                else if(!(android.util.Patterns.EMAIL_ADDRESS.matcher(userEmail).matches())){
                    rEmail.setError("invalid email");
                    rEmail.requestFocus();
                }
                else{
                    mFirebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgotPwd.this,"Password reset email sent.",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ForgotPwd.this,Login.class));
                            }else{
                                Toast.makeText(ForgotPwd.this,"Error in sending password reset email.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


    }}
