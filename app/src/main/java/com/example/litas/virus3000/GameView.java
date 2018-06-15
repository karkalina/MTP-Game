package com.example.litas.virus3000;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Color;
import android.os.CountDownTimer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by litas on 3/7/2018.
 */

public class GameView extends View {

    private static final Random RANDOM = new Random();
    Bitmap background, win, lose, lygu;
    Rect rect, rectdice;
    static int dWidth, dHeight, dice1Width, dice1Height;
    ArrayList<Dragon> dragons;
    StartGame startGame;
    Dice dice;

    int gameState, actionState;

    Handler handler;
    Runnable runnable;
    final long UPDATE_MILLIS = 30;

    public GameView(Context context) {
        super(context);
        background = BitmapFactory.decodeResource(getResources(), R.drawable.water);
        Display display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth = size.x;
        dHeight = size.y;
        rect = new Rect(0, 0, dWidth, dHeight);
        dragons = new ArrayList<>();
        for (int i = 0; i < 1; i++){
            Dragon dragon = new Dragon(context, 550);
            dragons.add(dragon);
        }
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };

        actionState = 0;
        gameState = 0;
        dice = new Dice(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (gameState==0) {
            this.drawGame(canvas);
        } else {
            this.drawTheEnd(canvas);
        }
        handler.postDelayed(runnable, UPDATE_MILLIS);
    }

    private void drawGame(Canvas canvas)
    {
        canvas.drawBitmap(background, null, rect, null);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(30);

        canvas.drawText(String.format("Zaidejas: %1$s",dice.getLivesYou()),20,canvas.getHeight()-100,textPaint);
        canvas.drawText(String.format("Drakonas: %1$s",dice.getLivesEnemy()),20,canvas.getHeight()-50,textPaint);

        canvas.drawBitmap(dice.getDice(0),canvas.getWidth()/2+55-50,canvas.getHeight()-120,null);
        canvas.drawBitmap(dice.getDice(1),canvas.getWidth()/2+55+50,canvas.getHeight()-120,null);

        for(int i = 0; i < dragons.size(); i++){
            canvas.drawBitmap(dragons.get(i).getBitmap(), dragons.get(i).dragonX, dragons.get(i).dragonY, null);
            dragons.get(i).dragonFrame++;
            if(dragons.get(i).dragonFrame > 10){
                dragons.get(i).dragonFrame = 0;
            }
            dragons.get(i).dragonX -= dragons.get(i).velocity;
            if(dragons.get(i).dragonX < -dragons.get(i).getWidth()){
                dragons.get(i).resetPosition();
            }
        }

        this.drawAction(canvas);
    }

    private void drawAction(Canvas canvas)
    {
        if (actionState!=0)
        {


        }

        actionState = 0;
    }

    private void drawTheEnd(Canvas canvas)
    {
        win = BitmapFactory.decodeResource(getResources(), R.drawable.win);
        lose = BitmapFactory.decodeResource(getResources(), R.drawable.over);
        lygu = BitmapFactory.decodeResource(getResources(), R.drawable.lygu);
        String text = "";
        if (gameState == 1) { //Drakonas miršta
            canvas.drawBitmap(win, null, rect, null);
            this.onTick(12);
        }
        if (gameState == 2) { //Žaidėjas miršta
            canvas.drawBitmap(lose, null, rect, null);
            this.onTick(12);
        }
        if (gameState == 3) { //Lygiosios
            canvas.drawBitmap(lygu, null, rect, null);
            this.onTick(12);
        }

        Paint textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(50);

        canvas.drawText(text,canvas.getWidth()/2-25,canvas.getHeight()/2,textPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (gameState==0)
            this.doMove();
        else;

        return super.onTouchEvent(event);
    }

    private void doMove()
    {
        new CountDownTimer(1500, 50) {
            public void onTick(long millisUntilFinished) {
                dice.doRoll();
            }
            public void onFinish() {
                actionState = dice.doAction();
                gameState   = dice.getGameState();
            }
        }.start();
    }

        public void onTick(long millisUntilFinished) {
            Intent intent = new Intent(getContext(),MainActivity.class);
            getContext().startActivity(intent); // then startactivity
        }

}
