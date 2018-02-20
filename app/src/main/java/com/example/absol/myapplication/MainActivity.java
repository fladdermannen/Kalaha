package com.example.absol.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.Locale;


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

        //Button one = (Button) this.findViewById(R.id.buttonSwe);
        //final MediaPlayer mp = MediaPlayer.create(this, R.raw.clicktwo);
        //one.setOnClickListener(new View.OnClickListener(){

           // public void onClick(View v) {
             //   mp.start();
            //}
        //});
    }

    public void sweSub(View v) {
        Locale myLocale = new Locale("sv");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        finish();
    }

    public void engSub(View v) {
        Locale myLocale = new Locale("en");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        finish();
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












