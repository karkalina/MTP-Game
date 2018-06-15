package com.example.litas.virus3000;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Dice1 {

    Bitmap dice1[] = new Bitmap[6];
    int diceX, diceY, velocity, diceFrame;
    Random random;

    public Dice1(Context context) {

        dice1[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_1),50,50,false);
        dice1[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_2),50,50,false);
        dice1[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_3),50,50,false);
        dice1[3] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_4),50,50,false);
        dice1[4] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_5),50,50,false);
        dice1[5] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_6),50,50,false);
        random = new Random();
        resetPosition();
    }

    public Bitmap getBitmap() {
        return dice1[diceFrame];
    }

    public  int getWidth(){
        return  dice1[0].getWidth();
    }

    public int getHeight(){
        return dice1[0].getHeight();
    }
    public void resetPosition(){
        diceX = random.nextInt(20);//GameView.dWidth; random.nextInt(20);
        diceY = random.nextInt(20);
        //velocity = 1 + random.nextInt(1);
        //dragonFrame = 0;
    }
}
