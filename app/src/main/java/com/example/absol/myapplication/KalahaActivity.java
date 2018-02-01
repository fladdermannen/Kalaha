package com.example.absol.myapplication;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class KalahaActivity extends AppCompatActivity {

    Player playerOne = new Player();
    Player playerTwo = new Player();
    Board board = new Board();
    int turn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_display_message);

        Hole playerOneHole1 = (Hole) findViewById(R.id.playerOneHole1);
        Hole playerOneHole2 = (Hole) findViewById(R.id.playerOneHole2);
        Hole playerOneHole3 = (Hole) findViewById(R.id.playerOneHole3);
        Hole playerOneHole4 = (Hole) findViewById(R.id.playerOneHole4);
        Hole playerOneHole5 = (Hole) findViewById(R.id.playerOneHole5);
        Hole playerOneHole6 = (Hole) findViewById(R.id.playerOneHole6);
        Hole playerOneNest = (Hole) findViewById(R.id.playerOneNest);
        Hole playerTwoHole1 = (Hole) findViewById(R.id.playerTwoHole1);
        Hole playerTwoHole2 = (Hole) findViewById(R.id.playerTwoHole2);
        Hole playerTwoHole3 = (Hole) findViewById(R.id.playerTwoHole3);
        Hole playerTwoHole4 = (Hole) findViewById(R.id.playerTwoHole4);
        Hole playerTwoHole5 = (Hole) findViewById(R.id.playerTwoHole5);
        Hole playerTwoHole6 = (Hole) findViewById(R.id.playerTwoHole6);
        Hole playerTwoNest = (Hole) findViewById(R.id.playerTwoNest);

        playerOneNest.clearBalls();
        playerTwoNest.clearBalls();
        board.setHoles(playerOneHole1);
        board.setHoles(playerOneHole2);
        board.setHoles(playerOneHole3);
        board.setHoles(playerOneHole4);
        board.setHoles(playerOneHole5);
        board.setHoles(playerOneHole6);
        board.setHoles(playerOneNest);
        board.setHoles(playerTwoHole1);
        board.setHoles(playerTwoHole2);
        board.setHoles(playerTwoHole3);
        board.setHoles(playerTwoHole4);
        board.setHoles(playerTwoHole5);
        board.setHoles(playerTwoHole6);
        board.setHoles(playerTwoNest);
    }


    void tmp(View view, int player)
    {
        if((turn % 2 == 0 && player == 1) || (turn % 2 != 0 && player == 2)) {
            int balls = ((Hole) view).getBalls();
            int position = board.getHoles().indexOf(view);
            if (balls == 0)
                return;

            ((Hole) view).clearBalls();
            turn += board.moveBalls(balls, position, player);

            playerOne.setScore(board.getHoles().get(6).getBalls());
            playerTwo.setScore(board.getHoles().get(13).getBalls());

            board.updateAllBalls();

            //Gameover funktion
        }
    }

    // PLAYER ETT
    public void test(View view) {
      tmp(view, 1);
    }

    // PLAYER TVÅ
    public void test2(View view) {
        tmp(view, 2);
    }

}



/* Intent myIntent = getIntent();
        String messageRetr = myIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView myTextView = (TextView) findViewById(R.id.displayText);
        myTextView.setText(messageRetr); */

//ImageButton thisBtn = (ImageButton) findViewById(view.getId());
//thisBtn.setBackgroundResource(R.drawable.hole);

//ImageButton test = (ImageButton) findViewById(R.id.playerTwoNest);
//test.setBackgroundResource(R.drawable.hole);
