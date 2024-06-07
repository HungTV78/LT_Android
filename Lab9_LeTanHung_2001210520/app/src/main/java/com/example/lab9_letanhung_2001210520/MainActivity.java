package com.example.lab9_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab9_letanhung_2001210520.bai1_lab9.View.ViewProductsActivity;
import com.example.lab9_letanhung_2001210520.bai2_lab9.View.ViewKhoaActivity;
import com.example.lab9_letanhung_2001210520.bai3_lab9.View.ViewSinhVienActivity;
import com.example.lab9_letanhung_2001210520.bai4_lab9.View.ViewKhoa01Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnBai1 = findViewById(R.id.btn_bai1);
        Button btnBai2 = findViewById(R.id.btn_bai2);
        Button btnBai3 = findViewById(R.id.btn_bai3);
        Button btnBai4 = findViewById(R.id.btn_bai4);
        Button btnBai5 = findViewById(R.id.btn_bai5);

        btnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewProductsActivity.class);
                startActivity(intent);
            }
        });
        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewKhoaActivity.class);
                startActivity(intent);
            }
        });
        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewSinhVienActivity.class);
                startActivity(intent);
            }
        });
        btnBai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewKhoa01Activity.class);
                startActivity(intent);
            }
        });
    }
}