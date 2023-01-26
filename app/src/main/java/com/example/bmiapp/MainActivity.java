package com.example.bmiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    android.widget.Button mcalculateBMI;
    TextView mcurrentHeight, mcurrentAge, mcurrentWeight;
    ImageView mincrementAge, mincrementWeight, mdecrementWeight, mdecrementAge;
    SeekBar mseekbarforHeight;
    RelativeLayout mMale, mFemale;

    int intWeight = 55;
    int intAge = 22;
    int currentProgress;
    String mintProgress = "170";
    String typeOfuser = "0";
    String weight2 = "55";
    String age2 = "22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mcalculateBMI = findViewById(R.id.calculateBMI);
        mcurrentAge = findViewById(R.id.currentAge);
        mcurrentWeight = findViewById(R.id.currentWeight);
        mcurrentHeight = findViewById(R.id.currentHeight);
        mincrementAge = findViewById(R.id.incrementAge);
        mincrementWeight = findViewById(R.id.incrementWeight);
        mdecrementAge = findViewById(R.id.decrementAge);
        mdecrementWeight = findViewById(R.id.decrementWeight);
        mseekbarforHeight = findViewById(R.id.seekBarHeight);
        mMale = findViewById(R.id.male);
        mFemale = findViewById(R.id.female);


        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.maledemalefocus));
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeOfuser = "Male";
            }
        });
        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.maledemalefocus));
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeOfuser = "Female";
            }
        });

        mseekbarforHeight.setMax(300);
        mseekbarforHeight.setProgress(170);
        mseekbarforHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress;
                mintProgress = String.valueOf(currentProgress);
                mcurrentHeight.setText(mintProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mincrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge++;
                age2 = String.valueOf(intAge);
                mcurrentAge.setText(age2);
            }
        });
        mdecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge--;
                age2 = String.valueOf(intAge);
                mcurrentAge.setText(age2);
            }
        });
        mincrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight++;
                weight2 = String.valueOf(intWeight);
                mcurrentWeight.setText(weight2);
            }
        });
        mdecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight--;
                weight2 = String.valueOf(intWeight);
                mcurrentWeight.setText(weight2);
            }
        });

        mcalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeOfuser.equals("0")) {
                    Toast.makeText(MainActivity.this, "Select Your Gender First !!", Toast.LENGTH_SHORT).show();
                } else if (mintProgress.equals("0")) {
                    Toast.makeText(MainActivity.this, "Select Your Height First!!", Toast.LENGTH_SHORT).show();
                } else if (intAge == 0 || intAge < 0) {
                    Toast.makeText(MainActivity.this, "Age is Incorrect !!", Toast.LENGTH_SHORT).show();
                } else if (intWeight == 0 || intWeight < 0) {
                    Toast.makeText(MainActivity.this, "Weight is Incorrect !!!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, bmiActivity.class);

                    intent.putExtra("gender", typeOfuser);
                    intent.putExtra("height", mintProgress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);
                    startActivity(intent);
                }
            }
        });
    }
}