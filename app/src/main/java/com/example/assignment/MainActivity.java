package com.example.assignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; //test
    private ViewPager mViewPager;
    FirebaseAuth mFirebaseAuth;
    // Tag for the intent extra.
    public static final String EXTRA_MESSAGE =
            "com.example.android.assignment.extra.MESSAGE";

    ListView listView;
    String dd, dd2;
    FirebaseDatabase fd = FirebaseDatabase.getInstance();
    DatabaseReference dr1,dr2, drM;
    String mTitle[] = {"BloodShot", "Onward", "Sonic The Hedgedog"};
    String mDescription[] = {"P13 - Action, Adventure - 107 Minutes - English", "U - Adventure, Fantasy - 102 Minutes - English", "P13 - Action, Adventure - 98 Minutes - English"};
    int images[] = {R.drawable.bloodshot, R.drawable.onward,R.drawable.sonic};

    //private String Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if(mFirebaseUser!=null){
            Toast.makeText(MainActivity.this,"You are logged in",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this,"Please Login",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,Login.class));
        }
        //test
        //setContentView(R.layout.activity_main);

        setContentView(R.layout.nav_activity_main);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_profile:
                        Intent profileIntent = new Intent(MainActivity.this, profile.class);
                        startActivity(profileIntent);
                        break;
                    case R.id.nav_movies:
                        Toast.makeText(MainActivity.this,"Already in movie activity",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_purchase_history:
                        Intent puchaseHistoryIntent = new Intent(MainActivity.this, payment_history.class);
                        startActivity(puchaseHistoryIntent);
                        break;
                    case R.id.add_on:
                        Intent addOnIntent = new Intent(MainActivity.this, add_on1.class);
                        startActivity(addOnIntent);
                        break;
                    case R.id.feedback:
                        Intent feedbackIntent = new Intent(MainActivity.this, Feedback.class);
                        startActivity(feedbackIntent);
                        break;
                    case R.id.sign_out:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent (MainActivity.this, Login.class);
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

        listView = findViewById(R.id.listView);
        MyAdapter adapter =  new MyAdapter(this,mTitle,mDescription,images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent (MainActivity.this, Bloodshot.class);
                    startActivity(intent);
                }
                if(position == 1){
                    Intent intent = new Intent (MainActivity.this, Onward.class);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent (MainActivity.this, Sonic.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void displayMsg(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView image = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            image.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            return row;
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Date d = new Date();
        CharSequence s  = DateFormat.format("yyyy-MM-dd", d.getTime());
        CharSequence s2  = DateFormat.format("yyyy-MM-dd", d.getTime() + 86400000); // 1 day have 86400000 milli second
        dd = s.toString();
        dd2 = s2.toString();
        dr1 = fd.getReference("MovieOnDate").child(dd);
        drM = fd.getReference("Movie");
        dr1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){

                }
                else{
                    drM.orderByChild("movie_id").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            for (DataSnapshot childSnapshot : snapshot.getChildren())
                            {
                                String mi = childSnapshot.child("movie_id").getValue(String.class);
                                String mn = childSnapshot.child("movie_name").getValue(String.class);
                                String ms = childSnapshot.child("movie_seat").getValue(String.class);
                                double mp = childSnapshot.child("movie_price").getValue(double.class);
                                dr1.getRef().child(mi).child("movie_id").setValue(mi);
                                dr1.getRef().child(mi).child("movie_name").setValue(mn);
                                dr1.getRef().child(mi).child("movie_seat").setValue(ms);
                                dr1.getRef().child(mi).child("movie_price").setValue(mp);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dr2 = fd.getReference("MovieOnDate").child(dd2);
        dr2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){

                }
                else{
                    drM.orderByChild("movie_id").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            for (DataSnapshot childSnapshot : snapshot.getChildren())
                            {
                                String mi = childSnapshot.child("movie_id").getValue(String.class);
                                String mn = childSnapshot.child("movie_name").getValue(String.class);
                                String ms = childSnapshot.child("movie_seat").getValue(String.class);
                                double mp = childSnapshot.child("movie_price").getValue(double.class);
                                dr2.getRef().child(mi).child("movie_id").setValue(mi);
                                dr2.getRef().child(mi).child("movie_name").setValue(mn);
                                dr2.getRef().child(mi).child("movie_seat").setValue(ms);
                                dr2.getRef().child(mi).child("movie_price").setValue(mp);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}