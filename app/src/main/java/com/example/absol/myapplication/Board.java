package com.example.absol.myapplication;

import android.util.Log;

import java.util.ArrayList;

public class Board {

    private ArrayList<Hole> holes = new ArrayList<>();

    public Board() {

    }

    public void setHoles(Hole hole) {
        this.holes.add(hole);
    }

    public ArrayList<Hole> getHoles() {
        return holes;
    }

    public void getAllBalls() {
        for (Hole hole : holes) {
            Log.d("TAG all balls", "" + hole.getBalls());
        }
    }

    public void updateAllBalls() {
        for (Hole hole : holes) {
            hole.updateImage();
        }
    }

    public void moveBalls(int balls, int position) {
        int secondLap = 0;
        int thirdLap = 0;

        if(balls == 0) {
            Log.d("TAG empty", "Hole is empty fuck off");
        }
        if(balls != 0) {
            for (int i = 0; i < balls; i++) {
                if (position < 13) {
                    this.getHoles().get(position + 1).addBall();
                    Log.d("TAG added", "Added ball at position " + (position+1));
                    position++;
                }else if (position >= 13 && position < 26) {
                    this.getHoles().get(secondLap).addBall();
                    Log.d("TAG Varv 2", "Added ball at position " + secondLap);
                    secondLap++;
                    position++;

                }else if (position >= 26){
                    this.getHoles().get(thirdLap).addBall();
                    Log.d("TAG Varv 3", "Added ball at position " + thirdLap);
                    thirdLap++;
                }

            }
        }
    }
}
