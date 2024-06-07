package com.example.lab4_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] values = getResources().getStringArray(R.array.myHDHs);

        ListView lv = (ListView) findViewById(R.id.dsHDH);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, values);
        lv.setAdapter(adapter);

        final TextView chon = (TextView) findViewById(R.id.textView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chon.setText("Đây là lựa chọn của tôi là: " + values[position]);
            }
        });
    }
}