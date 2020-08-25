package com.example.assignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; //test
    private ViewPager mViewPager;

    // Tag for the intent extra.
    public static final String EXTRA_MESSAGE =
            "com.example.android.assignment.extra.MESSAGE";

    ListView listView;
    String[] mTitle = {"Movie 1", "Movie 2", "Movie 3"};
    String[] mDescription = {"Movie 1 desc", "Movie 2 desc", "Movie 3 desc"};
    int[] images = {R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery,R.drawable.ic_menu_share};

    private String Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //test
        setContentView(R.layout.activity_main);
       /*

        setContentView(R.layout.nav_activity_main);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_profile:
                        Toast.makeText(MainActivity.this,"Profile",Toast.LENGTH_SHORT).show();
                        Intent profileIntent = new Intent(MainActivity.this, profile.class);
                        startActivity(profileIntent);
                        break;
                    case R.id.nav_movies:
                        Toast.makeText(MainActivity.this,"Already in movie activity",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_purchase_history:
                        Toast.makeText(MainActivity.this,"Purchase_history",Toast.LENGTH_SHORT).show();
                        //Intent puchaseHistoryIntent = new Intent(MainActivity.this, purchaseHistory.class);
                        //startActivity(puchaseHistoryIntent);
                        break;
                }
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        listView = findViewById(R.id.listView);
        MyAdapter adapter =  new MyAdapter(this,mTitle,mDescription,images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(MainActivity.this, "Movie 1 clicked",Toast.LENGTH_SHORT).show();
                }
                if(position == 0){
                    Toast.makeText(MainActivity.this, "Movie 2 clicked",Toast.LENGTH_SHORT).show();
                }
                if(position == 0){
                    Toast.makeText(MainActivity.this, "Movie 3 clicked",Toast.LENGTH_SHORT).show();
                }
            }
        });
*/
    }

    //test
    /*
    public void setupViewPager(ViewPager viewPager){
        add_onAdapter adapter = new add_onAdapter(getSupportFragmentManager());
        adapter.addFragment(new add_on1(), "add_on1");
        adapter.addFragment(new add_on2(), "add_on2");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);
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
    */

    public void onAdd(View view){
        Intent intent = new Intent (MainActivity.this, add_on1.class);
        startActivity(intent);

    }
}