package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class score_activity extends AppCompatActivity implements View.OnClickListener{
    Intent gi;
    int red_score_num = 0;
    int blue_score_num = 0;
    Button go_back;
    TextView wins;
    TextView red_score;
    TextView blue_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        wins = findViewById(R.id.wins);
        go_back = findViewById(R.id.go_back);
        red_score = findViewById(R.id.red_score);
        blue_score = findViewById(R.id.blue_score);
        gi = getIntent();
        go_back.setOnClickListener(this);
        red_score_num = gi.getIntExtra("red_score",0);
        blue_score_num = gi.getIntExtra("blue_score",0);
        red_score.setText(""+red_score_num);
        blue_score.setText(""+blue_score_num);
        if(red_score_num > blue_score_num)
        {
            wins.setText("Red wins");
        } else if (blue_score_num > red_score_num) {
            wins.setText("Blue wins");
        }
        else {
            wins.setText("Draw");
        }
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}