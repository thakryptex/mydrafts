package com.innopolis.tests.bootcamp.battleship;

import java.io.Serializable;

public class PlayerHuman extends Player implements Serializable {

    public PlayerHuman() {
        this.name = "Human";
    }

    @Override
    public String toString() {
        return name;
    }

}
