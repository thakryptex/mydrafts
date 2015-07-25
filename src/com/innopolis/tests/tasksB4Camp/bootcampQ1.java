package com.innopolis.tests.tasksB4Camp;

// Найти корни квадратного уравнения по заданным коэффициентам.
// Учесть все возможные варианты.
// Формат ввода и вывода данных - на усмотрение.

import java.util.Scanner;

public class bootcampQ1 {

    public static double a, b, c, D, x1, x2;

    public static void main(String[] args) {

        System.out.println("Введите коэффициенты для квадратного уравнения:");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            a = scanner.nextDouble();
            if (a == 0) System.out.println("Коэффициент A не должен равняться нулю. Попробуйте ещё раз:");
            else break;
        }
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        D = (b*b) - 4*a*c;

        if (D < 0) {
            System.out.println("Квадратное уравнение не имеет корней на множестве действительных чисел");
        }

        if (D == 0) {
            x1 = (0-b)/(2*a);
            System.out.println("Корень уравнения = " + x1);
        }

        if (D > 0) {
            x1 = ((0-b) + Math.sqrt(D))/(2*a);
            x2 = ((0-b) - Math.sqrt(D))/(2*a);
            System.out.println("Корни уравнения: x1 = " + x1 + ",  x2 = " +x2);
        }
    }
}
