package com.example.lab3_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Bai5_Lab3 extends AppCompatActivity {

    private ArrayList<Integer> numberList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5_lab3);

        // Khởi tạo các view
        EditText edtNumber = findViewById(R.id.editTextNumber);
        EditText edtDaySo = findViewById(R.id.edt_dayso);
        Button btnAdd = findViewById(R.id.btn_add);
        Button btnCreate = findViewById(R.id.btn_create);
        Button btnSort = findViewById(R.id.btn_sort);
        Button btnTong = findViewById(R.id.btn_tong);
        Button btnXuatXuoi = findViewById(R.id.btn_xuatxuoi);
        Button btnXuatNguoc = findViewById(R.id.btn_xuatnguoc);
        Button btnDaoNguoc = findViewById(R.id.btn_daonn);
        CheckBox checkChan = findViewById(R.id.check_chan);
        CheckBox checkLe = findViewById(R.id.check_le);
        CheckBox checkNgauNhien = findViewById(R.id.check_ngaunhien);
        CheckBox checkSoAm = findViewById(R.id.check_soam);
        RadioGroup radioGroup = findViewById(R.id.rdo_group);
        RadioButton rdoTang = findViewById(R.id.rdo_tang);
        RadioButton rdoGiam = findViewById(R.id.rdo_giam);

        // Bắt sự kiện cho Button Add
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberStr = edtNumber.getText().toString();
                if (!numberStr.isEmpty()) {
                    int number = Integer.parseInt(numberStr);
                    numberList.add(number);
                    edtDaySo.setText(numberList.toString());
                    edtNumber.setText("");
                }
            }
        });

        // Bắt sự kiện cho Button Create
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.clear();
                int n = Integer.parseInt(edtDaySo.getText().toString());
                boolean isChan = checkChan.isChecked();
                boolean isLe = checkLe.isChecked();
                boolean isNgauNhien = checkNgauNhien.isChecked();
                boolean isSoAm = checkSoAm.isChecked();
                generateArray(n, isChan, isLe, isNgauNhien, isSoAm);
                edtDaySo.setText(numberList.toString());
            }
        });

        // Bắt sự kiện cho Button Sort
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                if (checkedId == R.id.rdo_tang) {
                    Collections.sort(numberList);
                } else if (checkedId == R.id.rdo_giam) {
                    Collections.sort(numberList, Collections.reverseOrder());
                }
                edtDaySo.setText(numberList.toString());
            }
        });

        // Bắt sự kiện cho Button Tìm Max/Min
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int max = Collections.max(numberList);
                int min = Collections.min(numberList);
                Toast.makeText(Bai5_Lab3.this, "Max: " + max + ", Min: " + min, Toast.LENGTH_SHORT).show();
            }
        });

        // Bắt sự kiện cho Button Xuất Xuôi
        btnXuatXuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();
                for (int number : numberList) {
                    result.append(number).append(" ");
                }
                Toast.makeText(Bai5_Lab3.this, result.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        // Bắt sự kiện cho Button Xuất Ngược
        btnXuatNguoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();
                for (int i = numberList.size() - 1; i >= 0; i--) {
                    result.append(numberList.get(i)).append(" ");
                }
                Toast.makeText(Bai5_Lab3.this, result.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        // Bắt sự kiện cho Button Đảo Ngẫu Nhiên
        btnDaoNguoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(numberList);
                edtDaySo.setText(numberList.toString());
            }
        });
    }

    // Phương thức để tạo dãy số ngẫu nhiên
    private void generateArray(int n, boolean isChan, boolean isLe, boolean isNgauNhien, boolean isSoAm) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int number;
            if (isNgauNhien) {
                number = random.nextInt(100);
            } else {
                if (isChan && isLe) {
                    number = random.nextInt(100);
                } else if (isChan) {
                    number = random.nextInt(50) * 2;
                } else if (isLe) {
                    number = random.nextInt(50) * 2 + 1;
                } else {
                    number = random.nextInt(50) * 2 - 50;
                }
            }
            if (isSoAm && random.nextBoolean()) {
                number *= -1;
            }
            numberList.add(number);
        }
    }
}
