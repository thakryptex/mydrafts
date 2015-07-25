package com.innopolis.tests.tasksB4Camp.bootcampQ2;

//������������ ���������, ������������ ������ ����-��� �������, �������, ������� ����� 2^K �������,
// ��� K - ���������� �������, �������� �������������.
//?	����� ��������� ������� ������ ������������� ����� �� 1 �� 2^K � ��������� ������� � ������ ������������:
// ���������, �������� ��� ��������, ��� ����� � ��������, ��������, ��������� ���������� ������� � ������������ - 0,5,
// ������ - 0,25, ������ - 0,25. � ��������� �������� ������������� ������������ ����������.
//?	� ������ ������ ���������� �������� ����� �������� �� 2-� �����.
//?	���������� �������� ������������ �� ��������� ��������:
//    ?	������ ��������� ������� (������� ��������� ��� ������ ��������)
//    ?	������� ��������� ������ (�������� ��������� ������)
//    ?	������ ��������� ������ (������� ��������� �������)
//?	���� ������ �������� ���������� ����, �� ���� ��������������.
//?	���������� ������� ��������� �� �����.
//
//        ������:
//        ������� ������:
//        3
//
//        �������� ������:
//        �����1: �������
//        �����2: ������
//        �����3: ������
//        �����4: ������
//        �����5: �������
//        �����6: ������
//        �����7: ������
//        �����8: ������
//
//        ����� 1:
//        �����1 vs �����2 - ������� �����1!
//        �����3 vs �����4 - ������� �����4!
//        �����5 vs �����6 - ������� �����5!
//        �����7 vs �����8 - ������� �����8!
//
//        ����� 2:
//        �����1 vs �����4 - ������� �����1!
//        �����5 vs �����8 - ������� �����5!
//
//        �����:
//        �����1 vs �����5 - ������� �����5!


import java.util.ArrayList;
import java.util.Scanner;

public class GameMainClass {

    public final static String[] KNB_Array = {"������", "�������", "������"};
    public final static int[] K_Tactic = {0, 0, 1, 2}; // 0 - ��� ������   >
    public final static int[] N_Tactic = {1, 1, 0, 2}; // 1 - ��� �������  > ��� ���������� ����������� 50/25/25
    public final static int[] B_Tactic = {2, 2, 0, 1}; // 2 - ��� ������   >
    public final static int[] ALL_Tactics[] = {K_Tactic, N_Tactic, B_Tactic};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ����� ������� �:");
        int k = scanner.nextInt();

        ArrayList<Players> playersList = new ArrayList<Players>(Players.makePlayers(k));

        System.out.println();
        System.out.println("������ ������� � �������:");
        for (int i = 0; i < playersList.size(); i++)
        {
            System.out.println(playersList.get(i));
        }

        System.out.println();

        for (int i = 1; i <= k; i++) {
            if (i < k) {
                System.out.println("����� " + i + ":");
                for (int j = 0; j < playersList.size(); j++) {
                    Fights.fightOfPlayers(playersList, j, j+1);
                }
                System.out.println();
            } else {
                System.out.println("�����:");
                for (int j = 0; j < playersList.size(); j++) {
                    Fights.fightOfPlayers(playersList, j, j + 1);
                }
            }
        }
    }
}
