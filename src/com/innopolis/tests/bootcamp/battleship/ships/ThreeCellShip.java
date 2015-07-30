package com.innopolis.tests.bootcamp.battleship.ships;

import com.innopolis.tests.bootcamp.battleship.Player;
import com.innopolis.tests.bootcamp.battleship.Ship;

public class ThreeCellShip extends Ship {

    public static int counterP1;
    public static int counterP2;

    public ThreeCellShip(Player player) {
        super(player);
        this.decksLeft = 3;
    }

    public static int getDecksAmount() {
        return 3;
    }
}
