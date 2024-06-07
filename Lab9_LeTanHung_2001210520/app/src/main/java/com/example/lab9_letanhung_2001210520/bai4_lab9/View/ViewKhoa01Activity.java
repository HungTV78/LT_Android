package com.example.lab9_letanhung_2001210520.bai4_lab9.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lab9_letanhung_2001210520.R;
import com.example.lab9_letanhung_2001210520.bai3_lab9.Model.SinhVien;
import com.example.lab9_letanhung_2001210520.bai4_lab9.Model.Khoa;
import com.example.lab9_letanhung_2001210520.bai4_lab9.Controller.KhoaHandler;

import java.util.ArrayList;

public class ViewKhoa01Activity extends AppCompatActivity {
    EditText edtMKhoa, edtTenKhoa;
    Button btnThemKhoa, btnSuaKhoa,btnXoaKhoa;
    ListView lvKhoa;
    KhoaHandler khoaHandler;
    ArrayList<Khoa> lsKhoa = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_khoa01);
        addControl();
        khoaHandler = new KhoaHandler(getApplicationContext(),"qlsv.db",null,1);

        lsKhoa = khoaHandler.loadKhoa();
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, toArrStringLsKhoa());
        lvKhoa.setAdapter(adapter);

        //-----------------
        addEvent();
    }

    public void addControl() {
        edtMKhoa = findViewById(R.id.edtMKhoa);
        edtTenKhoa = findViewById(R.id.edtTenKhoa);
        btnSuaKhoa = findViewById(R.id.btnSuaKhoa);
        btnThemKhoa = findViewById(R.id.btnThemKhoa);
        btnXoaKhoa = findViewById(R.id.btnXoaKhoa);
        lvKhoa = findViewById(R.id.lvKhoa);

    }

    public void addEvent() {
        btnThemKhoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Khoa k = new Khoa(Integer.parseInt(edtMKhoa.getText().toString()), edtTenKhoa.getText().toString());
                khoaHandler.insertNewKhoa(k);
                reloadListView();
            }
        });

        lvKhoa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Khoa k = lsKhoa.get(position);
                edtMKhoa.setText(String.valueOf(k.getMaKhoa()));
                // edtMKhoa.setVisibility(View.INVISIBLE);
                edtMKhoa.setEnabled(false);
                edtTenKhoa.setText(k.getTenKhoa());
            }
        });

        btnSuaKhoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtMKhoa.getText().toString().isEmpty())
                    return;
                else {
                    Khoa newKhoa = new Khoa(Integer.parseInt(edtMKhoa.getText().toString()), edtTenKhoa.getText().toString());
                    Khoa oldKhoa = timKhoa(Integer.parseInt(edtMKhoa.getText().toString()), lsKhoa);
                    khoaHandler.updateKhoa(oldKhoa, newKhoa);
                    reloadListView();
                }
            }
        });
        btnXoaKhoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtMKhoa.getText().toString().isEmpty())
                    return;
                else {
                    int maSV = Integer.parseInt(edtMKhoa.getText().toString());
                    Khoa khoaToDelete = timKhoa(maSV, lsKhoa);
                    if (khoaToDelete != null) {
                        khoaHandler.deleteKhoa(khoaToDelete);
                        reloadListView();
                    }
                }
            }
        });
    }

    private void reloadListView() {
        lsKhoa = khoaHandler.loadKhoa();
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, toArrStringLsKhoa());
        lvKhoa.setAdapter(adapter);
    }

    private Khoa timKhoa(int makhoa, ArrayList<Khoa> lsKhoa) {
        for (Khoa k : lsKhoa) {
            if (k.getMaKhoa() == makhoa)
                return k;
        }
        return null;
    }

    private ArrayList<String> toArrStringLsKhoa() {
        ArrayList<String> kq = new ArrayList<>();
        for (Khoa k : lsKhoa) {
            kq.add(String.valueOf(k.getMaKhoa()) + " " + k.getTenKhoa() + "\n");
        }
        return kq;
    }
}