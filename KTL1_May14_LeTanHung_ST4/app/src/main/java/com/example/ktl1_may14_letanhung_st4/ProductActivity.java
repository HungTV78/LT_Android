package com.example.ktl1_may14_letanhung_st4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Button backButton = findViewById(R.id.button_back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

        Intent intent = getIntent();
        Phone selectedPhone = (Phone) intent.getSerializableExtra("selectedPhone");

        ImageView imageViewPhone = findViewById(R.id.image_view_phone);
        TextView textViewPhoneName = findViewById(R.id.text_view_phone_name);
        TextView textViewManufacturer = findViewById(R.id.text_view_manufacturer);
        TextView textViewYear = findViewById(R.id.text_view_year);
        TextView textViewPrice = findViewById(R.id.text_view_price);

        imageViewPhone.setImageResource(selectedPhone.getImageResourceId());

        textViewPhoneName.setText(selectedPhone.getName());
        textViewManufacturer.setText(selectedPhone.getManufacturer());
        textViewYear.setText(String.valueOf(selectedPhone.getYear()));
        textViewPrice.setText(selectedPhone.getPrice());
    }

    public void onBackButtonClicked(View view) {
        finish();
    }
}
