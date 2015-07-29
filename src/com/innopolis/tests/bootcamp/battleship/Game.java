package com.innopolis.tests.bootcamp.battleship;

public class Game {

    private static Game game;

    private boolean playersTurn;
    private boolean playing;
    private PlayerHuman human;
    private PlayerAI ai;

    private Game() {
        this.playersTurn = true;
        this.playing = true;
        this.human = new PlayerHuman();
        this.ai = new PlayerAI();

    }

    public static void newGame() {
        Game game = new Game();
        game.startGame();
    }

    public static void endGame() {
        game.playing = false;
    }

    public static void restartGame() {
        game = null;
        newGame();
    }

    public void startGame() {
        Console.whatIsYourName(human);
        human.createField();
        ai.createField();
        Generator.generateShips(human, ai);
        Console.printFields(human);
    }

    public static void playGame() {
        while (game.playing) {
            if (game.playersTurn) {
                Console.doShot(game.human);
            } else {
//                game.ai.shoot();
            }

            endGame();
        }
    }

    public static Game getGame() {
        return game;
    }

    public boolean isPlayersTurn() {
        return playersTurn;
    }

    public void setPlayersTurn(boolean playersTurn) {
        this.playersTurn = playersTurn;
    }

}
