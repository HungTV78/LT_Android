package com.example.a2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai8 extends AppCompatActivity {
    private EditText editTextFahrenheit;
    private EditText editTextCelsius;
    private Button btnConvertToCelsius;
    private Button btnConvertToFahrenheit;
    private Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8);

        editTextFahrenheit = findViewById(R.id.editTextNumber);
        editTextCelsius = findViewById(R.id.editTextNumber2);
        btnConvertToCelsius = findViewById(R.id.btn_celsius);
        btnConvertToFahrenheit = findViewById(R.id.btn_fahrenheit);
        btnClear = findViewById(R.id.btn_clear);

        btnConvertToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToCelsius();
            }
        });

        btnConvertToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToFahrenheit();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }

    private void convertToCelsius() {
        if (!editTextFahrenheit.getText().toString().isEmpty()) {
            double fahrenheit = Double.parseDouble(editTextFahrenheit.getText().toString());
            double celsius = (fahrenheit - 32) * 5 / 9;
            editTextCelsius.setText(String.valueOf(celsius));
        }
    }

    private void convertToFahrenheit() {
        if (!editTextCelsius.getText().toString().isEmpty()) {
            double celsius = Double.parseDouble(editTextCelsius.getText().toString());
            double fahrenheit = celsius * 9 / 5 + 32;
            editTextFahrenheit.setText(String.valueOf(fahrenheit));
        }
    }

    private void clearFields() {
        editTextFahrenheit.setText("");
        editTextCelsius.setText("");
    }
}