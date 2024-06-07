package com.example.ktl1_may14_letanhung_st4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class FlagAdapter extends ArrayAdapter<Flag> {
    public FlagAdapter(Context context, ArrayList<Flag> flags) {
        super(context, 0, flags);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Flag flag = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_flag, parent, false);
        }

        ImageView imageViewFlag = convertView.findViewById(R.id.imageViewFlag);
        TextView textViewName = convertView.findViewById(R.id.textViewName);

        imageViewFlag.setImageResource(flag.getId());
        textViewName.setText(flag.getName());

        // Return the completed view to render on screen
        return convertView;
    }
}
