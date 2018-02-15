package com.example.absol.myapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;



public class FlipImage extends AppCompatImageView{
    int onDownImage;
    int defaultImage;
    java.lang.Class activity;
    FlipImage playBtn;



    public FlipImage(Context context) {
        super(context);
    }

    public FlipImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlipImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getActionMasked();


        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.d("FlipButton", "down") ;


                final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.click);
                mp.start();

                setImageResource(onDownImage);


                Intent myIntent= new Intent(getContext(), activity);
                getContext().startActivity(myIntent);

                return true;

            case (MotionEvent.ACTION_UP):
                Log.d("FlipButton", "Up") ;
                setImageResource(defaultImage);

                break;
        }

        Log.d("FlipImage", "touch");


        return false;

    }




}
