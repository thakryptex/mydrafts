package com.innopolis.tests.bootcamp.battleship;

import java.util.Scanner;

public class Console {

    static Scanner scanner = new Scanner(System.in);

    public static void whatIsYourName(Player human) {
        System.out.println("Введите своё имя:");
        human.setName(scanner.nextLine());
    }

    public static void printFields(Player player) { //TODO убрать конкатенацию из цикла
        System.out.println("       Ваше поле:                Поле противника:");
        System.out.print("   A B C D E F G H I J");
        System.out.println("         A B C D E F G H I J");
        for (int i = 1; i < 11; i++) {

            if (i == 10) System.out.print(i + " "); // левая таблица
            else System.out.print(" " + i + " ");
            for (int j = 1; j < 11; j++) {
                System.out.print(player.getPlayerField().getCellsArray()[i][j] + " ");
            }

            if (i == 10) System.out.print("     " + i + " "); // правая таблица
            else System.out.print("      " + i + " ");
            for (int k = 1; k < 11; k++) {
                System.out.print(player.getEnemyTemplate().getCellsArray()[i][k] + " ");
            }
            System.out.println();
        }
    }

    public static int launchGame() {
        int i;
        while (true) {
            System.out.println("Хотите начать новую игру или загрузить старую?");
            System.out.println("1 - Новая игра");
            System.out.println("2 - Загрузить");
            i = Integer.parseInt(scanner.nextLine());
            if (i == 1) break;
            else if (i == 2) {
                try {
                    Game.setTheGame(Game.loadGame());
                    break;
                } catch (Exception e) {
                    System.out.println("Файла сохранения не найдено. Создаю новую игру.");
                    i = 1;
                }
            }
        }
        return i;
    }

    public static void doShot(Player attacker, Player victim) throws Exception { //TODO проверку ввода сделать
        Cell cell;
        while (true) {
            System.out.println("Введите номер ячейки:");
            String string = scanner.nextLine();
            if (string.equals("exit")) {
                Game.saveGame(Game.getTheGame());
                System.exit(0);
            }
            char c1 = string.charAt(0);
            char c2;
            int column = c1 % 64;
            int row = 11;
            if (string.length() > 2) {
                String ten = string.substring(1, string.length());
                row = Integer.parseInt(ten);
            } else if (string.length() == 2){
                c2 = string.charAt(1);
                row = c2 % 48;
            }
            if (column > 10 || row > 10) continue;
            cell = victim.getPlayerField().getCellsArray()[row][column];
            if (cell.getState().equals(Cell.CellState.SHOOTED) || cell.getState().equals(Cell.CellState.DAMAGED))
                continue;
            else break;
        }
        attacker.shoot(attacker, victim, cell);
    }

    public static void doShotAI(PlayerAI ai, Player victim) {
        Cell cell = ai.getEnemyCell(victim);
        int i = cell.getX() + 64;
        char letter = (char) i;
        System.out.println(letter + "" + cell.getY());
        ai.shoot(ai, victim, cell);
    }
}
