package com.example.a2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai6 extends AppCompatActivity {
    private EditText editTextNam;
    private Button btnThucHien;
    private TextView textNamAm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai6);
        editTextNam = findViewById(R.id.editText_nam);
        btnThucHien = findViewById(R.id.btn_thuchien);
        textNamAm = findViewById(R.id.text_namal);

        btnThucHien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyenDuongSangAm();
            }
        });
    }
    private void chuyenDuongSangAm() {
        // Lấy năm từ EditText
        String namDuong = editTextNam.getText().toString();
        if (!namDuong.isEmpty()) {
            try {
                int namDuongInt = Integer.parseInt(namDuong);
                int can = (namDuongInt + 6) % 10; // 6 vì Can bắt đầu từ Giáp (0)
                int chi = (namDuongInt + 8) % 12; // 8 vì Chi bắt đầu từ Tý (0)

                String[] arrayCan = {"Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý"};
                String[] arrayChi = {"Tý", "Sửu", "Dần", "Mẹo", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi"};

                String canNam = arrayCan[can];
                String chiNam = arrayChi[chi];
                String namAm = canNam + " " + chiNam;
                textNamAm.setText("Năm âm lịch: " + namAm);

            } catch (NumberFormatException e) {
                textNamAm.setText("Nhập năm không hợp lệ");
            }
        } else {
            textNamAm.setText("Vui lòng nhập năm dương lịch");
        }
    }

}