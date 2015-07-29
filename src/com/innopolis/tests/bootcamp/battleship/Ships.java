package com.innopolis.tests.bootcamp.battleship;

import java.util.ArrayList;

public abstract class Ships {

    int decksAmount;
    protected ArrayList<Cell> cells = new ArrayList<>();
    int counterP1;
    int counterP2; // не унаследуется

    public void damaged() {

    }

    public void destroyed() {

    }

}
