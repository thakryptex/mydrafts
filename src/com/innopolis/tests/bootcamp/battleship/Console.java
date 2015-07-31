package com.innopolis.tests.bootcamp.battleship;

import java.util.Scanner;

public class Console {

    static Scanner scanner = new Scanner(System.in);

//    public static void whatIsYourName(Player human) {
//        System.out.println("������� ��� ���:");
//        human.setName(scanner.nextLine());
//    }

    public static void printFields(Player player) { //TODO ������ ������������ �� �����
        System.out.println("       ���� " + player.getName() + ":               ���� ����������:");
        System.out.print("   A B C D E F G H I J");
        System.out.println("         A B C D E F G H I J");
        for (int i = 1; i < 11; i++) {

            if (i == 10) System.out.print(i + " "); // ����� �������
            else System.out.print(" " + i + " ");
            for (int j = 1; j < 11; j++) {
                System.out.print(player.getPlayerField().getCellsArray()[i][j] + " ");
            }

            if (i == 10) System.out.print("     " + i + " "); // ������ �������
            else System.out.print("      " + i + " ");
            for (int k = 1; k < 11; k++) {
                System.out.print(player.getEnemyTemplate().getCellsArray()[i][k] + " ");
            }
            System.out.println();
        }
    }

    public static void printFields(PlayerAI ai1, PlayerAI ai2) {
        System.out.println("        ���� " + ai1.getName() + ":                  ���� " + ai2.getName() + ":");
        System.out.print("   A B C D E F G H I J");
        System.out.println("         A B C D E F G H I J");
        for (int i = 1; i < 11; i++) {

            if (i == 10) System.out.print(i + " "); // ����� �������
            else System.out.print(" " + i + " ");
            for (int j = 1; j < 11; j++) {
                System.out.print(ai1.getPlayerField().getCellsArray()[i][j] + " ");
            }

            if (i == 10) System.out.print("     " + i + " "); // ������ �������
            else System.out.print("      " + i + " ");
            for (int k = 1; k < 11; k++) {
                System.out.print(ai2.getPlayerField().getCellsArray()[i][k] + " ");
            }
            System.out.println();
        }
    }

    public static int launchGame() throws Exception {
        int i;
        while (true) {
            System.out.println("������ ������ ����� ���� ��� ��������� ������?");
            System.out.println("1 - ����� ����");
            System.out.println("2 - ���������");
            System.out.println("3 - ��������� vs. ���������");
            i = Integer.parseInt(scanner.nextLine());
            if (i == 1) break;
            else if (i == 2) {
                try {
                    Game.setTheGame(Game.loadGame());
                    break;
                } catch (Exception e) {
                    System.out.println("����� ���������� �� �������. ������ ����� ����.");
                    i = 1;
                }
            } else if (i == 3) {
                PlayerAI ai = new PlayerAI("��");
                Game.newGame(ai);
            }
        }
        return i;
    }

    public static void doShot(Player attacker, Player victim) throws Exception {
        Cell cell;
        while (true) {
            System.out.println("������� ����� ������:");
            String string = scanner.nextLine();
            if (string.equals("exit")) {
                Game.saveGame(Game.getTheGame());
                System.exit(0);
            } else if (string.equals("restart")) {
                Game.restartGame();
            } else {
                char c1 = string.charAt(0);
                char c2;
                int column = c1 % 64;
                int row = 11;
                if (string.length() > 2) {
                    String ten = string.substring(1, string.length());
                    row = Integer.parseInt(ten);
                } else if (string.length() == 2) {
                    c2 = string.charAt(1);
                    row = c2 % 48;
                }
                if (column > 10 || row > 10) continue;
                cell = victim.getPlayerField().getCellsArray()[row][column];
                if (cell.getState().equals(Cell.CellState.SHOOTED) || cell.getState().equals(Cell.CellState.DAMAGED))
                    continue;
                else break;
            }
        }
        attacker.shoot(attacker, victim, cell);
    }

    public static void doShotAI(PlayerAI ai, Player victim) { //TODO ������� �������� �����������
        Cell cell = ai.getEnemyCell(victim);
        int i = cell.getX() + 64;
        char letter = (char) i;
        System.out.println(letter + "" + cell.getY());
        ai.shoot(ai, victim, cell);
    }

    public static void restart() {
        System.out.println("������ ������ ����� ����?");
        System.out.println("1 - ��");
        System.out.println("2 - ���");
        while (true) {
            int i = Integer.parseInt(scanner.nextLine());
            if (i == 1) Game.restartGame();
            else if (i == 2) System.exit(1);
        }
    }

}
