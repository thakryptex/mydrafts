package com.innopolis.tests.bootcamp.battleship;

import java.io.*;
import java.util.Random;

public class Game implements Serializable {

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
//        Console.whatIsYourName(human); // никакой роли не играет пока в принципе
        human.createField();
        ai.createField();
        Generator.generateShips(human, ai);
        Console.printFields(human);
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
                System.out.println("========================");
                System.out.println("Победил " + theGame.ai);
                System.out.println("========================");
                endGame();
            }
            if (theGame.ai.ships.size() == 0) {
                System.out.println("========================");
                System.out.println("Победил " + theGame.human);
                System.out.println("========================");
                endGame();
            }
            System.out.println();
            Console.printFields(theGame.human);
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

    public PlayerHuman getHuman() {
        return human;
    }

    public PlayerAI getAi() {
        return ai;
    }
}
