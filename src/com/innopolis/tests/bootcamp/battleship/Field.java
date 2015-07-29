package com.innopolis.tests.bootcamp.battleship;

public class Field {

    private Cell[][] field;

    public Field() {
        field = new Cell[10][10];
    }

    public void initializeField() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.field[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell[][] getFieldOfCells() {
        return field;
    }

}
