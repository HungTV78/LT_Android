package com.example.lab5_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Bai9_Lab5 extends AppCompatActivity {
    private String[] categories = {
            "Cars & Bikes",
            "Mobiles & Tablets",
            "Electronics & Appliances",
            "Real Estate",
            "Home & Lifestyle",
            "Jobs",
            "Services",
            "Entertainment",
            "Education & Learning"
    };

    private int[] categoryIcons = {
            R.drawable.car_icon,
            R.drawable.mobile_icon,
            R.drawable.electronics_icon,
            R.drawable.real_estate_icon,
            R.drawable.home_icon,
            R.drawable.job_icon,
            R.drawable.services_icon,
            R.drawable.entertainment_icon,
            R.drawable.education_icon
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai9_lab5);

        GridView gridView = findViewById(R.id.gridView);
        CategoryAdapter_Bai9 adapter = new CategoryAdapter_Bai9(Bai9_Lab5.this, categories, categoryIcons);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Sửa Intent
                Intent intent = new Intent(Bai9_Lab5.this, ProductList_Bai9.class);
                intent.putExtra("category", categories[position]);
                startActivity(intent);
            }
        });
    }
}