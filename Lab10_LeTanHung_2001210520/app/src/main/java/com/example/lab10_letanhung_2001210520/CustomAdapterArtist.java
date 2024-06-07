package com.example.lab10_letanhung_2001210520;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapterArtist extends ArrayAdapter<Artist> {

    Context context;
    int layoutItem;
    ArrayList<Artist> lsArtist = new ArrayList<>();

    public CustomAdapterArtist(@NonNull Context context, int resource, ArrayList<Artist> lsArtist) {
        super(context, resource, lsArtist);
        this.context=context;
        this.layoutItem=resource;
        this.lsArtist = lsArtist;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Artist artist = lsArtist.get(position);

        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(layoutItem,null);
        }
        ImageView imgArtist = (ImageView) convertView.findViewById(R.id.imgArtist);
        Picasso.with(context).load(artist.getPiclink()).
                resize(100,100).into(imgArtist);

        TextView tvNameArtist = (TextView) convertView.findViewById(R.id.tvNameArtist);
        tvNameArtist.setText(artist.getName());

        TextView tvNuFans = (TextView) convertView.findViewById(R.id.tvNuFans);
        tvNuFans.setText(String.valueOf(artist.getNumberFans()));

        return convertView;
    }
}
