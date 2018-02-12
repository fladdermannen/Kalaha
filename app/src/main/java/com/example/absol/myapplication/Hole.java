package com.example.absol.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.util.Log;



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
            case 21:
                this.setBackgroundResource(R.drawable.twentyone);
                break;
            case 22:
                this.setBackgroundResource(R.drawable.twentytwo);
                break;
            case 23:
                this.setBackgroundResource(R.drawable.twentythree);
                break;
            case 24:
                this.setBackgroundResource(R.drawable.twentyfour);
                break;
            case 25:
                this.setBackgroundResource(R.drawable.twentyfive);
                break;
            case 26:
                this.setBackgroundResource(R.drawable.twentysix);
                break;
            case 27:
                this.setBackgroundResource(R.drawable.twentyseven);
                break;
            case 28:
                this.setBackgroundResource(R.drawable.twentyeight);
                break;
            case 29:
                this.setBackgroundResource(R.drawable.twentynine);
                break;
            case 30:
                this.setBackgroundResource(R.drawable.thirty);
                break;
            case 31:
                this.setBackgroundResource(R.drawable.thirtyone);
                break;
            case 32:
                this.setBackgroundResource(R.drawable.thirtytwo);
                break;
            case 33:
                this.setBackgroundResource(R.drawable.thirtythree);
                break;
            case 34:
                this.setBackgroundResource(R.drawable.thirtyfour);
                break;
            case 35:
                this.setBackgroundResource(R.drawable.thirtyfive);
                break;
            case 36:
                this.setBackgroundResource(R.drawable.thirtysix);
                break;
            case 37:
                this.setBackgroundResource(R.drawable.thirtyseven);
                break;
            case 38:
                this.setBackgroundResource(R.drawable.thirtyeight);
                break;
            case 39:
                this.setBackgroundResource(R.drawable.thirtynine);
                break;
            case 40:
                this.setBackgroundResource(R.drawable.forty);
                break;
            case 41:
                this.setBackgroundResource(R.drawable.fortyone);
                break;
            case 42:
                this.setBackgroundResource(R.drawable.fortytwo);
                break;
            case 43:
                this.setBackgroundResource(R.drawable.fortythree);
                break;
            case 44:
                this.setBackgroundResource(R.drawable.fortyfour);
                break;
            case 45:
                this.setBackgroundResource(R.drawable.fortyfive);
                break;
            case 46:
                this.setBackgroundResource(R.drawable.fortysix);
                break;
            case 47:
                this.setBackgroundResource(R.drawable.fortyseven);
                break;
            case 48:
                this.setBackgroundResource(R.drawable.fortyeight);
                break;
            case 49:
                this.setBackgroundResource(R.drawable.fortynine);
                break;
            case 50:
                this.setBackgroundResource(R.drawable.fifty);
                break;
        }
    }
}

