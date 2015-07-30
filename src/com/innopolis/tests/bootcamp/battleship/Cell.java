package com.innopolis.tests.bootcamp.battleship;

public class Cell {

    public enum CellState {
        EMPTY('o'), OCCUPIED('*'), SHIPPED('•'), SHOOTED('.'), DAMAGED('X');
        private char c;
        CellState(char c){
            this.c=c;
        }

        public char getChar() {
            return c;
        }
    }

    private int x, y;
    private CellState state;
    private Ships ship;
//    private Field field;

    public Cell(int x, int y) {
        this.state = CellState.EMPTY;
        this.ship = null;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.valueOf(state.getChar());
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}
