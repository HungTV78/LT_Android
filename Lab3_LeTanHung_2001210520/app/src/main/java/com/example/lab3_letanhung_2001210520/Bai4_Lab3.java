package com.example.lab3_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Bai4_Lab3 extends AppCompatActivity {

    EditText edt_hoten, edt_cmnd, edt_diachi, edt_sdt, edt_ngaysinh, edt_ndbosung;
    RadioGroup radioGroupDegree, radioGroupGender;
    Button button_avatar, btn_guitt;
    CheckBox checkBox_docbao, checkBox_docsach, checkBox_doccoding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4_lab3);

        // Ánh xạ các view
        edt_hoten = findViewById(R.id.edt_hoten);
        edt_cmnd = findViewById(R.id.edt_cmnd);
        edt_diachi = findViewById(R.id.edt_diachi);
        edt_sdt = findViewById(R.id.edt_sdt);
        edt_ngaysinh = findViewById(R.id.edt_ngaysinh);
        edt_ndbosung = findViewById(R.id.edt_ndbosung);
        radioGroupDegree = findViewById(R.id.radioGroupDegree);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        button_avatar = findViewById(R.id.button_avatar);
        btn_guitt = findViewById(R.id.btn_guitt);
        checkBox_docbao = findViewById(R.id.checkBox_docbao);
        checkBox_docsach = findViewById(R.id.checkBox_docsach);
        checkBox_doccoding = findViewById(R.id.checkBox_doccoding);

        btn_guitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    // Lấy thông tin từ các trường nhập liệu
                    String hoten = edt_hoten.getText().toString();
                    String cmnd = edt_cmnd.getText().toString();
                    String diachi = edt_diachi.getText().toString();
                    String sdt = edt_sdt.getText().toString();
                    String ngaysinh = edt_ngaysinh.getText().toString();
                    String ndbosung = edt_ndbosung.getText().toString();
                    boolean docbao = checkBox_docbao.isChecked();
                    boolean docsach = checkBox_docsach.isChecked();
                    boolean doccoding = checkBox_doccoding.isChecked();
                    String bangcap = getSelectedDegree();
                    String gioitinh = getSelectedGender();

                    // Tạo Intent để chuyển thông tin sang Bai4_Child_Lab4
                    Intent intent = new Intent(Bai4_Lab3.this, Bai4_Child_Lab4.class);
                    intent.putExtra("hoten", hoten);
                    intent.putExtra("cmnd", cmnd);
                    intent.putExtra("diachi", diachi);
                    intent.putExtra("sdt", sdt);
                    intent.putExtra("ngaysinh", ngaysinh);
                    intent.putExtra("ndbosung", ndbosung);
                    intent.putExtra("docbao", docbao);
                    intent.putExtra("docsach", docsach);
                    intent.putExtra("doccoding", doccoding);
                    intent.putExtra("bangcap", bangcap);
                    intent.putExtra("gioitinh", gioitinh);

                    // Chuyển sang Bai4_Child_Lab4
                    startActivity(intent);
                }
            }
        });
    }

    // Kiểm tra các ràng buộc
    private boolean validateInput() {
        // Kiểm tra tên không được để trống và phải có ít nhất 3 ký tự
        String hoten = edt_hoten.getText().toString();
        if (hoten.trim().isEmpty() || hoten.length() < 3) {
            edt_hoten.setError("Tên không hợp lệ (ít nhất 3 ký tự)");
            return false;
        }

        // Kiểm tra CMND chỉ được nhập kiểu số và phải có đúng 9 chữ số
        String cmnd = edt_cmnd.getText().toString();
        if (!cmnd.matches("\\d{9}")) {
            edt_cmnd.setError("CMND phải có 9 chữ số");
            return false;
        }

        // Kiểm tra đã chọn ít nhất 1 sở thích
        if (!checkBox_docbao.isChecked() && !checkBox_docsach.isChecked() && !checkBox_doccoding.isChecked()) {
            Toast.makeText(this, "Vui lòng chọn ít nhất 1 sở thích", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Nếu không có lỗi, trả về true
        return true;
    }

    // Lấy bằng cấp đã chọn từ RadioGroup
    private String getSelectedDegree() {
        int selectedId = radioGroupDegree.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        return radioButton.getText().toString();
    }

    // Lấy giới tính đã chọn từ RadioGroup
    private String getSelectedGender() {
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        return radioButton.getText().toString();
    }
}
