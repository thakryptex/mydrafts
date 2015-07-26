package com.innopolis.tests.bootcamp.firstbankofkazan;

import com.innopolis.tests.bootcamp.firstbankofkazan.enums.Sex;

import java.util.Scanner;

public class Menu {

    public static People menuCreatePeople() {
        Scanner scanner = new Scanner(System.in);
        People people = new People();
        System.out.println();

        System.out.println("������� ���� ������� ��� ��������");
        people.setSecondName(scanner.next());
        people.setFirstName(scanner.next());
        people.setPatronym(scanner.nextLine().replace(" ", ""));
        System.out.println();

        System.out.println("����������, ������� ���� ���:");
        do {
            String t = scanner.nextLine().toUpperCase();
            if (t.equals("MALE") || t.equals("M") || t.equals("�") || t.equals("�������")) {
                people.setSex(Sex.MALE);
                break;
            }
            else if (t.equals("FEMALE") || t.equals("F") || t.equals("�") || t.equals("�������")) {
                people.setSex(Sex.FEMALE);
                break;
            }
            else {
                System.out.println("������� ��� ���������");
            }
        }
        while (true);

        System.out.println();

        System.out.println("������� ���� �������� (������: 01.03.1980):");
        while (true) {
            try {
                people.setDateOfBirth(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("�� ����� ���� � ������������ �������. �������, ����������, � ���� �������: 01.03.1980, ��� 01 - ��� ����, 03 - ��� �����, � 1980 - ��� ��������");
            }
        }
        System.out.println();

        System.out.println("��������� ����� - ������� ����� ��������:");
        while (true) {
            try {
                people.setPassportNum(scanner.nextLong());
                break;
            } catch (Exception e) {
                System.out.println("�� ����� �������� ����� �������� (������� ����� ����), ���������� ��� ���...");
            }
        }
        System.out.println();

        people.setAccount(new Accounts(people));

        return people;
    }

    public static void menuCard(Accounts account) {
        /*
        if (card.size = null)
            - info
            - createCard
        else
            - get balance
            - make transactions
            - get transactions list
         */
    }

    public static void menuAccountMain(Accounts account) {
        /*
        - create/close cards
        - get cards list
        - go to cardMenu
        - get full balance
        - get full transactions list
         */
    }
}
