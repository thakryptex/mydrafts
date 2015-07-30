package com.innopolis.tests.bootcamp.battleship;

import com.innopolis.tests.bootcamp.battleship.ships.FourCellShip;

import java.util.Random;

public class Generator {

    static Random random = new Random();
    static Cell.CellState state;

    public static void generateShips(Player p1, Player p2) {
        generatePlayerShips(p1);
//        p2.getPlayerField();
    }

    private static void generatePlayerShips(Player player) {
        Cell[][] cellsArray = player.getPlayerField().getCellsArray();
        String[] shipNames =  {"OneCellShip", "TwoCellShip", "ThreeCellShip", "FourCellShip"};
        int[] shipCount =  {4, 3, 2, 1};
        boolean shipCreated;

        while (player.getShips().size() < 10) {
            for (int i = 3; i >= 0; i--) {
                int counter = 0;
                while (counter < shipCount[i]) {
                    shipCreated = placeTheShip(player, cellsArray, i+1);
                    if (shipCreated)
                        counter++;
                }
            }
        }
    }

    private static boolean placeTheShip(Player player, Cell[][] cellsArray, int numOfDecks) {
        int x = random.nextInt(10)+1;
        int y = random.nextInt(10)+1;
        int t = random.nextInt(2);
        boolean shippingAllowed;

        if (t == 0 && x < 12-numOfDecks) {

            shippingAllowed = checkIfThereShip_Horizontal(x, y, cellsArray, numOfDecks);
            if (shippingAllowed) {
                Ship ship = new Ship(player);
                markCellsOfShip_Horizontal(x, y, cellsArray, ship, numOfDecks);
                player.getShips().add(ship);
                return true;
            }

        } else if (t == 1 && y < 12-numOfDecks) {

            shippingAllowed = checkIfThereShip_Vertical(x, y, cellsArray, numOfDecks);
            if (shippingAllowed) {
                Ship ship = new Ship(player);
                markCellsOfShip_Vertical(x, y, cellsArray, ship, numOfDecks);
                player.getShips().add(ship);
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfThereShip_Horizontal(int x, int y, Cell[][] cellsArray, int numOfDecks) {
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + numOfDecks; j++) {
                if (cellsArray[i][j].getState().equals(Cell.CellState.SHIPPED))
                    return false;
            }
        }
        return true;
    }

    private static boolean checkIfThereShip_Vertical(int x, int y, Cell[][] cellsArray, int numOfDecks) {
        for (int i = y - 1; i <= y + numOfDecks; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (cellsArray[i][j].getState().equals(Cell.CellState.SHIPPED))
                    return false;
            }
        }
        return true;
    }

    private static void markCellsOfShip_Horizontal(int x, int y, Cell[][] cellsArray, Ship ship, int numOfDecks) {
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + numOfDecks; j++) {
                if (i == y && j >= x && j <= x + (numOfDecks - 1)) {
                    cellsArray[i][j].setState(Cell.CellState.SHIPPED);
                    cellsArray[i][j].setShip(ship);
                } else {
                    cellsArray[i][j].setState(Cell.CellState.OCCUPIED);
                }
            }
        }
    }

    private static void markCellsOfShip_Vertical(int x, int y, Cell[][] cellsArray, Ship ship, int numOfDecks) {
        for (int i = y - 1; i <= y + numOfDecks; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (j == x && i >= y && i <= y + (numOfDecks - 1)) {
                    cellsArray[i][j].setState(Cell.CellState.SHIPPED);
                    cellsArray[i][j].setShip(ship);
                } else {
                    cellsArray[i][j].setState(Cell.CellState.OCCUPIED);
                }
            }
        }
    }



}
