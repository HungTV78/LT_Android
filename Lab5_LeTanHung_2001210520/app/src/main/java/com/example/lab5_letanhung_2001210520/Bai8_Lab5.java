package com.example.lab5_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class Bai8_Lab5 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SongAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8_lab5);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Song> songList = createSongList();
        songAdapter = new SongAdapter(songList);
        recyclerView.setAdapter(songAdapter);
    }

    private List<Song> createSongList() {
        List<Song> songList = new ArrayList<>();
        songList.add(new Song("I TOOK A PILL IN IBIZA", 2020, 5, R.drawable.japan));
        songList.add(new Song("7 YEARS", 2016, 3, R.drawable.india));
        songList.add(new Song("PILLOW TALK", 2016, 3, R.drawable.china));
        return songList;
    }
}