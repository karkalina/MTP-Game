package com.example.litas.virus3000;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Dragon {

    Bitmap dragon[] = new Bitmap[11];
    int dragonX, dragonY, velocity, dragonFrame;
    Random random;
    public Dragon(Context context, int size) {

        dragon[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon1), size, size, false);
        dragon[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon2), size, size, false);
        dragon[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon3), size, size, false);
        dragon[3] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon4), size, size, false);
        dragon[4] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon5), size, size, false);
        dragon[5] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon6), size, size, false);
        dragon[6] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon7), size, size, false);
        dragon[7] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon8), size, size, false);
        dragon[8] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon9), size, size, false);
        dragon[9] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon10), size, size, false);
        dragon[10] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon11), size, size, false);


        //dragon[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon2);
        //dragon[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon3);
        //dragon[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon4);
        //dragon[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon5);
        //dragon[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon6);
        //dragon[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon7);
       // dragon[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon8);
        //dragon[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon9);
        //dragon[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon10);
       // dragon[10] = BitmapFactory.decodeResource(context.getResources(), R.drawable.dragon11);
        random = new Random();
        resetPosition();
    }

    public Bitmap getBitmap() {
        return dragon[dragonFrame];
    }

    public  int getWidth(){
        return  dragon[0].getWidth();
    }

    public int getHeight(){
        return dragon[0].getHeight();
    }
    public void resetPosition(){
        dragonX = random.nextInt(20);//GameView.dWidth; random.nextInt(20);
        dragonY = random.nextInt(20);
        //velocity = 1 + random.nextInt(1);
        //dragonFrame = 0;
    }
}
