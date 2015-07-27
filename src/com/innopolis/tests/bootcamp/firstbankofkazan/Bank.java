package com.innopolis.tests.bootcamp.firstbankofkazan;

import com.innopolis.tests.bootcamp.firstbankofkazan.exceptions.TooManyCustomersException;

import java.util.ArrayList;

public class Bank {
    private static ArrayList<Accounts> accountsList = new ArrayList<>(); // ������ ���� �� ������ 100

    // �������� �������� ��� �������� � ��������� (�� ����� 100 ��������� � �����)
    public static Accounts openAccount(People people) {
        try {
            if (accountsList.size() == 100)
                throw new TooManyCustomersException("� ���������, ���� �� �������� �����, ��� �� 100 ��������� ������������. �� � ���� �������� ��� � ��� �������� ��������� �����. �������� ��������� �� ������������ ����������");
        } catch (TooManyCustomersException e) {
            System.out.println(e.getMessage());
        }
        Accounts account = new Accounts(people);
        accountsList.add(account);
        return account;
    }

    public static void closeAccount(People people) {
        accountsList.remove(people.getAccount());
        people.setAccount(null);
    }

    // ������ ��������� �� ����� �������
    public static void payInterest(Cards card) {
        double money = card.calculateInterest(); // ����� ������� ������� ����� ��������
        Transactions.interest(card, money, card.getTransactionLog().size()+1); // ������ ����������
    }

    public static ArrayList<Accounts> getAccountsList() {
        return accountsList;
    }
}