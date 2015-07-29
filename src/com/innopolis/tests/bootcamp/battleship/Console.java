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
        for (int i = 0; i < 10; i++) {

            if (i == 9) System.out.print((i + 1) + " "); // ����� �������
            else System.out.print(" " + (i+1) + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(player.getPlayerField().getFieldOfCells()[i][j] + " ");
            }

            if (i == 9) System.out.print("     " + (i+1) + " "); // ������ �������
            else System.out.print("      " + (i+1) + " ");
            for (int k = 0; k < 10; k++) {
                System.out.print(player.getEnemyTemplate().getFieldOfCells()[i][k] + " ");
            }
            System.out.println();
        }
    }

    public static void doShot(Player player) {
        System.out.println("������� ����� ������:");
        String string = scanner.nextLine();
        char c1 = string.charAt(0);
        char c2;
        int column = c1 % 65;
        int row;
        if (string.indexOf(10) > 0) row = 9;
        else {
            c2 = string.charAt(1);
            row = c2 % 48;
        }
        Cell cell = player.getPlayerField().getFieldOfCells()[column][row];
        player.shoot(cell);
    }
}
