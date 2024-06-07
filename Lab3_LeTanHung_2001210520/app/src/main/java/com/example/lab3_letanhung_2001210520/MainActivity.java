package com.example.lab3_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNew = findViewById(R.id.btn_new);
        final ImageView img = findViewById(R.id.imageView);
        final int[] ids = {R.drawable.battien, R.drawable.sen, R.drawable.trinhnu, R.drawable.dongtien};

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int n = random.nextInt(ids.length);
                img.setImageResource(ids[n]);
            }
        });
    }
}