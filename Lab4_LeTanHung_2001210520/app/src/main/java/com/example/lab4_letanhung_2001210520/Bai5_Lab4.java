package com.example.lab4_letanhung_2001210520;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai5_Lab4 extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private List<Song> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5_lab4);

        initSongList();

        ListView lvSongList = findViewById(R.id.lvSongList);
        SongAdapter adapter = new SongAdapter(this, songList);
        lvSongList.setAdapter(adapter);

        lvSongList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song selectedSong = songList.get(position);
                playSong(selectedSong.getResourceId());
            }
        });
    }

    private void initSongList() {
        songList = new ArrayList<>();
        songList.add(new Song("Thiên Lý ơi", "Jack", R.raw.thienlyoi, "3:40", R.drawable.avt1));
        songList.add(new Song("Nếu lúc đó", "tlinh, 2pillz", R.raw.neulucdo, "4:25", R.drawable.tlinh));
        songList.add(new Song("Ghé qua", "Dick, tofutns, PC", R.raw.ghequa, "3:57", R.drawable.ghequa));
        songList.add(new Song("Sống Cho Hết Đời Thanh Xuân", " Dick, Xám, TUYẾT", R.raw.schttx, "6:50", R.drawable.schttx));
        songList.add(new Song("See Tình", "Hoang Thuy Linh", R.raw.seetinh, "3:05", R.drawable.seetinh));
        songList.add(new Song("Ngoài 30", "Thái Học", R.raw.ngoai30, "3:40", R.drawable.ngoai30));
    }

    private void playSong(int resourceId) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, resourceId);
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }
}
