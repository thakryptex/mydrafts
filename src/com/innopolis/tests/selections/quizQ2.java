package com.innopolis.tests.selections;

/*
Создать рекурсивный метод подсчёта факториала от числа n: n!
Затем второй метод, в котором модифицировать предыдущий, чтобы он считал факториал от (n*k): (n*k)!
 */

import java.util.Scanner;

public class quizQ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число n и получите его факториал:");
        int n = scanner.nextInt();
        System.out.println("Факториал n: " + factor(n));

        System.out.println("Введите число k и получите факториал произведения n и k:");
        int k = scanner.nextInt();
        System.out.println("Факториал n*k: " + factor(n,k));

    }

    public static long factor(int n) {
        return (n == 0) ? 1 : n*factor(n-1);
    }

    public static long factor(int n, int k) {
        return ((n*k) == 0) ? 1 : (n*k)*factor((n*k)-1, 1);
    }

}
