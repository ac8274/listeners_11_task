package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener
{
    Button short_press;
    Button long_press;
    Button match_results;
    int short_score = 0;
    int long_score = 0;
    long then;
    int longClickDuration = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        short_press = findViewById(R.id.short_press);
        long_press = findViewById(R.id.long_press);
        match_results = findViewById(R.id.reasults);
        short_press.setOnClickListener(this);
        long_press.setOnLongClickListener(this);
        match_results.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.short_press) {
            short_score = short_score+1;
        }
        else
        {
            Intent si = new Intent(this,score_activity.class);
            si.putExtra("red_score",long_score);
            si.putExtra("blue_score",short_score);
            startActivity(si);
            System.out.println("hello");
            long_score = 0;
            short_score = 0;
        }
    }

    @Override
    public boolean onLongClick(View view) {
        long_score +=2;
        return false;
    }
}