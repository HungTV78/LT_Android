package com.example.a2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai4 extends AppCompatActivity {

    private EditText editTextSoA;
    private EditText editTextSoB;
    private TextView editTextKq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        editTextSoA = findViewById(R.id.editText_soA);
        editTextSoB = findViewById(R.id.editText_soB);
        editTextKq = findViewById(R.id.editText_kq);
        Button btnKq = findViewById(R.id.btn_kq);

        btnKq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strA = editTextSoA.getText().toString();
                String strB = editTextSoB.getText().toString();

                if (!strA.isEmpty() && !strB.isEmpty()) {
                    int a = Integer.parseInt(strA);
                    int b = Integer.parseInt(strB);

                    int usclnResult = USCLN_2(a, b);
                    editTextKq.setText(String.valueOf(usclnResult));
                } else {
                    editTextKq.setText("Nhập a và b");
                }
            }
        });
    }

    public static int USCLN_2(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return USCLN_2(b, a % b);
        }
    }
}
