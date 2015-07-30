package com.innopolis.tests.bootcamp.battleship.ships;

import com.innopolis.tests.bootcamp.battleship.Player;
import com.innopolis.tests.bootcamp.battleship.Ships;

public class OneCellShip extends Ships {

    public static int counterP1;
    public static int counterP2;


    public OneCellShip(Player player, int decksLeft) {
        super(player, decksLeft);
        this.decksLeft = 1;
    }

    public static int getDecksAmount() {
        return 1;
    }
}
