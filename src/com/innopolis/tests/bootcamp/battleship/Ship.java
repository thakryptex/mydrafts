package com.innopolis.tests.bootcamp.battleship;

import java.util.ArrayList;

public class Ship {

    protected int decksLeft;
    protected ArrayList<Cell> cells = new ArrayList<>();
    protected Player player;

    public Ship(Player player) {
        this.player = player;
    }

    public void damaged() {
        if (decksLeft > 0)
        decksLeft--;
        else this.destroyed();
    }

    public void destroyed() {
        //TODO должен находить соседние клетки и изменять state, а затем удалить все cells, себя из Player и привестись к null.
//        cells.
        System.out.println(this.toString() + " уничтожен.");
    }

    @Override
    public String toString() {
        return "Корабль " + getClass() +
                "игрока " + player;
    }
}
