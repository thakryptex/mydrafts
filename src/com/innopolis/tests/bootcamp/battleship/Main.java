package com.innopolis.tests.bootcamp.battleship;

public class Main {

    public static void main(String[] args) throws Exception {

        int i = Console.launchGame();

        if (i == 1) Game.newGame();
        if (i == 2) Console.printFields(Game.getTheGame().getHuman());

        Game.playGame();

    }
}
