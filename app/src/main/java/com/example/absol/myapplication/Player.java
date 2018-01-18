package com.example.absol.myapplication;

import java.util.ArrayList;

/**
 * Created by absol on 2018-01-18.
 */

public class Player {
    private ArrayList<Hole> holes = new ArrayList<>();

    public Player() {
        for(int i = 0; i < 7; i++) {
            this.holes.add(new Hole());
        }
    }
}
