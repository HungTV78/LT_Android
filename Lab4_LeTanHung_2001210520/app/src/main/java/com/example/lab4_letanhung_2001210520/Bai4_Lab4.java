package com.example.lab4_letanhung_2001210520;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.TimeUnit;

public class Bai4_Lab4 extends AppCompatActivity {

    private ImageButton forwardbtn, backwardbtn, pausebtn, playbtn;
    private MediaPlayer mPlayer;
    private TextView songName, startTime, songTime;
    private SeekBar songPrgs;
    private static int oTime = 0, sTime = 0, eTime = 0, fTime = 5000, bTime = 5000;
    private Handler hdlr = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4_lab4);

        backwardbtn = findViewById(R.id.btnBackward);
        forwardbtn = findViewById(R.id.btnForward);
        playbtn = findViewById(R.id.btnPlay);
        pausebtn = findViewById(R.id.btnPause);
        songName = findViewById(R.id.txtSname);
        startTime = findViewById(R.id.txtStartTime);
        songTime = findViewById(R.id.txtSongTime);
        songName.setText("Thiên lý ơi");

        mPlayer = MediaPlayer.create(this, R.raw.thienlyoi);
        songPrgs = findViewById(R.id.sBar);
        songPrgs.setClickable(false);
        pausebtn.setEnabled(false);

        playbtn.setOnClickListener(v -> {
            Toast.makeText(Bai4_Lab4.this, "Playing Audio", Toast.LENGTH_SHORT).show();
            mPlayer.start();
            eTime = mPlayer.getDuration();
            sTime = mPlayer.getCurrentPosition();
            if (oTime == 0) {
                songPrgs.setMax(eTime);
                oTime = 1;
            }
            songTime.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes(eTime),
                    TimeUnit.MILLISECONDS.toSeconds(eTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(eTime))));
            startTime.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes(sTime),
                    TimeUnit.MILLISECONDS.toSeconds(sTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(sTime))));
            songPrgs.setProgress(sTime);
            hdlr.postDelayed(UpdateSongTime, 100);
            pausebtn.setEnabled(true);
            playbtn.setEnabled(false);
        });

        pausebtn.setOnClickListener(v -> {
            mPlayer.pause();
            pausebtn.setEnabled(false);
            playbtn.setEnabled(true);
            Toast.makeText(getApplicationContext(), "Pausing Audio", Toast.LENGTH_SHORT).show();
        });

        forwardbtn.setOnClickListener(v -> {
            if ((sTime + fTime) <= eTime) {
                sTime = sTime + fTime;
                mPlayer.seekTo(sTime);
            } else {
                Toast.makeText(getApplicationContext(), "Không thể nhảy về phía trước 5 giây", Toast.LENGTH_SHORT).show();
            }
            if (!playbtn.isEnabled()) {
                playbtn.setEnabled(true);
            }
        });

        backwardbtn.setOnClickListener(v -> {
            if ((sTime - bTime) > 0) {
                sTime = sTime - bTime;
                mPlayer.seekTo(sTime);
            } else {
                Toast.makeText(getApplicationContext(), "Không thể nhảy lùi 5 giây", Toast.LENGTH_SHORT).show();
            }
            if (!playbtn.isEnabled()) {
                playbtn.setEnabled(true);
            }
        });
    }

    private final Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            sTime = mPlayer.getCurrentPosition();
            startTime.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes(sTime),
                    TimeUnit.MILLISECONDS.toSeconds(sTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(sTime))));
            songPrgs.setProgress(sTime);
            hdlr.postDelayed(this, 100);
        }
    };
}
