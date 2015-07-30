package com.innopolis.tests.bootcamp.battleship;

public class PlayerHuman extends Player {

    public PlayerHuman() {
        this.name = "Human";
    }

    @Override
    public String toString() {
        return name;
    }

}
