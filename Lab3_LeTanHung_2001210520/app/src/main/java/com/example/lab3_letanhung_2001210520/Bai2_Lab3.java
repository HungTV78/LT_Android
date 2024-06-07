package com.example.lab3_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.CompoundButton;

public class Bai2_Lab3 extends AppCompatActivity {

    RadioButton r_a, r_b, r_c;
    Button test;
    TextView mgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_lab3);

        r_a = findViewById(R.id.radio_a);
        r_b = findViewById(R.id.radio_b);
        r_c = findViewById(R.id.radio_c);

        r_a.setOnCheckedChangeListener(listenerRadio);
        r_b.setOnCheckedChangeListener(listenerRadio);
        r_c.setOnCheckedChangeListener(listenerRadio);

        test = findViewById(R.id.test);
        mgs = findViewById(R.id.mgs);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r_b.isChecked()) {
                    mgs.setText("Đúng rồi");
                } else {
                    mgs.setText("Sai");
                }
            }
        });
    }

    CompoundButton.OnCheckedChangeListener listenerRadio
            = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            test.setEnabled(true);
            if (b) {
                mgs.setText("Bạn chọn:" + compoundButton.getText());
            }
        }
    };
}
