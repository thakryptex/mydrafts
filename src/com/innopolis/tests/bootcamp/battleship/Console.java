package com.innopolis.tests.bootcamp.battleship;

import java.util.Scanner;

public class Console {

    static Scanner scanner = new Scanner(System.in);

    public static void whatIsYourName(Player human) {
        System.out.println("������� ��� ���:");
        human.setName(scanner.nextLine());
    }

    public static void printFields(Player player) { //TODO ������ ������������ �� �����
        System.out.println("       ���� ����:                ���� ����������:");
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

    public static void doShot(Player player) {
        System.out.println("������� ����� ������:");
        String string = scanner.nextLine();
        char c1 = string.charAt(0);
        char c2;
        int column = c1 % 64;
        int row;
        if (string.indexOf(10) > 0) row = 10;
        else {
            c2 = string.charAt(1);
            row = c2 % 47;
        }
        Cell cell = player.getPlayerField().getCellsArray()[column][row];
        player.shoot(cell);
    }
}
