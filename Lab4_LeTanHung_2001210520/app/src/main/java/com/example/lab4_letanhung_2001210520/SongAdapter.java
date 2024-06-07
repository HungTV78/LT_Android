package com.example.lab4_letanhung_2001210520;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Context context, List<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Song song = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_song, parent, false);
        }

        TextView tvName = convertView.findViewById(R.id.tvSongName);
        TextView tvDuration = convertView.findViewById(R.id.tvSongDuration);
        TextView tvArtist = convertView.findViewById(R.id.tvArtistName);
        ImageView ivImage = convertView.findViewById(R.id.ivSongImage);

        tvName.setText(song.getName());
        tvDuration.setText(song.getDuration());
        tvArtist.setText(song.getArtistName()); // Thiết lập tên ca sĩ
        ivImage.setImageResource(song.getImageResourceId());

        return convertView;
    }
}
