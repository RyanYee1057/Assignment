package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Feedback extends AppCompatActivity {

    EditText comment;
    TextView retrieve;
    Button submitComment, retrieveComment;
    Comment comm;

    DatabaseReference ref1, ref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_feedback);

        comment = (EditText)findViewById(R.id.comment);
        retrieve = (TextView)findViewById(R.id.retrievedComment);
        submitComment = (Button)findViewById(R.id.submitComment);
        retrieveComment = (Button)findViewById(R.id.retrieve);
        comm = new Comment();
        ref1 = FirebaseDatabase.getInstance().getReference().child("Comment");

        submitComment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                comm.setComment(comment.getText().toString().trim());
                ref1.child("Comment").setValue(comm);
                Toast.makeText(Feedback.this,"Feedback Sent!", Toast.LENGTH_SHORT).show();
            }
        });

        retrieveComment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ref2 = FirebaseDatabase.getInstance().getReference().child("Comment").child("Comment");
                ref2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Toast.makeText(Feedback.this,"Comment retrieved!", Toast.LENGTH_SHORT).show();
                        String c=dataSnapshot.child("comment").getValue().toString();
                        retrieve.setText(c);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_profile:
                        Intent profileIntent = new Intent(Feedback.this, profile.class);
                        startActivity(profileIntent);
                        break;
                    case R.id.nav_movies:
                        Intent movieIntent = new Intent(Feedback.this, MainActivity.class);
                        startActivity(movieIntent);
                        break;
                    case R.id.nav_purchase_history:
                        Intent puchaseHistoryIntent = new Intent(Feedback.this, payment_history.class);
                        startActivity(puchaseHistoryIntent);
                        break;
                    case R.id.add_on:
                        Intent addOnIntent = new Intent(Feedback.this, add_on1.class);
                        startActivity(addOnIntent);
                        break;
                    case R.id.feedback:
                        Toast.makeText(Feedback.this,"Already in feedback activity",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sign_out:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent (Feedback.this, Login.class);
                        startActivity(intent);
                }
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        View navIcon = findViewById(R.id.toolbar_icon);
        navIcon.setOnClickListener((new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
            }
        }));
    }
}