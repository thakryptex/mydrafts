package com.innopolis.tests.bootcamp.battleship;

import java.io.*;
import java.util.Random;

public class Game implements Serializable {

    private static Game theGame;
    private static Random random = new Random();

    private boolean playerTurn;
    private boolean playing;
    private Player human;
    private PlayerAI ai;

    public Game() {
        this.playerTurn = true;
        this.playing = true;
        this.human = new PlayerHuman();
        this.ai = new PlayerAI();
    }

    public Game(PlayerAI ai) {
        this.playerTurn = true;
        this.playing = true;
        this.human = ai;
        this.ai = new PlayerAI();
    }

    public static void newGame() {
        Game game = new Game();
        theGame = game;
        game.startGame();
    }

    public static void newGame(PlayerAI ai) throws Exception {
        Game game = new Game();
        theGame = game;
        game.startGame(ai);
    }

    public static void endGame() {
        theGame.playing = false;
    }

    public static void restartGame() {
        theGame = null;
        newGame();
    }

    public static void restartGame(PlayerAI ai) throws Exception {
        theGame = null;
        Console.launchGame();
    }

    public void startGame() {
        human.createField();
        ai.createField();
        Generator.generateShips(human, ai);
        Console.printFields(human);
//        Console.printFields(ai); //TODO �������
    }

    public void startGame(PlayerAI comp) throws Exception {
        comp.createField();
        ai.createField();
        Generator.generateShips(comp, ai);
        Console.printFields(comp, ai);
        Game.playGame(comp, ai);
    }

    public static void playGame() throws Exception {
        while (theGame.playing) {
            System.out.println();
            if (theGame.playerTurn) {
                Console.doShot(theGame.human, theGame.ai);
            } else {
                Console.doShotAI(theGame.ai, theGame.human);
            }
            if (theGame.human.ships.size() == 0) {
                System.out.println();
                System.out.println("===========================");
                System.out.println("    ������� " + theGame.ai + "!!!");
                System.out.println("===========================");
                System.out.println();
                endGame();
                Console.restart();
            }
            if (theGame.ai.ships.size() == 0) {
                System.out.println();
                System.out.println("===========================");
                System.out.println("    ������� " + theGame.human + "!!!");
                System.out.println("===========================");
                System.out.println();
                endGame();
                Console.restart();
            }
            System.out.println();
            Console.printFields(theGame.human);
//            Console.printFields(theGame.ai); //TODO �������
        }
    }

    public static void playGame(PlayerAI ai1, PlayerAI ai2) throws Exception {
        while (theGame.playing) {
            System.out.println();
            if (theGame.playerTurn) {
                Console.doShotAI(ai1, ai2);
            } else {
                Console.doShotAI(ai2, ai1);
            }
            if (ai1.ships.size() == 0) {
                System.out.println();
                System.out.println("===========================");
                System.out.println("    ������� " + ai2.getName() + "!!!");
                System.out.println("===========================");
                System.out.println();
                endGame();
                Game.restartGame(ai1);
            }
            if (ai2.ships.size() == 0) {
                System.out.println();
                System.out.println("===========================");
                System.out.println("    ������� " + ai1.getName() + "!!!");
                System.out.println("===========================");
                System.out.println();
                endGame();
                Game.restartGame(ai1);
            }
            System.out.println();
            Console.printFields(ai1, ai2);
        }
    }

    public static Game loadGame() throws Exception {
        Game game = new Game();
        FileInputStream fileInputStream = new FileInputStream("save.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        game = (Game) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return game;
    }

    public static void saveGame(Game game) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("save.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(game);
        objectOutputStream.close();
        objectOutputStream.close();
    }

    public static Game getTheGame() {
        return theGame;
    }

    public static void setTheGame(Game theGame) {
        Game.theGame = theGame;
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public Player getHuman() {
        return human;
    }

    public PlayerAI getAi() {
        return ai;
    }
}
