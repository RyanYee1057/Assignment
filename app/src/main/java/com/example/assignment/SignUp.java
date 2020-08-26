package com.example.assignment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    private EditText e, p, pwd1, pwd2;
    private Button btn1;
    private TextView tnc;
    private CheckBox cb;
    private ProgressDialog loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        mFirebaseAuth = FirebaseAuth.getInstance();
        btn1 = findViewById(R.id.createAcc);
        e = findViewById(R.id.editTextEmail);
        p = findViewById(R.id.editTextPhone);
        pwd1 = findViewById(R.id.editTextP1);
        pwd2 = findViewById(R.id.editTextP2);
        tnc= findViewById(R.id.tnc);
        cb=findViewById(R.id.terms);
        loadingBar = new ProgressDialog(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = e.getText().toString();
                String phone = p.getText().toString();
                String password = pwd1.getText().toString();
                String cPassword = pwd2.getText().toString();
                if(email.isEmpty()&&phone.isEmpty()&&password.isEmpty()&&cPassword.isEmpty()){
                    e.setError("Please enter your email");
                    e.requestFocus();
                    p.setError("Please enter your phone");
                    p.requestFocus();
                    pwd1.setError("Please enter your password");
                    pwd1.requestFocus();
                    pwd2.setError("This field cannot be empty!");
                    pwd2.requestFocus();
                }
                else if (email.isEmpty()) {
                    e.setError("Please enter your email");
                    e.requestFocus();
                } else if(!(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())){
                    e.setError("invalid email");
                    e.requestFocus();
                }else if (phone.isEmpty()) {
                    p.setError("Please enter your phone");
                    p.requestFocus();
                } else if (phone.length() < 9) {
                    p.setError("Invalid phone number");
                    p.requestFocus();
                } else if (password.isEmpty()) {
                    pwd1.setError("Please enter your password");
                    pwd1.requestFocus();
                } else if (password.length() < 5) {
                    pwd1.setError("Password must be >5 characters");
                    pwd1.requestFocus();
                } else if (cPassword.isEmpty()) {
                    pwd2.setError("Please confirm your password");
                    pwd2.requestFocus();
                } else if (!password.equals(cPassword)) {
                    pwd2.setError("Does not match with password");
                    pwd2.requestFocus();
                } else if (!cb.isChecked()) {
                    Toast.makeText(SignUp.this, "Please read the terms and conditions", Toast.LENGTH_SHORT).show();
                }
                else {
                    loadingBar.setTitle("\tCreating New Account");
                    loadingBar.setMessage("Please wait...");
                    loadingBar.show();
                    loadingBar.setCanceledOnTouchOutside(true);
                    mFirebaseAuth.createUserWithEmailAndPassword(email, cPassword).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "Sign up Unsuccessful, Please Try Again", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            } else {
                                loadingBar.dismiss();
                                Toast.makeText(SignUp.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUp.this, Login.class));
                            }
                        }
                    });
                }
            }
        });
        tnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUp.this);
                View mView = getLayoutInflater().inflate(R.layout.terms, null);
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });
    }

}
