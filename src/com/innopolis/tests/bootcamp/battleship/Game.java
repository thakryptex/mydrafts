package com.innopolis.tests.bootcamp.battleship;

import java.util.Random;

public class Game {

    private static Game theGame;
    private static Random random = new Random();

    private boolean playerTurn;
    private boolean playing;
    private PlayerHuman human;
    private PlayerAI ai;

    public Game() {
        this.playerTurn = true;
        this.playing = true;
        this.human = new PlayerHuman();
        this.ai = new PlayerAI();

    }

    public static void newGame() {
        Game game = new Game();
        theGame = game;
        game.startGame();
    }

    public static void endGame() {
        theGame.playing = false;
    }

    public static void restartGame() {
        theGame = null;
        newGame();
    }

    public void startGame() {
//        Console.whatIsYourName(human); // ������� ���� �� ������ ���� � ��������
        human.createField();
        ai.createField();
        Generator.generateShips(human, ai);
        Console.printFields(human);
    }

    public static void playGame() {
        while (theGame.playing) {
            System.out.println();
            if (theGame.playerTurn) {
                Console.doShot(theGame.human, theGame.ai);
            } else {
                Console.doShotAI(theGame.ai, theGame.human);
            }
            if (theGame.human.ships.size() == 0) {
                System.out.println("========================");
                System.out.println("������� " + theGame.ai);
                System.out.println("========================");
                endGame();
            }
            if (theGame.ai.ships.size() == 0) {
                System.out.println("========================");
                System.out.println("������� " + theGame.human);
                System.out.println("========================");
                endGame();
            }
            System.out.println();
            Console.printFields(theGame.human);
        }
    }


    public static Game getTheGame() {
        return theGame;
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public PlayerHuman getHuman() {
        return human;
    }

    public PlayerAI getAi() {
        return ai;
    }
}
