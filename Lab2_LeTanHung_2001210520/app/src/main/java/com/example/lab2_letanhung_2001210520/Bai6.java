package com.example.lab2_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.app.AlertDialog;

public class Bai6 extends AppCompatActivity {

    private EditText edtHoTen, edtCMND, edtThemTT;
    private RadioButton radioTrungCap, radioCaoDang, radioDaiHoc;
    private CheckBox checkBoxDocBao, checkBoxDocSach, checkBoxDocCoding;
    private Button btnGuiTT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai6);

        // Ánh xạ các view từ layout XML
        edtHoTen = findViewById(R.id.edt_hoten);
        edtCMND = findViewById(R.id.edt_cmnd);
        edtThemTT = findViewById(R.id.edt_themtt);
        radioTrungCap = findViewById(R.id.radio_trungcap);
        radioCaoDang = findViewById(R.id.radio_caodang);
        radioDaiHoc = findViewById(R.id.radio_daihoc);
        checkBoxDocBao = findViewById(R.id.checkBox_docbao);
        checkBoxDocSach = findViewById(R.id.checkBox_docsach);
        checkBoxDocCoding = findViewById(R.id.checkBox_daihoc);
        btnGuiTT = findViewById(R.id.btn_guitt);

        // Thiết lập sự kiện click cho nút "Gửi thông tin"
        btnGuiTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin từ các trường nhập
                String hoTen = edtHoTen.getText().toString();
                String cmnd = edtCMND.getText().toString();
                String themTT = edtThemTT.getText().toString();
                String bangCap = "";
                String soThich = "";

                if (radioTrungCap.isChecked()) {
                    bangCap = "Trung cấp";
                } else if (radioCaoDang.isChecked()) {
                    bangCap = "Cao đẳng";
                } else if (radioDaiHoc.isChecked()) {
                    bangCap = "Đại học";
                }

                if (checkBoxDocBao.isChecked()) {
                    soThich += "Đọc báo, ";
                }
                if (checkBoxDocSach.isChecked()) {
                    soThich += "Đọc sách, ";
                }
                if (checkBoxDocCoding.isChecked()) {
                    soThich += "Đọc coding";
                }

                String nd =
                        "Họ tên: " + hoTen + "\n" +
                        "CMND: " + cmnd + "\n" +
                        "Bằng cấp: " + bangCap + "\n" +
                        "Sở thích: " + soThich + "\n" +
                        "Thông tin bổ sung: " + themTT;

                AlertDialog.Builder builder = new AlertDialog.Builder(Bai6.this);
                builder.setTitle("Thông tin sinh viên");
                builder.setMessage(nd);
                builder.setPositiveButton("Đóng", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
