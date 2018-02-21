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
import com.example.absol.myapplication.LocaleHelper;


public class MainActivity extends AppCompatActivity {

    FlipImage yellowBtn;
    FlipImage yellowBtn2;

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

        yellowBtn = (FlipImage) findViewById(R.id.playBtn);
        yellowBtn2 = (FlipImage) findViewById(R.id.rulesBtn);

        String lang = Locale.getDefault().getLanguage();
        System.out.println("lang is " + lang);

        if(lang.equals("sv")){
            yellowBtn.setImageResource(R.drawable.spelastor);
            yellowBtn2.setImageResource(R.drawable.reglerstor);

            yellowBtn.defaultImage = (R.drawable.spelastor);
            yellowBtn.onDownImage = (R.drawable.spelaliten);

            yellowBtn2.defaultImage = (R.drawable.reglerstor);
            yellowBtn2.onDownImage = (R.drawable.reglerliten);

            yellowBtn.activity = KalahaActivity.class;
            yellowBtn2.activity = RulesActivity.class;
        } else {

            yellowBtn.defaultImage = (R.drawable.playbig);
            yellowBtn.onDownImage = (R.drawable.playsmall);
            yellowBtn.activity = KalahaActivity.class;

            yellowBtn2.defaultImage = (R.drawable.rulesbig);
            yellowBtn2.onDownImage = (R.drawable.rulessmall);
            yellowBtn2.activity = RulesActivity.class;

        }

    }

    public void sweSub(View v) {
        Locale myLocale = new Locale("sv");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        String lang = "sv";
        LocaleHelper.setLocale(MainActivity.this, lang);
        recreate();
    }

    public void engSub(View v) {
        Locale myLocale = new Locale("en");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        String lang = "en";
        LocaleHelper.setLocale(MainActivity.this, lang);
        recreate();
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












