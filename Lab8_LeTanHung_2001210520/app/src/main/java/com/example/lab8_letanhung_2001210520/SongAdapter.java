package com.example.lab8_letanhung_2001210520;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    private List<Song> songList;
    private Context context;

    public SongAdapter(Context context, List<Song> songList) {
        this.context = context;
        this.songList = songList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.imageViewSong.setImageResource(song.getImageResource());
        holder.textViewSongName.setText(song.getName());
        holder.textViewSinger.setText(song.getSinger());
        holder.textViewYear.setText(String.valueOf(song.getYear()));
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewSong;
        TextView textViewSongName;
        TextView textViewSinger;
        TextView textViewYear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewSong = itemView.findViewById(R.id.imageViewSong);
            textViewSongName = itemView.findViewById(R.id.textViewSongName);
            textViewSinger = itemView.findViewById(R.id.textViewSinger);
            textViewYear = itemView.findViewById(R.id.textViewYear);
        }
    }
}
