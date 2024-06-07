package com.example.ktl2_14_letanhung;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class CountryDetailActivity extends AppCompatActivity {

    private TextView tvCountryName, tvOfficialName, tvCapital, tvPopulation, tvLanguages;
    private ImageView ivFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        tvCountryName = findViewById(R.id.tvCountryName);
        tvOfficialName = findViewById(R.id.tvOfficialName);
        tvCapital = findViewById(R.id.tvCapital);
        tvPopulation = findViewById(R.id.tvPopulation);
        tvLanguages = findViewById(R.id.tvLanguages);
        ivFlag = findViewById(R.id.ivFlag);

        Country country = (Country) getIntent().getSerializableExtra("country");

        tvCountryName.setText(country.name.common);
        tvOfficialName.setText(country.name.official);
        tvCapital.setText("Capital: " + String.join(", ", country.capital));
        tvPopulation.setText("Population: " + country.population);
        tvLanguages.setText("Languages: " + country.languages.values().toString());
        Picasso.get().load(country.flags.png).into(ivFlag);
    }
}
