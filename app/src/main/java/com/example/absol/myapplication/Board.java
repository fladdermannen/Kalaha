package com.example.absol.myapplication;

import android.os.CountDownTimer;
import android.util.Log;

import java.util.ArrayList;

public class Board {

    private boolean lock = false;
    private boolean gameOverStatus = false;

    public void setLock() {
        this.lock = true;
    }
    public void unLock() {
        this.lock = false;
    }
    public boolean getLockStatus(){
        return this.lock;
    }
    public boolean getGameOverStatus() {
        return this.gameOverStatus;
    }

    private ArrayList<Hole> holes = new ArrayList<>();

    public Board() {

    }

    public void setHoles(Hole hole) {
        this.holes.add(hole);
    }

    public ArrayList<Hole> getHoles() {
        return holes;
    }

  //-----------DELAY FUNKTION
    private int i = 0;
    private int i2 = 0;
    private int i3 = 0;
    private int i4 = 0;
    private int finalPosition;

    public int updateMovedBalls(int balls, final int position, final int player) {
Log.d("tag" , ""+ balls + position + player);

            final Board board = this;

            int finalPositionAlpha = -1;
            if (position + balls == 6) {
                finalPositionAlpha = 6;
            } else if (position + balls == 13) {
                finalPositionAlpha = 13;
            } else if (position + balls + 1 == 20) {
                finalPositionAlpha = 6;
            } else if (position + balls + 1 == 27) {
                finalPositionAlpha = 13;
            } else if (position + balls + 2 == 34) {
                finalPositionAlpha = 6;
            } else if (position + balls + 2 == 41) {
                finalPositionAlpha = 13;
            }

        this.getHoles().get(position).clearBalls();
        this.getHoles().get(position).updateImage();

            new CountDownTimer((300 * (balls)), 300) {
                public void onTick(long millisUntilFinished) {
                    if (position + i < 13) {
                        if (player == 1 && position + i == 12) {
                            board.getHoles().get(position + i).skipHole(player, board);
                            board.getHoles().get(0).updateImage();
                            i++;
                            i2++;
                            finalPosition = 0;
                        } else if (player == 2 && position + i == 5) {
                            board.getHoles().get(position + i).skipHole(player, board);
                            board.getHoles().get(7).updateImage();
                            i++;
                            finalPosition = 7;
                        } else {
                            board.getHoles().get((position + i) + 1).addBall();
                            board.getHoles().get((position + i) + 1).updateImage();
                            Log.d("TAG added", "Added ball at position " + ((position + i) + 1));
                            i++;
                            finalPosition = position + i;

                        }
                    } else if (position + i >= 13 && i2 <= 13) {
                        if (player == 1 && i2 == 13) {
                            board.getHoles().get(i2).skipHole(player, board);
                            board.getHoles().get(0).updateImage();
                            i3++;
                            finalPosition = 0;
                        } else if (player == 2 && i2 == 6) {
                            board.getHoles().get(i2).skipHole(player, board);
                            board.getHoles().get(7).updateImage();
                            i2 += 2;
                            finalPosition = 7;
                        } else {
                            board.getHoles().get(i2).addBall();
                            board.getHoles().get(i2).updateImage();
                            Log.d("TAG Varv 2", "Added ball at position " + i2);
                            finalPosition = i2;
                            i2++;
                        }
                    } else if (i2 > 13) {
                        if (player == 1 && i3 == 13) {
                            board.getHoles().get(i3).skipHole(player, board);
                            board.getHoles().get(0).updateImage();
                            i4++;
                            finalPosition = 0;
                        } else if (player == 2 && i3 == 6) {
                            board.getHoles().get(i3).skipHole(player, board);
                            board.getHoles().get(7).updateImage();
                            i3 += 2;
                            finalPosition = 7;
                        } else {
                            board.getHoles().get(i3).addBall();
                            board.getHoles().get(i3).updateImage();
                            Log.d("TAG Varv 2", "Added ball at position " + i3);
                            finalPosition = i3;
                            i3++;
                        }
                    }else if (i3 > 13) {
                        if (player == 1 && i4 == 13) {
                            board.getHoles().get(i4).skipHole(player, board);
                            board.getHoles().get(0).updateImage();
                            finalPosition = 0;
                        } else if (player == 2 && i4 == 6) {
                            board.getHoles().get(i4).skipHole(player, board);
                            board.getHoles().get(7).updateImage();
                            i4 += 2;
                            finalPosition = 7;
                        } else {
                            board.getHoles().get(i4).addBall();
                            board.getHoles().get(i4).updateImage();
                            Log.d("TAG Varv 2", "Added ball at position " + i4);
                            finalPosition = i4;
                            i4++;
                        }
                    }
                }

                public void onFinish() {
                    Log.d("Tag", "Klart. Final position är " + finalPosition + " och player är " + player);
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    ruleTakeBalls(finalPosition, player);
                    updateAllBalls();
                    unLock();
                    if(gameOver(player)){
                        gameOverStatus = true;
                    }

                }
            }.start();

            if (ruleGoAgain(finalPositionAlpha, player))
                return 0;
            else
                return 1;
    }


