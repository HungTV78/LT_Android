package com.example.lab4_letanhung_2001210520;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class FlagAdapter extends ArrayAdapter<Flag> {
    private Context context;
    private ArrayList<Flag> arrayList;
    private int layout;
    private HashMap<String, CountryInfo> countryInfoMap;

    public FlagAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Flag> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = objects;
        this.layout = resource;
        initializeCountryInfoMap();
    }

    private void initializeCountryInfoMap() {
        countryInfoMap = new HashMap<>();
        // Cập nhật thông tin hình ảnh cho mỗi quốc gia
        countryInfoMap.put("Viet Nam", new CountryInfo("Viet Nam", "99.304.221", "Châu Á", R.drawable.vietnam));
        countryInfoMap.put("France", new CountryInfo("France", "67 triệu", "Châu Âu", R.drawable.france));
        countryInfoMap.put("Italy", new CountryInfo("Italy", "60 triệu", "Châu Âu", R.drawable.italy));
        countryInfoMap.put("Laos", new CountryInfo("Laos", "7 triệu", "Châu Á", R.drawable.laos));
        countryInfoMap.put("Laos", new CountryInfo("Ecuador", "17 triệu", "Châu Âu", R.drawable.ecuador));
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Flag flag = arrayList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);
        }
        ImageView img = convertView.findViewById(R.id.imageFlag);
        img.setImageResource(flag.getId());
        TextView txt = convertView.findViewById(R.id.flagName);
        txt.setText(flag.getName());

        convertView.setOnClickListener(view -> {
            CountryInfo info = countryInfoMap.get(flag.getName());
            if (info != null) {
                Intent intent = new Intent(context, Country.class);
                intent.putExtra("ten_quoc_gia", info.getName());
                intent.putExtra("hinh_quoc_gia", flag.getId());
                intent.putExtra("dan_so", info.getPopulation());
                intent.putExtra("luc_dia", info.getContinent());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
