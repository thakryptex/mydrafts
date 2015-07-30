package com.innopolis.tests.bootcamp.battleship;

import java.util.ArrayList;

public class Ship {

    protected int decksLeft;
    protected ArrayList<Cell> cells = new ArrayList<>();
    protected Player player;

    public Ship(Player player, int decksLeft) {
        this.player = player;
        this.decksLeft = decksLeft;
    }

    public void damagedBy(Player attacker) {
        if (decksLeft > 0) {
            decksLeft--;
            System.out.println("-> " + attacker + " ранил " + this);
        }
        else this.destroyedBy(attacker);
    }

    public void destroyedBy(Player attacker) {
        for (int i = 0; i < cells.size(); i++) {
            int x = cells.get(i).getX();
            int y = cells.get(i).getY();
            for (int j = y-1; j <= y+1; j++) {
                for (int k = x-1; k <= x+1; k++) {
                    player.getPlayerField().getCell(y, x).setState(Cell.CellState.SHOOTED);
                    attacker.getEnemyTemplate().getCell(y, x).setState(Cell.CellState.SHOOTED);
                }
            }
            for (int j = 0; j < cells.size(); j++) {
                player.getPlayerField().getCell(y, x).setState(Cell.CellState.DAMAGED);
                attacker.getEnemyTemplate().getCell(y, x).setState(Cell.CellState.DAMAGED);
            }
        }
        cells.clear();
        player.ships.remove(this);
        System.out.println("-> " + this.toString() + " уничтожен.");
    }

    @Override
    public String toString() {
        return "корабль игрока " + player;
    }
}
