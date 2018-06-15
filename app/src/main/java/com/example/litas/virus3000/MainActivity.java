package com.example.litas.virus3000;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        MediaPlayer tone2 = MediaPlayer.create(MainActivity.this,R.raw.tone2);
        tone2.start();
    }

    public void startGame(View view) {
        Log.i("ImageButton", "Clicked");
        Intent intent = new Intent(this, StartGame.class);
        startActivity(intent);
        finish();
    }

    public void history(View view){
        Log.i("ImageButton", "Clicked");
        Intent historyActivity = new Intent(this, History.class);
        startActivity(historyActivity);
        //finish();
    }

    public void quit(View view){
        Log.i("ImageButton", "Clicked");
        ImageButton imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton10.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });
    }
}
