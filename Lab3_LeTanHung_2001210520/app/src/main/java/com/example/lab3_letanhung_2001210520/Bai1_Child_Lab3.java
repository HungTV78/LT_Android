package com.example.lab3_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;



public class Bai1_Child_Lab3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_child_lab3);
        TextView textKq = findViewById(R.id.text_kq);
        Button btnBack = findViewById(R.id.btn_back);

        String result = getIntent().getStringExtra("result");
        textKq.setText(result);

        btnBack.setOnClickListener(v -> finish());
    }
}