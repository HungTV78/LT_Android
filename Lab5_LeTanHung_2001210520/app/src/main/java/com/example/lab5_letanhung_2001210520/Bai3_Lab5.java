package com.example.lab5_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import java.util.ArrayList;

public class Bai3_Lab5 extends AppCompatActivity {

    Spinner spinner_danhmucc, spinner_country;
    ArrayList<Country> arrayListCountry = new ArrayList<>();
    CustomBai3Lab5 adapterCountry;

    int[] lsIdImg = new int[]{R.drawable.india, R.drawable.china, R.drawable.australia, R.drawable.portugal, R.drawable.america, R.drawable.newzealand};
    String[] lsName = new String[]{"India", "China", "Australia", "Portugle", "America","New Zealand"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_lab5);
        spinner_country = findViewById(R.id.spinner_country);
        // Khởi tạo danh sách quóc gia
        arrayListCountry = Country.initArrayListCountry(lsIdImg, lsName);
        adapterCountry = new CustomBai3Lab5(Bai3_Lab5.this, R.layout.layout_item_country, arrayListCountry);
        spinner_country.setAdapter(adapterCountry);
    }

}
