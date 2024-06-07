package com.example.lab6_letanhung_2001210520;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class Calculator_Fragment extends Fragment {

    private EditText edt_a, edt_b, edt_KQ;
    private Button btn_Cong, btn_Tru, btn_Nhan, btn_Chia;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator_, container, false);

        edt_a = view.findViewById(R.id.edt_a);
        edt_b = view.findViewById(R.id.edt_b);
        edt_KQ = view.findViewById(R.id.edt_KQ);
        btn_Cong = view.findViewById(R.id.btn_Cong);
        btn_Tru = view.findViewById(R.id.btn_Tru);
        btn_Nhan = view.findViewById(R.id.btn_Nhan);
        btn_Chia = view.findViewById(R.id.btn_Chia);

        btn_Cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        btn_Tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        btn_Nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        btn_Chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        return view;
    }

    private void calculate(char operator) {
        double num1 = Double.parseDouble(edt_a.getText().toString());
        double num2 = Double.parseDouble(edt_b.getText().toString());
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    edt_KQ.setText("Không thể chia cho 0");
                    return;
                }
                break;
        }

        edt_KQ.setText(String.valueOf(result));
    }
}
