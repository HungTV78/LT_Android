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
public class Bai5_Lab7 extends AppCompatActivity {
    ActionBar actionBar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5_lab7);

        // Khởi tạo bottomNavigationView bằng findViewById
        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                int id = item.getItemId();
                if (id == R.id.navigation_home) {
                    setActionBarTitle("Home");
                    fragment = new FragHome_Bai5();
                    loadFragment(fragment);
                    return true;
                } else if (id == R.id.navigation_search) {
                    setActionBarTitle("Search");
                    fragment = new FragSearch_Bai5();
                    loadFragment(fragment);
                    return true;
                } else if (id == R.id.navigation_notification) {
                    setActionBarTitle("Notification");
                    fragment = new FragNotification_Bai5();
                    loadFragment(fragment);
                    return true;
                } else if (id == R.id.navigation_cafe) {
                    setActionBarTitle("Cafe");
                    fragment = new FragCafe_Bai5();
                    loadFragment(fragment);
                    return true;
                }
                return false;
            }
        });

        setActionBarTitle("Home");
        loadFragment(new FragHome_Bai5());
    }

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
        ft.replace(R.id.frameFragment_Bai5, fragment);
        ft.commit();
    }
}
