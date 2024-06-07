package com.example.a2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai9 extends AppCompatActivity {
    private EditText editTextSoA, editTextSoB;
    private TextView textViewKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai9);

        editTextSoA = findViewById(R.id.editText_soA);
        editTextSoB = findViewById(R.id.editText_soB);
        textViewKetQua = findViewById(R.id.textView_ketQua);

        Button btnTong = findViewById(R.id.btn_tong);
        Button btnHieu = findViewById(R.id.btn_hieu);
        Button btnTich = findViewById(R.id.tn_tich);
        Button btnThuong = findViewById(R.id.btn_thuong);
        Button btnMaxUSC = findViewById(R.id.btn_maxUSC);

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan("Tổng", "+");
            }
        });

        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan("Hiệu", "-");
            }
        });

        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan("Tích", "*");
            }
        });

        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan("Thương", "/");
            }
        });

        btnMaxUSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan("Ước số chung lớn nhất", "maxUSC");
            }
        });
    }

    private void tinhToan(String tenPhepToan, String phepToan) {
        String strSoA = editTextSoA.getText().toString();
        String strSoB = editTextSoB.getText().toString();
        if (!strSoA.isEmpty() && !strSoB.isEmpty()) {
            double soA = Double.parseDouble(strSoA);
            double soB = Double.parseDouble(strSoB);
            double ketQua = 0;
            switch (phepToan) {
                case "+":
                    ketQua = soA + soB;
                    break;
                case "-":
                    ketQua = soA - soB;
                    break;
                case "*":
                    ketQua = soA * soB;
                    break;
                case "/":
                    if (soB != 0) {
                        ketQua = soA / soB;
                    } else {
                        textViewKetQua.setText("Lỗi: Số b không thể bằng 0 khi chia");
                        return;
                    }
                    break;
                case "maxUSC":
                    ketQua = timMaxUSC((int) soA, (int) soB);
                    break;
            }
            textViewKetQua.setText(tenPhepToan + " 2 số là: " + ketQua);
        } else {
            textViewKetQua.setText("Vui lòng nhập đầy đủ số a và số b");
        }
    }

    private int timMaxUSC(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}