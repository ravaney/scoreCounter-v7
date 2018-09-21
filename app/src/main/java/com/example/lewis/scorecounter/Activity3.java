package com.example.lewis.scorecounter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

   private TextView winner;
    private int t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        //the third activity keeps crashing whenever one team has reached 5
     //   winner = (TextView) findViewById(R.id.winner);

        Intent intent = getIntent();

        //winner = (TextView) findViewById(R.id.winner);

        final String winner = intent.getStringExtra(Activity2.EXTRA_TEXT);
        final String team2 = intent.getStringExtra(Activity2.EXTRA_TEXT2);
        final String sc1 = intent.getStringExtra(Activity2.EXTRA_NUM);
        final String sc2 = intent.getStringExtra(Activity2.EXTRA_NUM);

        final int score1 = Integer.parseInt(sc1);
        final int score2 = Integer.parseInt(sc2);





    }
}
