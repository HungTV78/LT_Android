package com.example.a2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Bai7 extends AppCompatActivity {
    private EditText editTextDecimal;
    private Button btnBinary;
    private Button btnHexa;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7);

        editTextDecimal = findViewById(R.id.editText_so);
        btnBinary = findViewById(R.id.btn_binary);
        btnHexa = findViewById(R.id.btn_hexa);
        textResult = findViewById(R.id.text_result);
        btnBinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToBinary();
            }
        });

        // Gán sự kiện cho nút chuyển đổi sang hệ thập lục phân
        btnHexa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToHexa();
            }
        });
    }

    // Phương thức chuyển đổi sang hệ nhị phân
    private void convertToBinary() {
        try {
            // Lấy giá trị nhập từ EditText
            String decimalStr = editTextDecimal.getText().toString();
            // Chuyển đổi sang số nguyên
            int decimal = Integer.parseInt(decimalStr);
            // Chuyển đổi sang hệ nhị phân
            String binaryResult = Integer.toBinaryString(decimal);
            // Hiển thị kết quả
            textResult.setText("Binary Result: " + binaryResult);
        } catch (NumberFormatException e) {
            textResult.setText("Invalid Input");
        }
    }

    // Phương thức chuyển đổi sang hệ thập lục phân
    private void convertToHexa() {
        try {
            // Lấy giá trị nhập từ EditText
            String decimalStr = editTextDecimal.getText().toString();
            // Chuyển đổi sang số nguyên
            int decimal = Integer.parseInt(decimalStr);
            // Chuyển đổi sang hệ thập lục phân
            String hexaResult = Integer.toHexString(decimal);
            // Hiển thị kết quả
            textResult.setText("Hexa Result: " + hexaResult.toUpperCase());
        } catch (NumberFormatException e) {
            textResult.setText("Invalid Input");
        }
    }
}