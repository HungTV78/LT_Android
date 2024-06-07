package com.example.lab3_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bai1_Lab3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_lab3);

        final EditText edt_a = findViewById(R.id.edt_a);
        final EditText edt_b = findViewById(R.id.edt_b);
        Button btnKetQua = findViewById(R.id.btn_ketqua);

        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double a = Double.parseDouble(edt_a.getText().toString());
                    double b = Double.parseDouble(edt_b.getText().toString());
                    String result;
                    if(a == 0) {
                        if(b == 0) {
                            result = "Phương trình có vô số nghiệm.";
                        } else {
                            result = "Phương trình vô nghiệm.";
                        }
                    } else {
                        result = "Phương trình có một nghiệm: x = " + (-b/a);
                    }

                    Intent intent = new Intent(Bai1_Lab3.this, Bai1_Child_Lab3.class);
                    intent.putExtra("result", result);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    Toast.makeText(Bai1_Lab3.this, "Vui lòng nhập số hợp lệ.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
