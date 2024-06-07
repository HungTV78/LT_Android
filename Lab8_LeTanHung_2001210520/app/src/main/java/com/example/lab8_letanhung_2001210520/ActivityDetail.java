package com.example.lab8_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int imageId = intent.getIntExtra("id_hinh", 0);
        String title = intent.getStringExtra("ten_truyen");
        String content = intent.getStringExtra("noi_dung");

        // Hiển thị thông tin truyện
        ImageView imageView = findViewById(R.id.imageView);
        TextView textViewTitle = findViewById(R.id.textViewTitle);
        TextView textViewContent = findViewById(R.id.textViewContent);

        imageView.setImageResource(imageId);
        textViewTitle.setText(title);
        textViewContent.setText(content);
    }
}
