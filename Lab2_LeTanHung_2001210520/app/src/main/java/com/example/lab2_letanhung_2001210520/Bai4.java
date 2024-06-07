package com.example.lab2_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class Bai4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        Button btnBai3 = findViewById(R.id.btn_bai3);
        Button btnBai4 = findViewById(R.id.btn_bai4);
        Button btnBai5 = findViewById(R.id.btn_bai5);
        Button btnBai6 = findViewById(R.id.btn_bai6);
        Button btnBai7 = findViewById(R.id.btn_bai7);
        Button btnBai8 = findViewById(R.id.btn_bai8);
        Button btnBai9 = findViewById(R.id.btn_bai9);

        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai4.this, Bai3.class);
                startActivity(intent);
            }
        });

        btnBai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai4.this, Bai4.class);
                startActivity(intent);
            }
        });
        btnBai5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai4.this, Bai5.class);
                startActivity(intent);
            }
        });
        btnBai6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai4.this, Bai6.class);
                startActivity(intent);
            }
        });

        btnBai7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai4.this, Bai7.class);
                startActivity(intent);
            }
        });
        btnBai8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai4.this, Bai1.class);
                startActivity(intent);
            }
        });

        btnBai9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai4.this, Bai2.class);
                startActivity(intent);
            }
        });


    }
}