package com.innopolis.tests.bootcamp.firstbankofkazan;

import com.innopolis.tests.bootcamp.firstbankofkazan.enums.TransactionType;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("�������� ATM...");
        System.out.println();
        System.out.println("����� ���������� � ������ ���� ������!");
        System.out.println();
        System.out.println("��� ������ � ��� ��� ���������� ������� ���� ������� � ����� �����.");
        System.out.println("��� ����� ��� ����������� ������ ��������� ������:");
        System.out.println("������� ��� ��������, ���� ��������, ���, ����� ��������.");
        System.out.println();
        System.out.println("�� ������ ����������?");
        System.out.println("1 - ��");
        System.out.println("2 - ���");

        int i;
        while (true) {
            i = scanner.nextInt();
            if (i == 1 || i == 2) break;
            else {
                System.out.println("��� ���������� ������ ���� 1 = ��, ���� 2 = ���. ���������� ��� ���:");
            }
        }
        if (i == 2) {
            System.out.println("��� ������ ������ �� �� ����� ������� ��� ������� � ����� �����. ����� ��� �������!");
            System.exit(0);
        }

        People people = Menu.menuCreatePeople();

        System.out.println("���� ������:");
        System.out.println(people);
        System.out.println();

        System.out.println("�� ������� ������ ����������� �������� � ������ ����� ������.");
        System.out.println("������ �� ������ ��������� ����� � ����� �����, ������� �� ��� ������ � �������� �� ��� ��������.");

        Menu.menuCards(people.getAccount());

        Menu.menuAccountMain(people.getAccount());
        System.out.println();

        if (people.getAccount().getCards().size() > 0) {
            Cards card = people.getAccount().getCards().get(0);
            System.out.println("����� 4 ���������� � ������...");
            people.getAccount().makeTransaction(TransactionType.DEPOSIT, card, 666);
            Thread.sleep(1000);
            people.getAccount().makeTransaction(TransactionType.WITHDRAWAL, card, 333);
            Thread.sleep(1000);
            people.getAccount().makeTransaction(TransactionType.DEPOSIT, card, 999);
            Thread.sleep(1000);
            people.getAccount().makeTransaction(TransactionType.WITHDRAWAL, card, 777);

            System.out.println();
            System.out.println("����� ���� �������� ��� �������� �� �����...");
            Bank.payInterest(card);

            Menu.menuSaveTransactionLogsIntoTxt(card);

            System.out.println();
            System.out.println("������� �� ������������� ����� ������� ����� ������. ����� �������!");
        }


    }
}
