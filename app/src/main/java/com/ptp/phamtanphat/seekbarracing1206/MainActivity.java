package com.ptp.phamtanphat.seekbarracing1206;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

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
        setOnCheckbox();
        eventClick();

    }

    private void setOnCheckbox() {
        ckOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ckTwo.setChecked(false);
                    ckThree.setChecked(false);
                }
            }
        });
        ckTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ckOne.setChecked(false);
                    ckThree.setChecked(false);
                }
            }
        });
        ckThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ckOne.setChecked(false);
                    ckTwo.setChecked(false);
                }
            }
        });
    }

    private void eventClick() {

        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ckOne.isChecked() || ckTwo.isChecked() || ckThree.isChecked()) {
                    imgPlay.setEnabled(false);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int randomOne = random.nextInt(10) + 1;
                            int randomTwo = random.nextInt(10) + 1;
                            int randomThree = random.nextInt(10) + 1;

                            skOne.setProgress(skOne.getProgress() + randomOne);
                            skTwo.setProgress(skTwo.getProgress() + randomTwo);
                            skThree.setProgress(skThree.getProgress() + randomThree);

                            if (skOne.getProgress() >= 100) {
                                Toast.makeText(MainActivity.this, "One Chien Thang", Toast.LENGTH_SHORT).show();
                                handler.removeCallbacks(this);
                                imgPlay.setEnabled(true);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                setCheckBox();
                                setSeekbar();
                            } else if (skTwo.getProgress() >= 100) {
                                Toast.makeText(MainActivity.this, "Two Chien Thang", Toast.LENGTH_SHORT).show();
                                handler.removeCallbacks(this);
                                imgPlay.setEnabled(true);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                setCheckBox();
                                setSeekbar();
                            } else if (skThree.getProgress() >= 100) {
                                Toast.makeText(MainActivity.this, "Three Chien Thang", Toast.LENGTH_SHORT).show();
                                handler.removeCallbacks(this);
                                imgPlay.setEnabled(true);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                setCheckBox();
                                setSeekbar();
                            } else {
                                handler.postDelayed(this, 500);
                            }
                        }
                    }, 500);
                } else {
                    Toast.makeText(MainActivity.this, "Bạn phải chọn 1 con vật", Toast.LENGTH_SHORT).show();
                }
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
    public void setCheckBox(){
        ckOne.setChecked(false);
        ckTwo.setChecked(false);
        ckThree.setChecked(false);
    }
    public void setSeekbar(){
        skOne.setProgress(0);
        skTwo.setProgress(0);
        skThree.setProgress(0);
    }
}
