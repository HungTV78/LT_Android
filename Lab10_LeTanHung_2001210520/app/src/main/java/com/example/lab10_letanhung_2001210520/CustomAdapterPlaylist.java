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

public class CustomAdapterPlaylist extends ArrayAdapter<Playlist> {
    Context context;
    int layoutItem;
    ArrayList<Playlist> lsPlaylist;

    public CustomAdapterPlaylist(@NonNull Context context, int resource, ArrayList<Playlist> lsPlaylist) {
        super(context, resource, lsPlaylist);
        this.context = context;
        this.layoutItem = resource;
        this.lsPlaylist = lsPlaylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Playlist playlist = lsPlaylist.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutItem, parent, false);
        }

        ImageView imgPlaylist = convertView.findViewById(R.id.imgPlaylist);
        Picasso.with(context).load(playlist.getPicture()).resize(100, 100).into(imgPlaylist);

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        tvTitle.setText(playlist.getTitle());

        TextView tvArtist = convertView.findViewById(R.id.tvArtist);
        tvArtist.setText(playlist.getArtist());

        TextView tvAlbum = convertView.findViewById(R.id.tvAlbum);
        tvAlbum.setText(playlist.getAlbum());

        return convertView;
    }
}
