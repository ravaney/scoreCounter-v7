package com.example.lewis.scorecounter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView title,t1,t2;
    private EditText team1, team2;
    private Button start,selectimage1,selectimage2;
    private int PICK_IMAGE_REQUEST = 1;
    private ImageView img2,img1;
    public static final String EXTRA_TEXT = "com.example.lewis.scorecounter.EXTRA_TEXT";
    public static final String EXTRA_TEXT2 = "com.example.lewis.scorecounter.EXTRA_TEXT2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView)findViewById(R.id.showTitle);
        team1 = (EditText)findViewById(R.id.team1);
        team2 = (EditText)findViewById(R.id.team2);
        start = (Button)findViewById(R.id.Start);
        selectimage1 = (Button) findViewById(R.id.selectimage1);
        selectimage2 = (Button) findViewById(R.id.selectimage2);
        img1 = (ImageView) findViewById(R.id.img1) ;
        img2 = (ImageView) findViewById(R.id.img2) ;


        selectimage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagepicker();

            }
        });

        selectimage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagepicker();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.img1);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    protected void onActivityResult2(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST+1 && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.img2);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void openActivity2(){
        EditText team1 = (EditText) findViewById(R.id.team1);
        EditText team2 = (EditText) findViewById(R.id.team2);

        String Team1 = team1.getText().toString();
        String Team2 = team2.getText().toString();

        Intent intent = new Intent(this, Activity2.class);

        intent.putExtra(EXTRA_TEXT,Team1);
        intent.putExtra(EXTRA_TEXT2,Team2);


        startActivity(intent);
    }

    public void imagepicker(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"), PICK_IMAGE_REQUEST);
    }
}
