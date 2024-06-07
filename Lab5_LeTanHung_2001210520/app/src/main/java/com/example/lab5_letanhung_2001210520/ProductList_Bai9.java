package com.example.lab5_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class ProductList_Bai9 extends AppCompatActivity {
    private ListView listViewProducts;
    private String[] products;
    private String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_bai9);

        listViewProducts = findViewById(R.id.listViewProducts);

        String category = getIntent().getStringExtra("category");
        setTitle(category);

        if (category.equals("Cars & Bikes")) {
            products = getResources().getStringArray(R.array.cars_bikes_products);
            descriptions = getResources().getStringArray(R.array.cars_bikes_descriptions);
        } else if (category.equals("Mobiles & Tablets")) {
            products = getResources().getStringArray(R.array.mobiles_tablets_products);
            descriptions = getResources().getStringArray(R.array.mobiles_tablets_descriptions);

        } else if (category.equals("Electronics & Appliances")) {
            products = getResources().getStringArray(R.array.electronics_appliances);
            descriptions = getResources().getStringArray(R.array.electronics_appliances_descriptions);
        }
        else if (category.equals("Real Estate")) {
            products = getResources().getStringArray(R.array.real_estate_products);
            descriptions = getResources().getStringArray(R.array.electronics_appliances_descriptions);
        }
        else if (category.equals("Home & Lifestyle")) {
            products = getResources().getStringArray(R.array.home_lifestyle_products);
            descriptions = getResources().getStringArray(R.array.electronics_appliances_descriptions);
        }
        else if (category.equals("Jobs")) {
            products = getResources().getStringArray(R.array.jobs_products);
            descriptions = getResources().getStringArray(R.array.electronics_appliances_descriptions);
        }
        else if (category.equals("Services")) {
            products = getResources().getStringArray(R.array.services_products);
            descriptions = getResources().getStringArray(R.array.electronics_appliances_descriptions);
        }
        else if (category.equals("Entertainment")) {
            products = getResources().getStringArray(R.array.entertainment_products);
            descriptions = getResources().getStringArray(R.array.electronics_appliances_descriptions);
        }
        else if (category.equals("Education & Learning")) {
            products = getResources().getStringArray(R.array.education_learning);
            descriptions = getResources().getStringArray(R.array.electronics_appliances_descriptions);
        }

            ProductAdapter adapter = new ProductAdapter(this, products, descriptions);
            listViewProducts.setAdapter(adapter);
        }
}