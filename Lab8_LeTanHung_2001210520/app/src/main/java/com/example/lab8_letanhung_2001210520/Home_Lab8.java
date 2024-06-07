package com.example.lab8_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Lab8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lab8);

        Button btnBai1 = findViewById(R.id.btn_bai1);
        Button btnBai2 = findViewById(R.id.btn_bai2);
        Button btnBai3 = findViewById(R.id.btn_bai3);
        Button btnBai4 = findViewById(R.id.btn_bai4);
        Button btnBai5 = findViewById(R.id.btn_bai5);
        Button btnBai6 = findViewById(R.id.btn_bai6);
        Button btnBai7 = findViewById(R.id.btn_bai7);

        btnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab8.this, ReadTxtFile.class);
                startActivity(intent);
            }
        });
        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab8.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab8.this, Bai3_Lab8.class);
                startActivity(intent);
            }
        });
        btnBai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab8.this, Bai4_Lab8.class);
                startActivity(intent);
            }
        });
        btnBai5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab8.this, Bai5_Lab8.class);
                startActivity(intent);
            }
        });
        btnBai6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab8.this, Bai6_Lab8.class);
                startActivity(intent);
            }
        });
        btnBai7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Lab8.this, Bai7_Lab8.class);
                startActivity(intent);
            }
        });
    }
}