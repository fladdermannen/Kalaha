package com.example.absol.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by absol on 2018-01-18.
 */


public class Hole extends AppCompatImageButton {
    private int balls;



    public Hole(Context context) {
        super(context);
        this.balls = 6;
    }

    public Hole(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.balls = 6;
    }

    public Hole(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.balls = 6;
    }


    public int getBalls() {
        return balls;
    }

    public void addBall() {
        this.balls++;
    }

    public void addBalls(int amount) {

        this.balls += amount;
    }

    public void skipHole(int player, Board board) {
        if (player == 1) {
            board.getHoles().get(0).addBall();
            Log.d("TAG", "Added ball at position 0");
        }
        if (player == 2) {
            board.getHoles().get(7).addBall();
            Log.d("TAG", "Added ball at position 7");
        }
    }

    public void clearBalls() {
        this.balls = 0;
    }

    public void updateImage() {
        switch (this.balls) {
            case 0:
                this.setBackgroundResource(R.drawable.hole2);
                break;
            case 1:
                this.setBackgroundResource(R.drawable.one);
                break;
            case 2:
                this.setBackgroundResource(R.drawable.two);
                break;
            case 3:
                this.setBackgroundResource(R.drawable.three);
                break;
            case 4:
                this.setBackgroundResource(R.drawable.four);
                break;
            case 5:
                this.setBackgroundResource(R.drawable.five);
                break;
            case 6:
                this.setBackgroundResource(R.drawable.six);
                break;
            case 7:
                this.setBackgroundResource(R.drawable.seven);
                break;
            case 8:
                this.setBackgroundResource(R.drawable.eight);
                break;
            case 9:
                this.setBackgroundResource(R.drawable.nine);
                break;
            case 10:
                this.setBackgroundResource(R.drawable.ten);
                break;
            case 11:
                this.setBackgroundResource(R.drawable.eleven);
                break;
            case 12:
                this.setBackgroundResource(R.drawable.twelve);
                break;
            case 13:
                this.setBackgroundResource(R.drawable.thirteen);
                break;
            case 14:
                this.setBackgroundResource(R.drawable.fourteen);
                break;
            case 15:
                this.setBackgroundResource(R.drawable.fifteen);
                break;
            case 16:
                this.setBackgroundResource(R.drawable.sixteen);
                break;
            case 17:
                this.setBackgroundResource(R.drawable.seventeen);
                break;
            case 18:
                this.setBackgroundResource(R.drawable.eighteen);
                break;
            case 19:
                this.setBackgroundResource(R.drawable.nineteen);
                break;
            case 20:
                this.setBackgroundResource(R.drawable.twenty);
                break;
        }
    }
}

