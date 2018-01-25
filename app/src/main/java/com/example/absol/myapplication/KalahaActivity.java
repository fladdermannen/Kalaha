package com.example.absol.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class KalahaActivity extends AppCompatActivity {

    Player playerOne = new Player();
    Player playerTwo = new Player();
    Board board = new Board();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    public void test(View view) {
        //view.setBackgroundResource(R.drawable.hole);

        Log.d("TAG", "" +  ((Hole) view).getBalls());
        int balls = ((Hole) view).getBalls();
        Log.d("TAG Position", "" + board.getHoles().indexOf(view));
        int position = board.getHoles().indexOf(view);
        int secondLap = 0;
        int thirdLap = 0;
        ((Hole) view).clearBalls();

        if(balls == 0) {
            Log.d("TAG empty", "Hole is empty fuck off");
        }
        if(balls != 0) {
            for (int i = 0; i < balls; i++) {
                if (position < 13) {
                    board.getHoles().get(position + 1).addBall();
                    Log.d("TAG added", "Added ball at position " + (position+1));
                    position++;
                }else if (position >= 13 && position < 26) {
                    board.getHoles().get(secondLap).addBall();
                    Log.d("TAG Varv 2", "Added ball at position " + secondLap);
                    secondLap++;
                    position++;

                }else if (position >= 26){
                    board.getHoles().get(thirdLap).addBall();
                    Log.d("TAG Varv 3", "Added ball at position " + thirdLap);
                    thirdLap++;
                }

            }
        }


        playerOne.setScore(board.getHoles().get(6).getBalls());
        playerTwo.setScore(board.getHoles().get(13).getBalls());
        Log.d("TAG Scores", "Player 1 score is " + playerOne.getScore() +
                " and Player 2 score is " + playerTwo.getScore());

        board.updateAllBalls();
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
