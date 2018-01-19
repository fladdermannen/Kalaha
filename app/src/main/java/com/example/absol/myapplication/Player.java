package com.example.absol.myapplication;

import java.util.ArrayList;

/**
 * Created by absol on 2018-01-18.
 */

public class Player {
    private ArrayList<Hole> holes = new ArrayList<>();
    private int score;

    public Player() {
        for(int i = 0; i < 6; i++) {
            this.holes.add(new Hole());
        }
    }

    public int getScore() {
        return score;
    }
}
