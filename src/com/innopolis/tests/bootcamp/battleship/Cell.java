package com.innopolis.tests.bootcamp.battleship;

import java.io.Serializable;

public class Cell implements Serializable {

    public enum CellState {
        EMPTY('~'), OREOL('~'), SHIPPED('•'), SHOOTED('o'), DAMAGED('X');
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
    private Ship ship;
//    private Field field;

    public Cell(int y, int x) {
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

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
