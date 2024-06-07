package com.example.lab5_letanhung_2001210520;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomBai3Lab5 extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private ArrayList<Country> arrayListCountry;
    private int layoutItem;

    public CustomBai3Lab5(Activity context, int layoutItem, ArrayList<Country> arrayListCountry) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayListCountry = arrayListCountry;
        this.layoutItem = layoutItem;
    }

    @Override
    public int getCount() {
        return this.arrayListCountry.size();
    }

    @Override
    public Object getItem(int position) {
        return this.arrayListCountry.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layoutItem, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imgCountry);
            holder.tvName = convertView.findViewById(R.id.tvName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Country country = arrayListCountry.get(position);
        holder.imageView.setImageResource(country.getIdImg());
        holder.tvName.setText(country.getName());

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView tvName;
    }
}
