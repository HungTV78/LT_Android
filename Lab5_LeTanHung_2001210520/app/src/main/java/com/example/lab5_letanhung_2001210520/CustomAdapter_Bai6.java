package com.example.lab5_letanhung_2001210520;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;
import java.util.List;

public class CustomAdapter_Bai6 extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Language_Bai6> list;
    private int listItemLayoutResource;
    private int textViewItemNameId;
    private Spinner spinner_language;

    static class ViewHolder {
        ImageView imgLanguage;
        TextView textViewItemName;
    }

    public CustomAdapter_Bai6(Activity context, int listItemLayoutResource,
                              int textViewItemNameId,
                              List<Language_Bai6> list, Spinner spinner_language) {
        this.listItemLayoutResource = listItemLayoutResource;
        this.textViewItemNameId = textViewItemNameId;
        this.list = list;
        this.inflater = context.getLayoutInflater();
        this.spinner_language = spinner_language;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(listItemLayoutResource, parent, false);
            holder = new ViewHolder();
            holder.imgLanguage = convertView.findViewById(R.id.imgLanguage);
            holder.textViewItemName = convertView.findViewById(textViewItemNameId);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Language_Bai6 language = list.get(position);
        holder.textViewItemName.setText(language.getName());
        holder.imgLanguage.setImageResource(language.getIdImg());
        convertView.setBackgroundResource(R.drawable.spinner_item_background);

        return convertView;
    }
}
