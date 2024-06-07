package com.example.lab3_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bai3_Lab3 extends AppCompatActivity {

    private EditText edtName, edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_lab3);

        edtName = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);

        Button btnSendInfo = findViewById(R.id.btn_ketqua);
        btnSendInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();

                Intent intent = new Intent(Bai3_Lab3.this, Bai3_Child_Lab3.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }
}
