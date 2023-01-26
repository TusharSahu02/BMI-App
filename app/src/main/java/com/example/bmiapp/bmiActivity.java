package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiActivity extends AppCompatActivity {

    android.widget.Button mrecalculateBMI;
    TextView mbmiDisplay,mbmiCategory,mGender;
    Intent intent;
    ImageView mimageView;
    String mBmi,height,weight;
    float intBMI,intHeight,intWeight;
    RelativeLayout mbackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        mrecalculateBMI = findViewById(R.id.recalculateBMI);

        intent= getIntent();
        mbmiDisplay = findViewById(R.id.bmiDisplay);
        mbmiCategory =findViewById(R.id.bmiCategory);
        mGender = findViewById(R.id.genderDisplay);
        mbackground = findViewById(R.id.contentLayout);
        mimageView = findViewById(R.id.imageView);
        mrecalculateBMI = findViewById(R.id.recalculateBMI);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        intHeight = intHeight/100;
        intBMI = intWeight/(intHeight*intHeight);

        mBmi = Float.toString(intBMI);

        if(intBMI<16){
            mbmiCategory.setText("Severe Thiness");
            mbackground.setBackgroundColor(Color.RED);
            mimageView.setImageResource(R.drawable.crosss);
        }else if(intBMI < 16.9 && intBMI >16){
            mbmiCategory.setText("Moderate Thiness");
            mbackground.setBackgroundColor(Color.RED);
            mimageView.setImageResource(R.drawable.warning);
        }
        else if(intBMI <18.4 && intBMI>17){
            mbmiCategory.setText("Mild Thiness");
            mbackground.setBackgroundColor(Color.RED);
            mimageView.setImageResource(R.drawable.warning);
        }
        else if(intBMI < 25 && intBMI > 18.4){
            mbmiCategory.setText("Normal");
//            mbackground.setBackgroundColor(Color.YELLOW);
            mimageView.setImageResource(R.drawable.ok);
        } else if(intBMI < 29.9 && intBMI > 25){
            mbmiCategory.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageView.setImageResource(R.drawable.warning);
        }else{
            mbmiCategory.setText("Obese");
            mbackground.setBackgroundColor(Color.RED);
            mimageView.setImageResource(R.drawable.crosss);
        }
        mGender.setText(intent.getStringExtra("gender"));
        mbmiDisplay.setText(mBmi);
        mrecalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bmiActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}