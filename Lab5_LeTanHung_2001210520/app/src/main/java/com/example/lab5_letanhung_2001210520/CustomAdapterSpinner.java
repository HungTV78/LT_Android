package com.example.lab5_letanhung_2001210520;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapterSpinner extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private ArrayList <Fruit>arrayListFruit;
    private int layoutItem;

    public CustomAdapterSpinner(Activity context, int layoutItem, ArrayList<Fruit> arrayListFruit) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayListFruit = arrayListFruit;
        this.layoutItem = layoutItem;
    }

    @Override
    public int getCount() {
        return this.arrayListFruit.size();
    }

    @Override
    public Object getItem(int position) {
        return this.arrayListFruit.get(position);
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
            holder.imageView = convertView.findViewById(R.id.imgFruit);
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvPrice = convertView.findViewById(R.id.tvPrice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Fruit fruit = arrayListFruit.get(position);
        holder.imageView.setImageResource(fruit.getIdImg());
        holder.tvName.setText(fruit.getName());
        holder.tvPrice.setText(String.valueOf(fruit.getPrice()));

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView tvName;
        TextView tvPrice;
    }
}
