package com.example.a2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai5 extends AppCompatActivity {
    private EditText editTextSoA;
    private EditText editTextSoB;
    private Button btnThucHien;
    private TextView textKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5);

        editTextSoA = findViewById(R.id.editText_soA);
        editTextSoB = findViewById(R.id.editText_soB);
        btnThucHien = findViewById(R.id.btn_thuchien);
        textKetQua = findViewById(R.id.text_kq);
        btnThucHien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy giá trị từ EditText
                String strSoA = editTextSoA.getText().toString();
                String strSoB = editTextSoB.getText().toString();

                // Kiểm tra xem người dùng đã nhập đầy đủ thông tin chưa
                if (!strSoA.isEmpty() && !strSoB.isEmpty()) {
                    // Chuyển giá trị từ chuỗi sang số
                    double a = Double.parseDouble(strSoA);
                    double b = Double.parseDouble(strSoB);

                    // Giải phương trình bậc 1
                    if (a != 0) {
                        double x = -b / a;
                        textKetQua.setText("Kết quả: x = " + x);
                    } else {
                        // Nếu a = 0, không phải là phương trình bậc 1
                        textKetQua.setText("Không phải phương trình bậc 1");
                    }
                } else {
                    // Hiển thị thông báo nếu người dùng chưa nhập đủ thông tin
                    textKetQua.setText("Vui lòng nhập đầy đủ thông tin");
                }
            }
        });
    }
}