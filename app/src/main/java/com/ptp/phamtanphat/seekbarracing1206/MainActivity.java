package com.ptp.phamtanphat.seekbarracing1206;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CheckBox ckOne, ckTwo, ckThree;
    SeekBar skOne, skTwo, skThree;
    ImageView imgPlay;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();
        eventClick();
    }

    private void eventClick() {
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(60000, 500) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        int randomOne = random.nextInt(10) + 1;
                        int randomTwo = random.nextInt(10) + 1;
                        int randomThree = random.nextInt(10) + 1;

                        skOne.setProgress(skOne.getProgress() + randomOne);
                        skTwo.setProgress(skTwo.getProgress() + randomTwo);
                        skThree.setProgress(skThree.getProgress() + randomThree);
                    }

                    @Override
                    public void onFinish() {

                    }
                };
                countDownTimer.start();

            }
        });
    }

    private void anhxa() {
        ckOne = findViewById(R.id.checkboxOne);
        ckTwo = findViewById(R.id.checkboxTwo);
        ckThree = findViewById(R.id.checkboxThree);
        skOne = findViewById(R.id.seekbarOne);
        skTwo = findViewById(R.id.seekbarTwo);
        skThree = findViewById(R.id.seekbarThree);
        imgPlay = findViewById(R.id.imageviewPlay);
    }
}
