package com.innopolis.tests.bootcamp.battleship;

import com.innopolis.tests.bootcamp.battleship.ships.FourCellShip;
import com.innopolis.tests.bootcamp.battleship.ships.OneCellShip;
import com.innopolis.tests.bootcamp.battleship.ships.ThreeCellShip;
import com.innopolis.tests.bootcamp.battleship.ships.TwoCellShip;

import java.util.ArrayList;

public abstract class Ships {

    static int counterP1 = OneCellShip.counterP1 + TwoCellShip.counterP1 + ThreeCellShip.counterP1 + FourCellShip.counterP1;
    static int counterP2 = OneCellShip.counterP2 + TwoCellShip.counterP2 + ThreeCellShip.counterP2 + FourCellShip.counterP2;

    protected int decksLeft;
    protected ArrayList<Cell> cells = new ArrayList<>();
    protected Player player;

    public Ships(Player player, int decksLeft) {
        this.player = player;
        this.decksLeft = decksLeft;
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
