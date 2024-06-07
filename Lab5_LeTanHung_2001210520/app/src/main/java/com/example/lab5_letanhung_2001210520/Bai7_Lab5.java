package com.example.lab5_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Bai7_Lab5 extends AppCompatActivity {

    private EditText edtDanhMuc, edtMaSp, edtTenSp, edtKetqua;
    private Spinner spinnerDanhMuc;
    private Button btnNhapSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7_lab5);

        edtDanhMuc = findViewById(R.id.edtDanhMuc);
        edtMaSp = findViewById(R.id.edtMaSp);
        edtTenSp = findViewById(R.id.edtTenSp);
        edtKetqua = findViewById(R.id.edtKetqua);
        spinnerDanhMuc = findViewById(R.id.spinnerDanhMuc);
        btnNhapSp = findViewById(R.id.btnNhapSp);

        // Thiết lập adapter cho SpinnerDanhMuc
        String[] danhMuc = {"Samsung", "iPhone", "iPad"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, danhMuc);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDanhMuc.setAdapter(adapter);

        // Đặt sự kiện OnItemSelectedListener cho SpinnerDanhMuc
        spinnerDanhMuc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedDanhMuc = parent.getItemAtPosition(position).toString();
                edtDanhMuc.setText(selectedDanhMuc);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        edtDanhMuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiển thị AlertDialog khi EditText được nhấn
                showDanhMucDialog();
            }
        });

        btnNhapSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maSp = edtMaSp.getText().toString();
                String tenSp = edtTenSp.getText().toString();
                edtKetqua.setText("Mã Sp: " + maSp + ", Tên Sp: " + tenSp);
            }
        });
    }
    private void showDanhMucDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chọn danh mục");
        String[] danhMuc = {"Samsung", "iPhone", "iPad"};
        builder.setItems(danhMuc, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectedDanhMuc = danhMuc[which];
                edtDanhMuc.setText(selectedDanhMuc);
            }
        });
        builder.show();
    }
}