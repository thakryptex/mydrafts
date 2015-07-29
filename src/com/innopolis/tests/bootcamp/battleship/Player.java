package com.innopolis.tests.bootcamp.battleship;

import java.util.ArrayList;

public abstract class Player {

    protected String name;
    protected ArrayList<Cell[]> ships = new ArrayList<>();
    protected Field playerField;
    protected Field enemyTemplate;

    public void createField() {
        this.playerField = new Field();
        this.enemyTemplate = new Field();
        this.playerField.initializeField();
        this.enemyTemplate.initializeField();
    }

    public void shoot(Cell cell) { //TODO сделать boolean и привязать к playersTurn
        if (cell.getState().equals(Cell.CellState.DAMAGED) || cell.getState().equals(Cell.CellState.SHOOTED))
            System.out.println("Данная клетка уже недоступна для стрельбы по ней. Выберите другую.");
        else {
            // здесь проверять состояние клетки на поле противника (не на шаблоне)

            //TODO изменение статуса хода
            Game.getGame().setPlayersTurn(Game.getGame().isPlayersTurn() ? false : true);
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

}
