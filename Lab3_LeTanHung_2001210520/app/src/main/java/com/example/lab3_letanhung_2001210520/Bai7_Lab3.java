package com.example.lab3_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.Random;

public class Bai7_Lab3 extends AppCompatActivity {

    private ImageView card1, card2, card3;
    private Button btnDone;
    private int[] cardImages = {
            R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6,
            R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10, R.drawable.a11, R.drawable.a12,
            R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16, R.drawable.a17, R.drawable.a18,
            R.drawable.a19, R.drawable.a20, R.drawable.a21, R.drawable.a22, R.drawable.a23, R.drawable.a24,
            R.drawable.a25, R.drawable.a26, R.drawable.a27, R.drawable.a28, R.drawable.a29, R.drawable.a30,
            R.drawable.a31, R.drawable.a32, R.drawable.a33, R.drawable.a34, R.drawable.a35, R.drawable.a36,
            R.drawable.a37, R.drawable.a38, R.drawable.a39, R.drawable.a40, R.drawable.a41, R.drawable.a42,
            R.drawable.a43, R.drawable.a44, R.drawable.a45, R.drawable.a46, R.drawable.a47, R.drawable.a48,
            R.drawable.a49, R.drawable.a50, R.drawable.a51, R.drawable.a52
    };
    private int[] cardScores = {
            1, 1, 1, 1, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 8, 7, 7,
            7, 7, 6, 6, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 2, 2, 2, 2, 2, 2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7_lab3);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        btnDone = findViewById(R.id.btn_done);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRandomCards();
            }
        });
    }

    private void showRandomCards() {
        Random random = new Random();
        int cardIndex1 = random.nextInt(cardImages.length);
        int cardIndex2 = random.nextInt(cardImages.length);
        int cardIndex3 = random.nextInt(cardImages.length);

        card1.setImageResource(cardImages[cardIndex1]);
        card2.setImageResource(cardImages[cardIndex2]);
        card3.setImageResource(cardImages[cardIndex3]);

        int score = cardScores[cardIndex1] + cardScores[cardIndex2] + cardScores[cardIndex3];
        int sum = score % 10; // Lấy điểm dư của tổng điểm
        Toast.makeText(this, "Tổng số nút: " + sum, Toast.LENGTH_SHORT).show();
    }
}
