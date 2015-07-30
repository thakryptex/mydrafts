package com.innopolis.tests.bootcamp.battleship;

import java.util.Random;

public class PlayerAI extends Player {

    private static Random random = new Random();

    public PlayerAI() {
        this.name = "Computer";
    }

    public Cell getEnemyCell(Player victim) {
        Cell cell;
        while (true) {
            int x = random.nextInt(10) + 1;
            int y = random.nextInt(10) + 1;
            cell = victim.getPlayerField().getCell(y, x);
            if (cell.getState().equals(Cell.CellState.SHOOTED) || cell.getState().equals(Cell.CellState.DAMAGED))
                continue;
            else break;
        }
        return cell;
    }

    @Override
    public String toString() {
        return name;
    }
}
