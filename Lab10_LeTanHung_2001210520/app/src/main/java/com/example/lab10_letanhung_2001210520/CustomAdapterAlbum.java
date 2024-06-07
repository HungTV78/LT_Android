package com.example.lab10_letanhung_2001210520;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapterAlbum extends ArrayAdapter<Album> {
    Context context;
    int layoutItem;
    ArrayList<Album> lsAlbum;

    public CustomAdapterAlbum(@NonNull Context context, int resource, ArrayList<Album> lsAlbum) {
        super(context, resource, lsAlbum);
        this.context = context;
        this.layoutItem = resource;
        this.lsAlbum = lsAlbum;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Album album = lsAlbum.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutItem, parent, false);
        }

        ImageView imgAlbum = convertView.findViewById(R.id.imgAlbum);
        Picasso picasso = Picasso.with(context);
        picasso.load(album.getPicture()).resize(100, 100).into(imgAlbum);

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        tvTitle.setText(album.getTitle());

        TextView tvArtist = convertView.findViewById(R.id.tvArtist);
        tvArtist.setText(album.getArtist());

        TextView tvNumberOfTracks = convertView.findViewById(R.id.tvNumberOfTracks);
        tvNumberOfTracks.setText(String.valueOf(album.getNumberOfTracks()));

        return convertView;
    }
}
