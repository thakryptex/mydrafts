package com.innopolis.tests.bootcamp.battleship;

import com.innopolis.tests.bootcamp.battleship.ships.FourCellShip;
import com.innopolis.tests.bootcamp.battleship.ships.OneCellShip;
import com.innopolis.tests.bootcamp.battleship.ships.ThreeCellShip;
import com.innopolis.tests.bootcamp.battleship.ships.TwoCellShip;

import java.util.ArrayList;

public class Ship {

    static int counterP1 = OneCellShip.counterP1 + TwoCellShip.counterP1 + ThreeCellShip.counterP1 + FourCellShip.counterP1;
    static int counterP2 = OneCellShip.counterP2 + TwoCellShip.counterP2 + ThreeCellShip.counterP2 + FourCellShip.counterP2;

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
