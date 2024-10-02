package com.arin.titiksuara;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.arin.titiksuara.Fragment.HomeFragment;
import com.arin.titiksuara.Fragment.MyPengaduanFragment;
import com.arin.titiksuara.Fragment.ProfilFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize BottomNavigationView and set the listener for item selection
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Set HomeFragment as the default fragment when the app starts
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
        }

        // Handle navigation item selection
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                // Use if-else instead of switch
                if (item.getItemId() == R.id.home) {
                    selectedFragment = new HomeFragment();
                } else if (item.getItemId() == R.id.pengaduan) {
                    selectedFragment = new MyPengaduanFragment();
                } else if (item.getItemId() == R.id.profile) {
                    selectedFragment = new ProfilFragment();
                }

                // Replace the current fragment with the selected fragment
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, selectedFragment).commit();
                }
                return true;
            }
        });
    }
}