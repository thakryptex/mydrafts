package com.innopolis.tests.bootcamp.battleship;

import java.util.ArrayList;

public class Ship {

    protected int decksLeft;
    protected ArrayList<Cell> cells = new ArrayList<>();
    protected Player player;

    public Ship(Player player) {
        this.player = player;
    }

    public void damaged() {
        if (decksLeft > 0)
        decksLeft--;
        else this.destroyed();
    }

    public void destroyed() {
        //TODO ������ �������� �������� ������ � �������� state, � ����� ������� ��� cells, ���� �� Player � ���������� � null.
//        cells.
        System.out.println(this.toString() + " ���������.");
    }

    @Override
    public String toString() {
        return "������� " + getClass() +
                "������ " + player;
    }
}
