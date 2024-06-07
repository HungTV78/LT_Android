package com.example.lab5_letanhung_2001210520;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import java.util.ArrayList;
public class GridAdapter_Bai10 extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> items;
    private Integer[] imageIds;
    private boolean[] checkedState;

    public GridAdapter_Bai10(Context context, ArrayList<String> items, Integer[] imageIds) {
        super(context, R.layout.grid_item_layout_bai10, items);
        this.context = context;
        this.items = items;
        this.imageIds = imageIds;
        this.checkedState = new boolean[items.size()];
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item_layout_bai10, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageViewThumbnail = convertView.findViewById(R.id.imageViewThumbnail);
            viewHolder.checkBox = convertView.findViewById(R.id.checkBox);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageViewThumbnail.setImageResource(imageIds[position]);
        viewHolder.checkBox.setChecked(checkedState[position]);

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = (CheckBox) v;
                checkedState[position] = checkBox.isChecked();
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageViewThumbnail;
        CheckBox checkBox;
    }
}

