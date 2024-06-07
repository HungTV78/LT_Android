package com.example.ktl2_14_letanhung;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Bai2 extends AppCompatActivity {

    private ListView listViewCountries;
    private RestCountriesService apiService;
    private List<Country> allCountries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        listViewCountries = findViewById(R.id.listViewCountries);
        apiService = ApiClient.getApiService();

        // Lắng nghe sự kiện click của các button
        findViewById(R.id.btnChauPhi).setOnClickListener(v -> filterByContinent("Africa"));
        findViewById(R.id.btnChauA).setOnClickListener(v -> filterByContinent("Asia"));
        findViewById(R.id.btnChauAu).setOnClickListener(v -> filterByContinent("Europe"));
        findViewById(R.id.btnChauMy).setOnClickListener(v -> filterByContinent("Americas"));
        findViewById(R.id.btnChauUc).setOnClickListener(v -> filterByContinent("Oceania"));

        listViewCountries.setOnItemClickListener((parent, view, position, id) -> {
            // Lấy quốc gia được chọn
            Country selectedCountry = allCountries.get(position);
            Intent intent = new Intent(Bai2.this, CountryDetailActivity.class);
            intent.putExtra("country", selectedCountry);
            startActivity(intent);
        });

        fetchCountries();
    }

    private void fetchCountries() {
        apiService.getCountries().enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    allCountries.addAll(response.body());
                    displayCountries("Africa"); // Hiển thị danh sách quốc gia mặc định khi nhận dữ liệu
                } else {
                    Toast.makeText(Bai2.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Toast.makeText(Bai2.this, "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayCountries(String continent) {
        List<String> countryNames = new ArrayList<>();
        for (Country country : allCountries) {
            if (country.continents.contains(continent)) {
                // Truy cập vào trường 'name' của country và sau đó truy cập vào trường 'common' của đối tượng 'Name'
                countryNames.add(country.name.common);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countryNames);
        listViewCountries.setAdapter(adapter);
    }

    private void filterByContinent(String continent) {
        List<String> countryNames = new ArrayList<>();
        for (Country country : allCountries) {
            if (country.continents.contains(continent)) {
                countryNames.add(country.name.common);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countryNames);
        listViewCountries.setAdapter(adapter);
    }
}
