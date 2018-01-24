package com.example.absol.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //public static final String EXTRA_MESSAGE = "com.example.blabla.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printMessage(View view) {
        //EditText blabla = (EditText) findViewById(R.id.editText);
        //TextView myTextView = (TextView) findViewById(R.id.textView);
        //myTextView.setText(blabla.getText());
        //myTextView.setTextSize(100);
        Intent myIntent = new Intent(this, KalahaActivity.class);
        startActivity(myIntent);
    }

    public void showRules(View view) {
        Intent myIntent = new Intent(this, RulesActivity.class);
        startActivity(myIntent);
    }
}
