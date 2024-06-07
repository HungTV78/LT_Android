package com.example.lab6_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bai2_Lab6 extends AppCompatActivity {

    Button btn;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_lab6);
        fm = getSupportFragmentManager();
        btn = findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft_add = fm.beginTransaction();
                ft_add.add(R.id.frame_layout, new MyFragment1());
                ft_add.commit();
            }
        });
    }
}