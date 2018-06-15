package com.example.litas.virus3000;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Dice {

    private static final Random random = new Random();
    Bitmap[][] dice;
    int[] diceState;


    int livesYou;
    int livesEnemy;

    private Bitmap[] setDice(Context context, int type, int size)
    {
        Bitmap[] dice;

         if (type == 1) {
             dice = new Bitmap[4];
             dice[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_extra_1), size, size, false);
             dice[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_extra_2), size, size, false);
             dice[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_extra_3), size, size, false);
             dice[3] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_extra_4), size, size, false);
        } else {
             dice = new Bitmap[6];
             dice[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_1), size, size, false);
             dice[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_2), size, size, false);
             dice[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_3), size, size, false);
             dice[3] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_4), size, size, false);
             dice[4] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_5), size, size, false);
             dice[5] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.dice_6), size, size, false);
         }

        return dice;
    }

    public int getLivesYou()
    {
        return livesYou;
    }

    public int getLivesEnemy()
    {
        return livesEnemy;
    }

    public Bitmap getDice(int idx)
    {
        return dice[idx][diceState[idx]];
    }

    public void rollDice(int idx)
    {
        int size = dice[idx].length;
        diceState[idx] = random.nextInt(size);
    }

    public void doRoll()
    {
        this.rollDice(0);
        this.rollDice(1);
    }

    public int doAction()
    {
        int action = 0;

        int eyes = diceState[0]+1;

        switch (diceState[1]) {
            case 0:
                if (eyes % 2 == 0) {
                    action = 1;
                    livesYou -= eyes;
                } else {
                    action = 2;
                    livesEnemy -= eyes;
                }
                break;
            case 1:
                if (eyes % 2 == 0) {
                    action = 1;
                    livesYou -= eyes*2;
                } else {
                    action = 2;
                    livesEnemy -= eyes*2;
                }
            case 2:
            case 3:
                action = 3;
                livesYou   -= eyes;
                livesEnemy -= eyes;
                break;
        }

        if (livesYou<0)   livesYou=0;
        if (livesEnemy<0) livesEnemy=0;

        return action;
    }

    public int getGameState()
    {
        if (livesYou!=0 && livesEnemy==0) return 1; // Monstras negyvas
        if (livesYou==0 && livesEnemy!=0) return 2; // Zaidejas negyvas
        if (livesYou==0 && livesEnemy==0) return 3; // Lygiosios

        return 0; // Zaidimas tesiasi
    }

    public Dice(Context context) {

        diceState = new int[10];
        diceState[0] = 1;
        diceState[1] = 2;

        dice = new Bitmap[10][];

        dice[0] = this.setDice(context,0,90);
        dice[1] = this.setDice(context,1,90);

        livesYou = 30;
        livesEnemy = 30;
    }
}
