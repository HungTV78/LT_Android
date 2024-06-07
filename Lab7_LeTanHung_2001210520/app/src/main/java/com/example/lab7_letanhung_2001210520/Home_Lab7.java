package com.example.lab7_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Lab7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lab7);
        Button btnBai1 = findViewById(R.id.btn_bai1);
        Button btnBai2 = findViewById(R.id.btn_bai2);
        Button btnBai3 = findViewById(R.id.btn_bai3);
        Button btnBai4 = findViewById(R.id.btn_bai4);
        Button btnBai5 = findViewById(R.id.btn_bai5);
        Button btnBai6 = findViewById(R.id.btn_bai6);
        Button btnBai7 = findViewById(R.id.btn_bai6_2);
        Button btnBai8 = findViewById(R.id.btn_bai6_3);

        btnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab7.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab7.this, Bai2_Lab7.class);
                startActivity(intent);
            }
        });
        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab7.this, Bai3_Lab7.class);
                startActivity(intent);
            }
        });

        btnBai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab7.this, Bai4_Lab7.class);
                startActivity(intent);
            }
        });
        btnBai5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab7.this, Bai5_Lab7.class);
                startActivity(intent);
            }
        });
        btnBai6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab7.this, Bai6_Lab7.class);
                startActivity(intent);
            }
        });
        btnBai7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab7.this, Bai6_2_Lab7.class);
                startActivity(intent);
            }
        });
        btnBai8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab7.this, Bai6_3_Lab7.class);
                startActivity(intent);
            }
        });

    }
}