package com.innopolis.tests.bootcamp.battleship.ships;

import com.innopolis.tests.bootcamp.battleship.Player;
import com.innopolis.tests.bootcamp.battleship.Ships;

public class ThreeCellShip extends Ships {

    public static int counterP1;
    public static int counterP2;

    public ThreeCellShip(Player player, int decksLeft) {
        super(player, decksLeft);
        this.decksLeft = 3;
    }

    public static int getDecksAmount() {
        return 3;
    }
}
