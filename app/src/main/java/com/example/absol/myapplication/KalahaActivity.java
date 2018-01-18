package com.example.absol.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class KalahaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent myIntent = getIntent();
        String messageRetr = myIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView myTextView = (TextView) findViewById(R.id.displayText);
        myTextView.setText(messageRetr);

    }

    public void test(View view) {
        TextView test = (TextView) findViewById(R.id.displayText);
        test.setText("Hej David");
    }




}
