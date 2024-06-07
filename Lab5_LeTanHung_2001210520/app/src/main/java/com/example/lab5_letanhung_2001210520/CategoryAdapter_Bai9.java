package com.example.lab5_letanhung_2001210520;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryAdapter_Bai9 extends BaseAdapter {
    private Context context;
    private String[] categories;
    private int[] categoryIcons;

    public CategoryAdapter_Bai9(Context context, String[] categories, int[] categoryIcons) {
        this.context = context;
        this.categories = categories;
        this.categoryIcons = categoryIcons;
    }

    @Override
    public int getCount() {
        return categories.length;
    }

    @Override
    public Object getItem(int position) {
        return categories[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_bai9_lab5, parent, false);
        }

        ImageView imageViewCategory = convertView.findViewById(R.id.imageViewCategory);
        TextView textViewCategory = convertView.findViewById(R.id.textViewCategory);

        imageViewCategory.setImageResource(categoryIcons[position]);
        textViewCategory.setText(categories[position]);

        return convertView;
    }
}
