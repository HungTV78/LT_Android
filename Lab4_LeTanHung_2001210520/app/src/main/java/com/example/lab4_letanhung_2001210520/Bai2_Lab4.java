package com.example.lab4_letanhung_2001210520;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Bai2_Lab4 extends AppCompatActivity {
    ListView list;
    ArrayList<Flag> arrayList;
    FlagAdapter flagAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_lab4);

        list = findViewById(R.id.list);
        arrayList = Flag.initFlag();
        flagAdapter = new FlagAdapter(this, R.layout.layout_row2_lab4, arrayList);
        list.setAdapter(flagAdapter);
    }
}
