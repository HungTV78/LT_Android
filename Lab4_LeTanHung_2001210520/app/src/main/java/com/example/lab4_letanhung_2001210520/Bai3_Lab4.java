package com.example.lab4_letanhung_2001210520;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class Bai3_Lab4 extends AppCompatActivity {
    EditText edtMaNV, edtTenNV;
    RadioGroup radioGroup;
    ImageButton imageButton;
    ListView listView;
    List<String> danhSachNV;
    ArrayAdapter<String> adapter;
    CheckBox[] checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_lab4);
        edtMaNV = findViewById(R.id.edt_manv);
        edtTenNV = findViewById(R.id.edt_tennv);
        radioGroup = findViewById(R.id.radioGroup);
        imageButton = findViewById(R.id.img_xoa);
        listView = findViewById(R.id.dsBai3);
        Button btnNhapNV = findViewById(R.id.btn_nhapnv);

        danhSachNV = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.list_item_layout, R.id.tv_ten_nv, danhSachNV);
        listView.setAdapter(adapter);
        danhSachNV.add("ma1- Quach Tinh");
        danhSachNV.add("ma2 - Hoang Dung");
        danhSachNV.add("ma3 - Hoang That Cong");
        danhSachNV.add("ma4 - Hoang Duoc Su");
        adapter.notifyDataSetChanged();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Integer> indexesToRemove = new ArrayList<>();
                for (int i = 0; i < checkBoxes.length; i++) {
                    if (checkBoxes[i].isChecked()) {
                        indexesToRemove.add(i);
                    }
                }
                // Xoá các nhân viên được chọn
                for (int i = indexesToRemove.size() - 1; i >= 0; i--) {
                    int index = indexesToRemove.get(i);
                    danhSachNV.remove(index);
                }
                setupCheckBoxes();
                adapter.notifyDataSetChanged();
            }
        });

        btnNhapNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maNV = edtMaNV.getText().toString().trim();
                String tenNV = edtTenNV.getText().toString().trim();
                if (!maNV.isEmpty() && !tenNV.isEmpty()) {
                    String newNV = maNV + " - " + tenNV;
                    danhSachNV.add(newNV);
                    adapter.notifyDataSetChanged();

                    edtMaNV.setText("");
                    edtTenNV.setText("");
                } else {
                    Toast.makeText(Bai3_Lab4.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Ánh xạ các checkbox sau khi ListView đã hiển thị dữ liệu
        setupCheckBoxes();
    }

    private void setupCheckBoxes() {
        checkBoxes = new CheckBox[danhSachNV.size()];
        for (int i = 0; i < danhSachNV.size(); i++) {
            View itemView = listView.getChildAt(i);
            if (itemView != null) {
                checkBoxes[i] = itemView.findViewById(R.id.check_nv);
            }
        }
    }
}