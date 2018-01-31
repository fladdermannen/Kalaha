package com.example.absol.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FlipImage yellowBtn = (FlipImage) findViewById(R.id.playBtn);
        yellowBtn.defaultImage = (R.drawable.yellowplay);
        yellowBtn.onDownImage = (R.drawable.yellowplaytwo);
        yellowBtn.activity = KalahaActivity.class;


        FlipImage yellowBtn2 = (FlipImage) findViewById(R.id.rulesBtn);
        yellowBtn2.defaultImage = (R.drawable.yellowrules);
        yellowBtn2.onDownImage = (R.drawable.yellowplaytworules);
        yellowBtn2.activity = RulesActivity.class;



    }




    /*
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();


        if (action == MotionEvent.ACTION_UP) {
            Intent myIntent= new Intent(MainActivity.this, KalahaActivity.class);
            startActivity(myIntent);


        }
        return true;
    }
*/
}












