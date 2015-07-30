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

    public static void doShot(Player attacker, Player victim) { //TODO проверку ввода сделать
        Cell cell;
        while (true) {
            System.out.println("Введите номер ячейки:");
            String string = scanner.nextLine();
            char c1 = string.charAt(0);
            char c2;
            int column = c1 % 64;
            int row;
            if (string.length() > 2 && string.charAt(1) == 1 && string.charAt(2) == 0)
                row = 10;
            else {
                c2 = string.charAt(1);
                row = c2 % 48;
            }
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
