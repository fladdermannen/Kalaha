package com.example.absol.myapplication;

import android.app.ActionBar;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        FlipImage yellowBtn = (FlipImage) findViewById(R.id.playBtn);
        yellowBtn.defaultImage = (R.drawable.playbig);
        yellowBtn.onDownImage = (R.drawable.playsmall);
        yellowBtn.activity = KalahaActivity.class;

        FlipImage yellowBtn2 = (FlipImage) findViewById(R.id.rulesBtn);
        yellowBtn2.defaultImage = (R.drawable.rulesbig);
        yellowBtn2.onDownImage = (R.drawable.rulessmall);
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












