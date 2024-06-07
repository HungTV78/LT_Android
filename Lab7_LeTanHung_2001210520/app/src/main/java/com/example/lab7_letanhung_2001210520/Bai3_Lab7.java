package com.example.lab7_letanhung_2001210520;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bai3_Lab7 extends AppCompatActivity {

    ActionBar actionBar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_lab7);
        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                int id = item.getItemId();
                if (id == R.id.navigation_shop) {
                    setActionBarTitle("Shop");
                    fragment = new FragShop_Bai3();
                    loadFragment(fragment);
                    return true;
                } else if (id == R.id.navigation_gifts) {
                    setActionBarTitle("Gift");
                    fragment = new FragGift_Bai3();
                    loadFragment(fragment);
                    return true;
                } else if (id == R.id.navigation_cart) {
                    setActionBarTitle("Cart");
                    fragment = new FragCart_Bai3();
                    loadFragment(fragment);
                    return true;
                } else if (id == R.id.navigation_profile) {
                    setActionBarTitle("Profile");
                    fragment = new FragProfile_Bai3();
                    loadFragment(fragment);
                    return true;
                }
                return false;
            }
        });

        // Set default action bar title
        setActionBarTitle("Shop");
        // Load default fragment
        loadFragment(new FragShop_Bai3());
    }

    // Method to set action bar title safely
    private void setActionBarTitle(String title) {
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    // Method to load fragment
    public void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameFragment, fragment);
        ft.commit();
    }
}
