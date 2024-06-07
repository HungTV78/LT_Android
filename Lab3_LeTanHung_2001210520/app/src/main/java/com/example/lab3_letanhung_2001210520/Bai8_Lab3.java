package com.example.lab3_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Bai8_Lab3 extends AppCompatActivity {

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
            7, 7, 6, 6, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 2
    };
    private Set<Integer> chosenCardIndices = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8_lab3);

        Button playButton = findViewById(R.id.btn_Play);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame();
            }
        });
    }

    private void playGame() {
        chosenCardIndices.clear(); // Reset để chọn mới

        int[] playerCardsIndices = {
                getRandomCardIndex(),
                getRandomCardIndex(),
                getRandomCardIndex()
        };

        int[] computerCardsIndices = {
                getRandomCardIndex(),
                getRandomCardIndex(),
                getRandomCardIndex()
        };

        // Set images for player's cards
        ((ImageView) findViewById(R.id.playerCard1)).setImageResource(cardImages[playerCardsIndices[0]]);
        ((ImageView) findViewById(R.id.playerCard2)).setImageResource(cardImages[playerCardsIndices[1]]);
        ((ImageView) findViewById(R.id.playerCard3)).setImageResource(cardImages[playerCardsIndices[2]]);

        // Set images for computer's cards
        ((ImageView) findViewById(R.id.computerCard1)).setImageResource(cardImages[computerCardsIndices[0]]);
        ((ImageView) findViewById(R.id.computerCard2)).setImageResource(cardImages[computerCardsIndices[1]]);
        ((ImageView) findViewById(R.id.computerCard3)).setImageResource(cardImages[computerCardsIndices[2]]);

        // Calculate scores
        int playerScore = calculateScore(playerCardsIndices);
        int computerScore = calculateScore(computerCardsIndices);

        // Determine and display the result
        determineResult(playerScore, computerScore);
    }

    private int getRandomCardIndex() {
        Random random = new Random();
        int cardIndex;
        do {
            cardIndex = random.nextInt(cardImages.length); // Chọn ngẫu nhiên từ mảng
        } while (!chosenCardIndices.add(cardIndex));
        return cardIndex;
    }

    private int calculateScore(int[] cardIndices) {
        int score = 0;
        for (int cardIndex : cardIndices) {
            score += cardScores[cardIndex]; // Tính tổng điểm
        }
        return score % 10; // Trả về số dư của tổng điểm khi chia cho 10
    }

    private void determineResult(int playerScore, int computerScore) {
        String result;
        if (playerScore > computerScore) {
            result = "Bạn thắng!";
        } else if (playerScore < computerScore) {
            result = "Bạn thua!";
        } else {
            result = "Hòa!";
        }

        TextView resultText = findViewById(R.id.resultText);
        resultText.setText(result);
    }


}
