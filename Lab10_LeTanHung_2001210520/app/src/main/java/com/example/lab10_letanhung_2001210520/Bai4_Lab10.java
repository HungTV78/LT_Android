package com.example.lab10_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Bai4_Lab10 extends AppCompatActivity {
    private TextView weatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4_lab10);

        weatherTextView = findViewById(R.id.weatherTextView);

        // Execute AsyncTask to fetch weather data
        new FetchWeatherTask().execute();
    }

    private class FetchWeatherTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String result = "";
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL("https://bulk.openweathermap.org/sample/city.list.json");
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                result = stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                JSONArray jsonArray = new JSONArray(result);
                // Lấy thông tin thời tiết từ phần tử đầu tiên
                JSONObject firstCity = jsonArray.getJSONObject(0);
                String cityName = firstCity.getString("name");
                JSONObject coordinates = firstCity.getJSONObject("coord");
                double lon = coordinates.getDouble("lon");
                double lat = coordinates.getDouble("lat");

                // Hiển thị thông tin thời tiết
                String weatherInfo = "City: " + cityName + "\n" +
                        "Coordinates: lon=" + lon + ", lat=" + lat;
                weatherTextView.setText(weatherInfo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
