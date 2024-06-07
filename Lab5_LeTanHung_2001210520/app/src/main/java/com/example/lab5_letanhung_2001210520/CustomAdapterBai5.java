package com.example.lab5_letanhung_2001210520;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
public class CustomAdapterBai5 extends BaseAdapter{
    private LayoutInflater flater;
    private List<Language> list;
    private int listItemLayoutResource;
    private int textViewItemNameId;
    private int textViewItemPercentId;
    public CustomAdapterBai5(Activity context, int listItemLayoutResource,
                         int textViewItemNameId, int textViewItemPercentId,
                         List<Language> list) {
        this.listItemLayoutResource = listItemLayoutResource;
        this.textViewItemNameId = textViewItemNameId;
        this.textViewItemPercentId = textViewItemPercentId;
        this.list = list;
        this.flater = context.getLayoutInflater();
    }
    @Override
    public int getCount() {
        if(this.list == null) {
            return 0;
        }
        return this.list.size();
    }
    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }
    @Override
    public long getItemId(int position) {
        Language language = (Language) this.getItem(position);
        return language.getId();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Language language = (Language) getItem(position);
        View rowView = this.flater.inflate(this.listItemLayoutResource, null,true);
        TextView textViewItemName = (TextView)
                rowView.findViewById(this.textViewItemNameId);
        textViewItemName.setText(language.getName());
        TextView textViewItemPercent = (TextView)
                rowView.findViewById(textViewItemPercentId);
        textViewItemPercent.setText(language.getPercent() + "%");
        return rowView;
    }
}
