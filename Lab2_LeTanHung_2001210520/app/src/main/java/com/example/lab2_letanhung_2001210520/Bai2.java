package com.example.lab2_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bai2 extends AppCompatActivity {

    EditText edtUs, edtPw;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        Intent intent = getIntent();
        addControl();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        edtUs.setText(sharedPreferences.getString("us", null));
        edtPw.setText(sharedPreferences.getString("pw", null));
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String us = edtUs.getText().toString();
        String pw = edtPw.getText().toString();

        editor.putString("us", us);
        editor.putString("pw", pw);
        editor.commit();
    }

    private void addControl() {
        edtUs = findViewById(R.id.edtUs);
        edtPw = findViewById(R.id.edtPw);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_LONG).show();
            }
        });
    }
}
