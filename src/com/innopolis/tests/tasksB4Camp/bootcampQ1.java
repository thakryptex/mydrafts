package com.innopolis.tests.tasksB4Camp;

// ����� ����� ����������� ��������� �� �������� �������������.
// ������ ��� ��������� ��������.
// ������ ����� � ������ ������ - �� ����������.

import java.util.Scanner;

public class bootcampQ1 {

    public static double a, b, c, D, x1, x2;

    public static void main(String[] args) {

        System.out.println("������� ������������ ��� ����������� ���������:");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            a = scanner.nextDouble();
            if (a == 0) System.out.println("����������� A �� ������ ��������� ����. ���������� ��� ���:");
            else break;
        }
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        D = (b*b) - 4*a*c;

        if (D < 0) {
            System.out.println("���������� ��������� �� ����� ������ �� ��������� �������������� �����");
        }

        if (D == 0) {
            x1 = (0-b)/(2*a);
            System.out.println("������ ��������� = " + x1);
        }

        if (D > 0) {
            x1 = ((0-b) + Math.sqrt(D))/(2*a);
            x2 = ((0-b) - Math.sqrt(D))/(2*a);
            System.out.println("����� ���������: x1 = " + x1 + ",  x2 = " +x2);
        }
    }
}
