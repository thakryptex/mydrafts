package com.innopolis.tests.bootcamp.battleship.ships;

import com.innopolis.tests.bootcamp.battleship.Player;
import com.innopolis.tests.bootcamp.battleship.Ship;

public class OneCellShip extends Ship {

    public static int counterP1;
    public static int counterP2;


    public OneCellShip(Player player) {
        super(player);
        this.decksLeft = 1;
    }

    public static int getDecksAmount() {
        return 1;
    }
}
