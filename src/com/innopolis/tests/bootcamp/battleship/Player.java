package com.innopolis.tests.bootcamp.battleship;

import java.util.ArrayList;

public abstract class Player {

    protected String name;
    protected ArrayList<Ship> ships = new ArrayList<>();
    protected Field playerField;
    protected Field enemyTemplate;

    public Player() {
    }

    public void createField() {
        this.playerField = new Field(this);
        this.enemyTemplate = new Field(this);
        this.playerField.initializeField();
        this.enemyTemplate.initializeField();
    }

    public void shoot(Player attacker, Player victim, Cell cell) {
        if (cell.getState().equals(Cell.CellState.EMPTY) || cell.getState().equals(Cell.CellState.OREOL)) {
            cell.setState(Cell.CellState.SHOOTED);
            attacker.getEnemyTemplate().getCell(cell.getY(), cell.getX()).setState(Cell.CellState.SHOOTED);
            System.out.println("-> " + attacker + " промахнулся");
            Game.getTheGame().setPlayerTurn(Game.getTheGame().isPlayerTurn() ? false : true);
        } else {
            if (cell.getState().equals(Cell.CellState.SHIPPED)) {
                cell.setState(Cell.CellState.DAMAGED);
                cell.getShip().damagedBy(attacker);
                attacker.getEnemyTemplate().getCell(cell.getY(), cell.getX()).setState(Cell.CellState.DAMAGED);
            }
        }
    }

    public Field getPlayerField() {
        return playerField;
    }

    public void setPlayerField(Field playerField) {
        this.playerField = playerField;
    }

    public Field getEnemyTemplate() {
        return enemyTemplate;
    }

    public void setEnemyTemplate(Field enemyTemplate) {
        this.enemyTemplate = enemyTemplate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }


}
