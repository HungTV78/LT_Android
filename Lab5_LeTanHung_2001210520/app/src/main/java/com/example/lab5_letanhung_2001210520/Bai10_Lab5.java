package com.example.lab5_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.TextView;
import java.util.ArrayList;

public class Bai10_Lab5 extends AppCompatActivity {

    private GridView gridView;
    private Button btnCheckAll, btnClearAll;
    private TextView tvMessage;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> items;
    private boolean[] checkedState;

    private Integer[] imageIds = {
            R.drawable.india, R.drawable.japan, R.drawable.portugal, R.drawable.newzealand, R.drawable.america,
            R.drawable.china, R.drawable.australia, R.drawable.vietnam
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai10_lab5);

        gridView = findViewById(R.id.gridView);
        btnCheckAll = findViewById(R.id.btnCheckAll);
        btnClearAll = findViewById(R.id.btnClearAll);
        tvMessage = findViewById(R.id.tvMessage);

        items = new ArrayList<>();
        items.add("pic_a.png");
        items.add("pic_b.png");
        items.add("pic_c.png");
        items.add("pic_d.png");
        items.add("pic_e.png");
        items.add("pic_f.png");
        items.add("pic_g.png");
        items.add("pic_h.png");

        checkedState = new boolean[items.size()];

        // Khởi tạo adapter và gắn vào GridView
        adapter = new GridAdapter_Bai10(this, items, imageIds);
        gridView.setAdapter(adapter);

        btnCheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAllItems();
            }
        });

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllItems();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                updateMessage();
            }
        });
    }

    private void checkAllItems() {
        for (int i = 0; i < gridView.getCount(); i++) {
            gridView.setItemChecked(i, true);
            checkedState[i] = true;
        }
        updateMessage();
    }


    // Hàm để uncheck tất cả các item trong GridView
    private void clearAllItems() {
        for (int i = 0; i < gridView.getCount(); i++) {
            gridView.setItemChecked(i, false);
            checkedState[i] = false;
        }
        updateMessage();
    }

    private void updateMessage() {
        int checkedItemCount = gridView.getCheckedItemCount();
        if (tvMessage != null) {
            if (checkedItemCount == 0) {
                tvMessage.setVisibility(View.GONE);
            } else {
                tvMessage.setVisibility(View.VISIBLE);
                tvMessage.setText("Selected items: " + checkedItemCount);
            }
        }
    }
}
