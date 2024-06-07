package com.example.lab6_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bai6_Lab6 extends AppCompatActivity {
    Button btn_first;
    Button btn_second;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai6_lab6);

        fm = getSupportFragmentManager();
        btn_first = findViewById(R.id.btn_first);
        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft_add = fm.beginTransaction();
                ft_add.add(R.id.frame_layout, new First_Fragment());
                ft_add.commit();
            }
        });
        btn_second = findViewById(R.id.btn_second);
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft_add = fm.beginTransaction();
                ft_add.add(R.id.frame_layout, new Second_Fragment());
                ft_add.commit();
            }
        });
    }
}