package com.example.lab3_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bai6_Lab3 extends AppCompatActivity {

    private Map<Integer, String> flowerNames;
    private ImageView img;
    private int[] ids;
    private int currentIndex = 0;
    private EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai6_lab3);

        Button btnNew = findViewById(R.id.btn_new);
        ImageButton btnHead = findViewById(R.id.btn_head);
        ImageButton btnPrevious = findViewById(R.id.btn_previous);
        ImageButton btnNext = findViewById(R.id.btn_next);
        ImageButton btnTail = findViewById(R.id.btn_tail);
        img = findViewById(R.id.imageView);
        edtSearch = findViewById(R.id.edt_search);
        ids = new int[]{R.drawable.battien,R.drawable.luuly,R.drawable.camchuong, R.drawable.sen, R.drawable.trinhnu, R.drawable.dongtien, R.drawable.hoahong, R.drawable.hoalan};

        flowerNames = new HashMap<>();
        flowerNames.put(R.drawable.battien, "Bat tien");
        flowerNames.put(R.drawable.sen, "Sen");
        flowerNames.put(R.drawable.trinhnu, "Trinh nu");
        flowerNames.put(R.drawable.hoalan, "Hoa lan");
        flowerNames.put(R.drawable.hoahong, "Hoa hong");
        flowerNames.put(R.drawable.luuly, "luu ly");
        flowerNames.put(R.drawable.camchuong, "cam chuong");
        flowerNames.put(R.drawable.dongtien, "Dong tien");

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRandomFlower();
            }
        });

        btnHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = 0;
                showFlower(currentIndex);
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex > 0) {
                    currentIndex--;
                    showFlower(currentIndex);
                } else {
                    Toast.makeText(Bai6_Lab3.this, "Đã ở hoa đầu tiên rồi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex < ids.length - 1) {
                    currentIndex++;
                    showFlower(currentIndex);
                } else {
                    Toast.makeText(Bai6_Lab3.this, "Đã ở hoa cuối cùng rồi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnTail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = ids.length - 1;
                showFlower(currentIndex);
            }
        });

        // Bắt sự kiện thay đổi nội dung của EditText để tìm kiếm hoa
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchFlower(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void showFlower(int index) {
        img.setImageResource(ids[index]);
        String flowerName = flowerNames.get(ids[index]);
        Toast.makeText(Bai6_Lab3.this, flowerName, Toast.LENGTH_SHORT).show();
    }

    private void showRandomFlower() {
        Random random = new Random();
        int n = random.nextInt(ids.length);
        currentIndex = n;
        showFlower(n);
    }

    private void searchFlower(String searchString) {
        for (Map.Entry<Integer, String> entry : flowerNames.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(searchString)) {
                for (int i = 0; i < ids.length; i++) {
                    if (ids[i] == entry.getKey()) {
                        currentIndex = i;
                        showFlower(i);
                        return;
                    }
                }
            }
        }
        // Nếu không tìm thấy hoa, hiển thị thông báo
        Toast.makeText(Bai6_Lab3.this, "Không có hoa tương ứng", Toast.LENGTH_SHORT).show();
    }
}
