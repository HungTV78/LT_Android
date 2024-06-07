package com.example.lab4_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Country extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        Intent intent = getIntent();
        String tenQuocGia = intent.getStringExtra("ten_quoc_gia");
        String danSo = intent.getStringExtra("dan_so");
        String lucDia = intent.getStringExtra("luc_dia");
        // Lấy resource ID của hình ảnh từ Intent, với -1 là giá trị mặc định nếu không tìm thấy.
        int imageResId = intent.getIntExtra("hinh_quoc_gia", -1);

        ImageView imageViewFlag = findViewById(R.id.imageViewFlag); // Đảm bảo rằng bạn có một ImageView trong layout của Country activity với id là imageViewFlag
        if(imageResId != -1) {
            imageViewFlag.setImageResource(imageResId); // Thiết lập hình ảnh cho ImageView nếu tìm thấy ID hợp lệ
        }

        // Hiển thị thông tin chi tiết
        TextView textViewTenQuocGia = findViewById(R.id.textViewCountryName);
        TextView textViewDanSo = findViewById(R.id.textViewPopulation);
        TextView textViewLucDia = findViewById(R.id.textViewContinent);

        textViewTenQuocGia.setText(tenQuocGia);
        textViewDanSo.setText(danSo);
        textViewLucDia.setText(lucDia);
    }
}
