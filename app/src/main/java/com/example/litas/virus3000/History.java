package com.example.litas.virus3000;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.tomer.fadingtextview.FadingTextView;

public class History extends AppCompatActivity {

    FadingTextView fadingTextView, fadingTextView1;
    ImageButton imageButton;
    boolean clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_history);

        //MediaPlayer tone = MediaPlayer.create(History.this, R.raw.tone2);
        //tone.start();




        fadingTextView = (FadingTextView) findViewById(R.id.fadingTextView);
        fadingTextView.setTimeout(FadingTextView.SECONDS, 2);
    }

    public void mainactivity(View view){
        Log.i("ImageButton", "Clicked");
        Intent mainactivity = new Intent(this, MainActivity.class);
        startActivity(mainactivity);

        //finish();
    }
}