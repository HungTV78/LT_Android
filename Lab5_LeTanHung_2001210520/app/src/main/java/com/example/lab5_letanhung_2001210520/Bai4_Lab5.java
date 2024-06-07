package com.example.lab5_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class Bai4_Lab5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4_lab5);
        List<Country_Bai4> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new CustomGridAdapter(this, image_details));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                Country country = (Country) o;
                Toast.makeText(Bai4_Lab5.this, "Selected :"
                        + " " + country, Toast.LENGTH_LONG).show();
            }
        });
    }
    private List<Country_Bai4> getListData() {
        List<Country_Bai4> list = new ArrayList<Country_Bai4>();
        Country_Bai4 vietnam = new Country_Bai4(R.drawable.vietnam, "Vietnam", "vn", 98000000);
        Country_Bai4 usa = new Country_Bai4(R.drawable.america, "United States", "us", 320000000);
        Country_Bai4 russia = new Country_Bai4(R.drawable.nga, "Russia", "ru", 142000000);
        Country_Bai4 australia = new Country_Bai4(R.drawable.australia, "Australia", "au", 23766305);
        Country_Bai4 japan = new Country_Bai4(R.drawable.japan, "Japan", "jp", 126788677);
        list.add(vietnam);
        list.add(usa);
        list.add(russia);
        list.add(australia);
        list.add(japan);
        return list;
    }
}