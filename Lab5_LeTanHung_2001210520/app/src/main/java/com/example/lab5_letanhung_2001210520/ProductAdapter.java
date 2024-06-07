package com.example.lab5_letanhung_2001210520;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProductAdapter extends ArrayAdapter<String> {
    private Context context;
    private String[] products;
    private String[] descriptions;

    public ProductAdapter(Context context, String[] products, String[] descriptions) {
        super(context, R.layout.grid_item_bai9, products);
        this.context = context;
        this.products = products;
        this.descriptions = descriptions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.grid_item_bai9, parent, false);
        }

        TextView textViewProductName = convertView.findViewById(R.id.textViewProductName);
        TextView textViewProductDescription = convertView.findViewById(R.id.textViewProductDescription);

        textViewProductName.setText(products[position]);
        textViewProductDescription.setText(descriptions[position]);

        return convertView;
    }
}
