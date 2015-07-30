package com.innopolis.tests.bootcamp.battleship;

public class Field {

    private Cell[][] field;
    private Player player;

    public Field(Player player) {
        this.player = player;
        field = new Cell[12][12];
    }

    public void initializeField() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                this.field[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell[][] getCellsArray() {
        return field;
    }

    public Cell getCell(int y, int x) {
        return field[y][x];
    }

}
