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

    public int moveBalls(int balls, int position, int player) {
        int secondLap = 0;
        int thirdLap = 0;
        int ballCounter = balls;
        int finalPosition = 1;

        if(balls == 0) {
            Log.d("TAG empty", "Hole is empty fuck off");
        }
        if(balls != 0) {
            for (int i = 0; i < balls; i++) {
                if (position < 13) {
                    if(player == 1 && position == 12) {
                        this.getHoles().get(position).skipHole(player, this);
                        position++;
                        secondLap++;
                        ballCounter--;
                        finalPosition = 0;
                    } else if (player == 2 && position == 5) {
                        this.getHoles().get(position).skipHole(player, this);
                        position++;
                        ballCounter--;
                        finalPosition = 7;
                    } else {
                        this.getHoles().get(position + 1).addBall();
                        Log.d("TAG added", "Added ball at position " + (position+1));
                        position++;
                        finalPosition = position;
                        ballCounter--;

                        if (player == 1 && position == 6 && ballCounter == 0)
                            return 0;
                        if (player == 2 && position == 13 && ballCounter == 0)
                            return 0;
                    }
                }else if (position >= 13 && secondLap <= 13) {
                    if (player == 1 && secondLap == 13) {
                        this.getHoles().get(secondLap).skipHole(player,this);
                        thirdLap++;
                        ballCounter--;
                        finalPosition = 0;
                    } else if (player == 2 && secondLap == 6) {
                        this.getHoles().get(secondLap).skipHole(player, this);
                        secondLap+=2;
                        ballCounter--;
                        finalPosition = 7;
                    } else {
                        this.getHoles().get(secondLap).addBall();
                        ballCounter--;
                        Log.d("TAG Varv 2", "Added ball at position " + secondLap);
                        if (player == 1 && secondLap == 6 && ballCounter == 0)
                            return 0;
                        if (player == 2 && secondLap == 13 && ballCounter == 0)
                            return 0;
                        finalPosition = secondLap;
                        secondLap++;

                    }
                }else if (secondLap > 13){
                    this.getHoles().get(thirdLap).addBall();
                    Log.d("TAG Varv 3", "Added ball at position " + thirdLap);
                    if(player == 1 && thirdLap == 5 && ballCounter == 1)
                        return 0;
                    if(player == 2 && thirdLap == 12 && ballCounter == 1)
                        return 0;
                    finalPosition = thirdLap;
                    thirdLap++;
                    ballCounter--;
                }
            }
        }

        ruleTakeBalls(finalPosition, player);
        Log.d("TAG", "Final position is " + finalPosition + "position is " + position + " secondlap is " + secondLap);
        return 1;
    }

    private boolean ruleGoAgain (int finalPosition, int player) {

        if(player == 1 && finalPosition ==  6)
            return true;

        if(player == 2 && finalPosition == 13)
            return true;

        return false;
    }


    private void ruleTakeBalls(int finalPosition, int player) {
        int checkFinalPosition = this.getHoles().get(finalPosition).getBalls();
        int oppositeSideHole = 0;

        if(finalPosition == 6 || finalPosition == 13 || checkFinalPosition != 1)
            return;

        if (player == 1) {
            switch (finalPosition) {
                case 0:
                    oppositeSideHole = 12;
                    break;
                case 1:
                    oppositeSideHole = 11;
                    break;
                case 2:
                    oppositeSideHole = 10;
                    break;
                case 3:
                    oppositeSideHole = 9;
                    break;
                case 4:
                    oppositeSideHole = 8;
                    break;
                case 5:
                    oppositeSideHole = 7;
                    break;
                default:
                    return;
            }
        } else if (player == 2) {
            switch (finalPosition) {
                case 7:
                    oppositeSideHole = 5;
                    break;
                case 8:
                    oppositeSideHole = 4;
                    break;
                case 9:
                    oppositeSideHole = 3;
                    break;
                case 10:
                    oppositeSideHole = 2;
                    break;
                case 11:
                    oppositeSideHole = 1;
                    break;
                case 12:
                    oppositeSideHole = 0;
                    break;
                default:
                    return;
            }
        }

        int takeBallsAmount = this.getHoles().get(oppositeSideHole).getBalls();
        this.getHoles().get(oppositeSideHole).clearBalls();
        this.getHoles().get(finalPosition).addBalls(takeBallsAmount);

        Log.d("TAG", "Took balls from " + oppositeSideHole + " to " + finalPosition);
    }
}
