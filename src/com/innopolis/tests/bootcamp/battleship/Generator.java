package com.innopolis.tests.bootcamp.battleship;

import com.innopolis.tests.bootcamp.battleship.ships.FourCellShip;
import com.innopolis.tests.bootcamp.battleship.ships.OneCellShip;

import java.util.FormatFlagsConversionMismatchException;
import java.util.Random;

public class Generator {

    static Random random = new Random();
    static int x, y;
    static Cell.CellState state;

    public static void generateShips(Player p1, Player p2) {
        //TODO генерация кораблей через смену state of cells
        generatePlayerShips(p1);
//        p2.getPlayerField();
        //TODO проверка на количество кораблей
    }

    private static void generatePlayerShips(Player player) {
        Cell[][] cellsArray = player.getPlayerField().getCellsArray();
//        player.mapCounter.size();
//        String[] shipNames =  {"OneCellShip", "TwoCellShip", "ThreeCellShip", "FourCellShip"};
//        int[] shipCount =  {4, 3, 2, 1};
        while (true) { // while (player.getShips.size() < 10) {
            int x, y;
            while (FourCellShip.counterP1 < 1) { // (player.mapCounter.get(shipNames[4]) < shipCount[4]) {
                x = random.nextInt(10)+1;
                y = random.nextInt(10)+1;
                int t = random.nextInt(2);
                int dont = 0;

                if (t == 0 && x < 8) {

                    for (int i = y - 1; i <= y + 1; i++) {
                        if (dont == 666) break;
                        for (int j = x - 1; j <= x + 4; j++) {
                            if (cellsArray[i][j].getState().equals(Cell.CellState.SHIPPED))
                                dont = 666;
                        }
                    }
                    if (dont != 666) {
                        for (int i = y - 1; i <= y + 1; i++) {
                            for (int j = x - 1; j <= x + 4; j++) {
                                if (i == y && j >= x && j <= x + 3) {
                                    cellsArray[i][j].setState(Cell.CellState.SHIPPED);
                                } else {
                                    cellsArray[i][j].setState(Cell.CellState.OCCUPIED);
                                }
                                FourCellShip.counterP1++;
                            }
                        }
                    }

                } else if (t == 1 && y < 8) {

                    for (int i = y - 1; i <= y + 4; i++) {
                        if (dont == 666) break;
                        for (int j = x - 1; j <= x + 1; j++) {
                            if (cellsArray[i][j].getState().equals(Cell.CellState.SHIPPED)) {
                                dont = 666;
                            }
                        }
                    }
                    if (dont != 666) {
                        for (int i = y - 1; i <= y + 4; i++) {
                            for (int j = x - 1; j <= x + 1; j++) {
                                if (j == x && i >= y && i <= y + 3) {
                                    cellsArray[i][j].setState(Cell.CellState.SHIPPED);
                                } else {
                                    cellsArray[i][j].setState(Cell.CellState.OCCUPIED);
                                }
                                FourCellShip.counterP1++;
                            }
                        }
                    }
                }
            }


                break;
            }

    }
}
