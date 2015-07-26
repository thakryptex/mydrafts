package com.innopolis.tests.bootcamp.firstbankofkazan;

/*
Igor is a customer of The First Bank Kazan.
The bank has never had more than 100 customers at any time and allows customers to open accounts, close accounts,
and processes internal transactions between their accounts and deposits and debits from customers.
In order to open an account, it is required for Igor to give the bank information such as his first name, last name, and patronym.
The bank records his date of birth, sex, and passport number in order to ensure security.
First Bank Kazan has three account types, each with their own fees and interest amounts which are applied at the end of the month,
these are Savings (5% interest), chequing (1000p fee at end of month), and business (1% interest).
Igor has a balance, the bank requires that
a Savings account has an initial deposit of 50,000p,
a chequing account has a minimum 1,000p initial deposit,
and businesses must have 5,000,000p initial deposit.
Accounts can have transactions applied to them, which must be checked for validity.
At the end of the month all transactions made must be listed in an official statement of the account,
an account can have no more than 100 transactions per month.

Igor can make transitions. A transaction is applied to an account based on the account number(s).
Transactions can be withdrawals, deposits, transfers, and interest payments. Each transaction is given a transaction number,
which is the next in sequence. Transactions should have a means of being displayed at the end of the month in
a grand statement of all transactions of all accounts.

Classes:
- Costumers
- Bank
- Accounts
- Transactions
*/

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        ��� ������ ��������� ���� � main
        switch (scanner) {
            case 0 :
            case 1 : openAccount();
            case 2 : createCard();
            case 3 : makeTransaction();
            case 4 : showTransactionLog();
            case 5 : ...
         */
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

        Menu.menuCard(people.getAccount());

        Menu.menuAccountMain(people.getAccount());


//        People people = new People(scanner.next(), scanner.next(), scanner.next(), scanner.next(), , scanner.nextInt());

//        System.out.println(people);

        /*
        People Igor = new People("Igor", "Petrenko", "Fatherovich", "11/11/1911", Sex.MALE, 654576);
        Igor.setAccount(Bank.openAccount(Igor));
        System.out.println(Igor.getAccount().getCards().size());
        Igor.getAccount().createCard(9000, CardType.CHEQUING); //TODO ��� ����� ���������� ����� ��� �����?
        Igor.getAccount().createCard(55000, CardType.SAVINGS);
        System.out.println(Igor.getAccount().getCards().size());
        System.out.println();
        System.out.println();

        for (int i = 0; i < Igor.getAccount().getCards().size(); i++) { //TODO ��� ������ ������ ����
            System.out.println(Igor.getAccount().getCards().get(i));
        }

        int index = scanner.nextInt();
        int index2 = scanner.nextInt();

        Igor.getAccount().makeTransaction(TransactionType.DEPOSIT, Igor.getAccount().getCards().get(index-1), 1000); //TODO �� ID ����� �������� �����
        Igor.getAccount().makeTransaction(TransactionType.TRANSFER, Igor.getAccount().getCards().get(index - 1), Igor.getAccount().getCards().get(index2 - 1), 1000);


        for (int i = 0; i < Igor.getAccount().getCards().get(0).getTransactionLog().size(); i++) {
            System.out.println(Igor.getAccount().getCards().get(0).getTransactionLog().get(i));
        }
        */
    }
}
