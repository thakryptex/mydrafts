package com.innopolis.tests.selections;

/*
������� ����������� ����� �������� ���������� �� ����� n: n!
����� ������ �����, � ������� �������������� ����������, ����� �� ������ ��������� �� (n*k): (n*k)!
 */

import java.util.Scanner;

public class quizQ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("������� ����� n � �������� ��� ���������:");
        int n = scanner.nextInt();
        System.out.println("��������� n: " + factor(n));

        System.out.println("������� ����� k � �������� ��������� ������������ n � k:");
        int k = scanner.nextInt();
        System.out.println("��������� n*k: " + factor(n,k));

    }

    public static long factor(int n) {
        return (n == 0) ? 1 : n*factor(n-1);
    }

    public static long factor(int n, int k) {
        return ((n*k) == 0) ? 1 : (n*k)*factor((n*k)-1, 1);
    }

}
