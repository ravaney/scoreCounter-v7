package com.example.lewis.scorecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView Team2,Team1;
    private ImageButton t1Score, t2Score;
    private int score1,score2 = 0;
    String T1,T2;
    Boolean t = false;//to decide which team was selected

    public static final String EXTRA_NUM = "com.example.lewis.scorecounter.EXTRA_NUM";
    public static final String EXTRA_NUM2 = "com.example.lewis.scorecounter.EXTRA_NUM2";
    public static final String EXTRA_TEXT = "com.example.lewis.scorecounter.EXTRA_TEXT";
    public static final String EXTRA_TEXT2 = "com.example.lewis.scorecounter.EXTRA_TEXT2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Team1 = (TextView) findViewById(R.id.Team1);
        Team2 = (TextView) findViewById(R.id.Team2);
        t1Score = (ImageButton) findViewById(R.id.t1Score);
        t2Score = (ImageButton) findViewById(R.id.t2Score);




        Intent intent = getIntent();

        final String t1 = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        String t2 = intent.getStringExtra(MainActivity.EXTRA_TEXT2);
        T1=t1;
        T2=t2;

        TextView Team1 = (TextView)findViewById(R.id.Team1);
        TextView Team2 = (TextView)findViewById(R.id.Team2);

        Team1.setText(t1);
        Team2.setText(t2);

        t2Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++score2;
                t=true;
                update();
            }
        });

        t1Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++score1;
                t=false;
                update();
            }
        });

    }

    public void update(){
        if(t==false){
            Team1.setText(T1+" "+score1);
            if(score1>=6){
                openActivity3();
            }
        }
        else {
            Team2.setText(T2+" "+score2);
            if(score2>=6){
                openActivity3();
            }
        }
    }

    private void openActivity3() {

        EditText team1 = (EditText) findViewById(R.id.team1);
        EditText team2 = (EditText) findViewById(R.id.team2);
       



        Intent intent = new Intent(this,Activity3.class);
    }


}
