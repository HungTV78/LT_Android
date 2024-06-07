package com.example.lab2_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bai3 extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    Button buttonLogin, buttonNewAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        editTextUsername = findViewById(R.id.editTextText);
        editTextPassword = findViewById(R.id.editTextTextPassword2);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonNewAccount = findViewById(R.id.buttonNewAccount);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ EditText
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Lưu dữ liệu vào SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.apply();

                // Hiển thị thông báo khi đăng nhập thành công
                Toast.makeText(Bai3.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
