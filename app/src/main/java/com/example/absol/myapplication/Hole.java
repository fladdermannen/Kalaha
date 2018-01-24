package com.example.absol.myapplication;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.Display;

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
        this.balls +=1;
    }

    public void clearBalls(){
        this.balls = 0;
    }
}
