package com.innopolis.tests.bootcamp.battleship.ships;

import com.innopolis.tests.bootcamp.battleship.Player;
import com.innopolis.tests.bootcamp.battleship.Ships;

public class FourCellShip extends Ships {

    public static int counterP1;
    public static int counterP2;


    public FourCellShip(Player player, int decksLeft) {
        super(player, decksLeft);
        this.decksLeft = 4;
    }

    public static int getDecksAmount() {
        return 4;
    }
}
