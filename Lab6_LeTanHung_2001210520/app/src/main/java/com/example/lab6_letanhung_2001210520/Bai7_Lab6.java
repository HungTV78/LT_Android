package com.example.lab6_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bai7_Lab6 extends AppCompatActivity {
    Button btn_calculator;
    Button btn_history;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7_lab6);

        fm = getSupportFragmentManager();
        btn_calculator = findViewById(R.id.btn_calculator);
        btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft_replace = fm.beginTransaction();
                ft_replace.replace(R.id.frame_layout_b7, new Calculator_Fragment());
                ft_replace.commit();
            }
        });

        btn_history = findViewById(R.id.btn_history);
        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft_replace = fm.beginTransaction();
                ft_replace.replace(R.id.frame_layout_b7, new History_Fragment());
                ft_replace.commit();
            }
        });
    }
}