    public void updateAllBalls() {
        for (Hole hole : holes) {
            hole.updateImage();
        }
    }


    private boolean ruleGoAgain(int finalPosition, int player) {
        if(player==1 && finalPosition==6)
            return true;
        else if(player==2 && finalPosition == 13)
            return true;
        else
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
        if(takeBallsAmount>0) {
            this.getHoles().get(oppositeSideHole).clearBalls();
            this.getHoles().get(finalPosition).clearBalls();
            if (player == 1)
                this.getHoles().get(6).addBalls(takeBallsAmount + 1);
            else if (player == 2)
                this.getHoles().get(13).addBalls(takeBallsAmount + 1);
        }
        //this.getHoles().get(finalPosition).addBalls(takeBallsAmount);

        Log.d("TAG", "Took balls from " + oppositeSideHole + " to " + finalPosition);
    }


    public boolean gameOver(int player) {

        int hole1 = this.getHoles().get(0).getBalls();
        int hole2 = this.getHoles().get(1).getBalls();
        int hole3 = this.getHoles().get(2).getBalls();
        int hole4 = this.getHoles().get(3).getBalls();
        int hole5 = this.getHoles().get(4).getBalls();
        int hole6 = this.getHoles().get(5).getBalls();
        int all1 = (hole1 + hole2 + hole3 + hole4 + hole5 + hole6);

        int hole7 = this.getHoles().get(7).getBalls();
        int hole8 = this.getHoles().get(8).getBalls();
        int hole9 = this.getHoles().get(9).getBalls();
        int hole10 = this.getHoles().get(10).getBalls();
        int hole11 = this.getHoles().get(11).getBalls();
        int hole12 = this.getHoles().get(12).getBalls();
        int all2 = (hole7 + hole8 + hole9 + hole10 + hole11 + hole12);

        if (all1 == 0 && player == 1) {
            this.getHoles().get(13).addBalls(all2);
            this.getHoles().get(7).clearBalls();
            this.getHoles().get(8).clearBalls();
            this.getHoles().get(9).clearBalls();
            this.getHoles().get(10).clearBalls();
            this.getHoles().get(11).clearBalls();
            this.getHoles().get(12).clearBalls();
            return true;
        } else if (all2 == 0 && player == 2) {
            this.getHoles().get(6).addBalls(all1);
            this.getHoles().get(0).clearBalls();
            this.getHoles().get(1).clearBalls();
            this.getHoles().get(2).clearBalls();
            this.getHoles().get(3).clearBalls();
            this.getHoles().get(4).clearBalls();
            this.getHoles().get(5).clearBalls();
            return true;
        }

        return false;
    }
}




    /*
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
    */