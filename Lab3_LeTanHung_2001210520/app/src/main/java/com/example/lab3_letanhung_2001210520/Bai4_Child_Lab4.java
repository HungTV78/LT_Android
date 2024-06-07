package com.example.lab3_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class Bai4_Child_Lab4 extends AppCompatActivity {

    TextView txtHoten, txtCmnd, txtBangcap, txtSothich, txtTtbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4_child_lab4);

        txtHoten = findViewById(R.id.txt_hoten);
        txtCmnd = findViewById(R.id.txt_cmnd);
        txtBangcap = findViewById(R.id.txt_bangcap);
        txtSothich = findViewById(R.id.txt_sothich);
        txtTtbs = findViewById(R.id.txt_ttbs);

        // Nhận thông tin từ Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String hoten = extras.getString("hoten");
            String cmnd = extras.getString("cmnd");
            String bangcap = extras.getString("bangcap");
            boolean docbao = extras.getBoolean("docbao");
            boolean docsach = extras.getBoolean("docsach");
            boolean doccoding = extras.getBoolean("doccoding");
            String gioitinh = extras.getString("gioitinh");
            String ngaysinh = extras.getString("ngaysinh");
            String diachi = extras.getString("diachi");
            String ndbosung = extras.getString("ndbosung");

            // Hiển thị thông tin trong các TextView tương ứng
            txtHoten.setText("Họ tên: " + hoten);
            txtCmnd.setText("CMND: " + cmnd);
            txtBangcap.setText("Bằng cấp: " + bangcap);
            txtSothich.setText("Sở thích: " + (docbao ? "Đọc báo, " : "") + (docsach ? "Đọc sách, " : "") + (doccoding ? "Đọc coding" : ""));
            txtTtbs.setText("Thông tin bổ sung: " + ndbosung);

            Button btnDong = findViewById(R.id.btnDong);
            btnDong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Khi nhấn nút "Đóng", đóng activity hiện tại
                    finish();
                }
            });
        }
    }
}
