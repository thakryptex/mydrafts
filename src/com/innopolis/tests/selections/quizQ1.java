package com.innopolis.tests.selections;

/*
������ � ���������� ����� n.
������� ������� n*n � ������� � �� �����.
�������� ������� �������� � ���� ��� ������� "*" � "_", ������� ������ ���������� ����� �����.
���� ���������� ������� ��� "*" (���� � �� ���������� ������), �� ��������� ������ ������ ���� "_".
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
