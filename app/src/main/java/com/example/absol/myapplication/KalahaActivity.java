package com.example.absol.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class KalahaActivity extends AppCompatActivity {
Player playerOne = new Player();
Player playerTwo = new Player();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Åtkomst till alla knappar
        ImageButton playerOneHoleOne = (ImageButton) findViewById(R.id.playerOneHoleOne);
        ImageButton playerOneHoleTwo = (ImageButton) findViewById(R.id.playerOneHoleTwo);
        ImageButton playerOneHoleThree = (ImageButton) findViewById(R.id.playerOneHoleThree);
        ImageButton playerOneHoleFour = (ImageButton) findViewById(R.id.playerOneHoleFour);
        ImageButton playerOneHoleFive = (ImageButton) findViewById(R.id.playerOneHoleFive);
        ImageButton playerOneHoleSix = (ImageButton) findViewById(R.id.playerOneHoleSix);
        ImageButton playerTwiHoleOne = (ImageButton) findViewById(R.id.playerTwoHoleOne);
        ImageButton playerTwoHoleTwo = (ImageButton) findViewById(R.id.playerTwoHoleTwo);
        ImageButton playerTwoHoleThree = (ImageButton) findViewById(R.id.playerTwoHoleThree);
        ImageButton playerTwoHoleFour = (ImageButton) findViewById(R.id.playerTwoHoleFour);
        ImageButton playerTwoHoleFive = (ImageButton) findViewById(R.id.playerTwoHoleFive);
        ImageButton playerTwoHoleSix = (ImageButton) findViewById(R.id.playerTwoHoleSix);
        ImageButton playerOneNest = (ImageButton) findViewById(R.id.playerOneNest);
        ImageButton playerTwoNest = (ImageButton) findViewById(R.id.playerTwoNest);


    }

    public void test(View view) {
        ImageButton test = (ImageButton) findViewById(R.id.playerTwoNest);
        test.setBackgroundResource(R.drawable.hole);

    }




    //on click metod, switch sats med case för varje hål, metod som hämtar hålets antal bollar

}



/* Intent myIntent = getIntent();
        String messageRetr = myIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView myTextView = (TextView) findViewById(R.id.displayText);
        myTextView.setText(messageRetr); */