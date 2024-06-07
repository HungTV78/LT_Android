package com.example.lab5_letanhung_2001210520;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private List<Song> songList;

    public SongAdapter(List<Song> songList) {
        this.songList = songList;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout_bai8, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.textViewSongName.setText(song.getName());
        holder.textViewYear.setText("Year: " + song.getYear());
        holder.textViewRank.setText("Rank: " + song.getRank());
        holder.imageViewSong.setImageResource(song.getImageResource());
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewSong;
        public TextView textViewSongName, textViewYear, textViewRank;

        public SongViewHolder(View itemView) {
            super(itemView);
            imageViewSong = itemView.findViewById(R.id.imageViewSong);
            textViewSongName = itemView.findViewById(R.id.textViewSongName);
            textViewYear = itemView.findViewById(R.id.textViewYear);
            textViewRank = itemView.findViewById(R.id.textViewRank);
        }
    }
}
