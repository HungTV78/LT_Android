package com.example.lab9_letanhung_2001210520.bai3_lab9.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lab9_letanhung_2001210520.R;
import com.example.lab9_letanhung_2001210520.bai3_lab9.Controller.SinhVienHandler;
import com.example.lab9_letanhung_2001210520.bai3_lab9.Model.SinhVien;

import java.util.ArrayList;

public class ViewSinhVienActivity extends AppCompatActivity {
    EditText edtMaSV, edtTenSV;
    Button btnThemSV, btnSuaSV,btnXoaSV;
    ListView lvSinhVien;
    SinhVienHandler sinhVienhander;
    ArrayList<SinhVien> lsSinhVien = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sinh_vien);
        addControl();
        sinhVienhander = new SinhVienHandler(getApplicationContext(),"SinhVien.db",null,1);

        lsSinhVien = sinhVienhander.loadSV();
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, toArrStringLsSinhVien());
        lvSinhVien.setAdapter(adapter);

        //-----------------
        addEvent();
    }

    public void addControl() {
        edtMaSV = findViewById(R.id.edtMaSV);
        edtTenSV = findViewById(R.id.edtTenSV);
        btnSuaSV = findViewById(R.id.btnSuaSV);
        btnThemSV = findViewById(R.id.btnThemSV);
        btnXoaSV = findViewById(R.id.btnXoaSV);
        lvSinhVien = findViewById(R.id.lvSinhVien);

    }

    public void addEvent() {
        btnThemSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sv = new SinhVien(Integer.parseInt(edtMaSV.getText().toString()), edtTenSV.getText().toString());
                sinhVienhander.insertNewSinhVien(sv);
                reloadListView();
            }
        });

        lvSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SinhVien sv = lsSinhVien.get(position);
                edtMaSV.setText(String.valueOf(sv.getMaSV()));
                edtMaSV.setEnabled(false);
                edtTenSV.setText(sv.getTenSV());
            }
        });

        btnSuaSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtMaSV.getText().toString().isEmpty())
                    return;
                else {
                    SinhVien newSinhVien = new SinhVien(Integer.parseInt(edtMaSV.getText().toString()), edtTenSV.getText().toString());
                    SinhVien oldSinhVien = timSinhVien(Integer.parseInt(edtMaSV.getText().toString()), lsSinhVien);
                    sinhVienhander.updateSinhVien(oldSinhVien, newSinhVien);
                    reloadListView();
                }
            }
        });
        btnXoaSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtMaSV.getText().toString().isEmpty())
                    return;
                else {
                    int maSV = Integer.parseInt(edtMaSV.getText().toString());
                    SinhVien svToDelete = timSinhVien(maSV, lsSinhVien);
                    if (svToDelete != null) {
                        sinhVienhander.deleteSinhVien(svToDelete);
                        reloadListView();
                    }
                }
            }
        });

    }

    private void reloadListView() {
        lsSinhVien = sinhVienhander.loadSV();
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, toArrStringLsSinhVien());
        lvSinhVien.setAdapter(adapter);
    }

    private SinhVien timSinhVien(int maSV, ArrayList<SinhVien> lsSinhVien) {
        for (SinhVien sv : lsSinhVien) {
            if (sv.getMaSV() == maSV)
                return sv;
        }
        return null;
    }

    private ArrayList<String> toArrStringLsSinhVien() {
        ArrayList<String> kq = new ArrayList<>();
        for (SinhVien sv: lsSinhVien) {
            kq.add(String.valueOf(sv.getMaSV()) + " " + sv.getTenSV() + "\n");
        }
        return kq;
    }
}
