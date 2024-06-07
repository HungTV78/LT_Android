package com.example.lab2_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai7 extends AppCompatActivity {

    private EditText editTextSoA, editTextSoB;
    private TextView textViewKetQua;
    private Button btnTong, btnHieu, btnTich, btnThuong, btnMaxUSC, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7);

        // Ánh xạ các thành phần từ layout XML
        editTextSoA = findViewById(R.id.editText_soA);
        editTextSoB = findViewById(R.id.editText_soB);
        textViewKetQua = findViewById(R.id.textView_ketQua);
        btnTong = findViewById(R.id.btn_tong);
        btnHieu = findViewById(R.id.btn_hieu);
        btnTich = findViewById(R.id.tn_tich);
        btnThuong = findViewById(R.id.btn_thuong);
        btnMaxUSC = findViewById(R.id.btn_maxUSC);
        btnThoat = findViewById(R.id.btn_thoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayResult('+');
            }
        });

        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayResult('-');
            }
        });

        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayResult('*');
            }
        });

        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayResult('/');
            }
        });

        btnMaxUSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thực hiện tính toán ước số chung lớn nhất
                int a = Integer.parseInt(editTextSoA.getText().toString());
                int b = Integer.parseInt(editTextSoB.getText().toString());
                int usc = calculateUSCLN(a, b);
                textViewKetQua.setText("Ước số chung lớn nhất: " + usc);
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Đóng chương trình
                finish();
            }
        });
    }

    // Phương thức thực hiện tính toán và hiển thị kết quả lên TextView
    private void calculateAndDisplayResult(char operator) {
        int a = Integer.parseInt(editTextSoA.getText().toString());
        int b = Integer.parseInt(editTextSoB.getText().toString());
        int result = 0;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                } else {
                    textViewKetQua.setText("Không thể chia cho 0");
                    return;
                }
                break;
        }
        textViewKetQua.setText(String.valueOf(result));
    }

    // Phương thức tính ước số chung lớn nhất
    private int calculateUSCLN(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
