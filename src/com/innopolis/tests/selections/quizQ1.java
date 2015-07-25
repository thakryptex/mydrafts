package com.innopolis.tests.selections;

/*
Ввести с клавиатуры число n.
Создать матрицу n*n и вывести её на экран.
Элементы матрицы содержат в себе два символа "*" и "_", которые всегда чередуются между собой.
Если предыдущий элемент был "*" (хоть и на предыдущей строке), то следующий всегда должен быть "_".
 */

import java.util.Scanner;

public class quizQ1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

//        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i+j)%2 == 0)
                    System.out.print("*");
                else System.out.print("_");;
            }
            System.out.println();
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if ((i+j)%2 == 0)
//                    matrix[i][j]='*';
//                else matrix[i][j]='_';
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++)
//            {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }

    }
}
