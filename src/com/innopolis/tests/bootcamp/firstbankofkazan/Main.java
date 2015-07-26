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

import com.innopolis.tests.bootcamp.firstbankofkazan.enums.TransactionType;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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

        if (people.getAccount().getCards().size() > 0) {
            Cards card = people.getAccount().getCards().get(0);
            System.out.println("����� 4 ���������� � ������...");
            people.getAccount().makeTransaction(TransactionType.DEPOSIT, card, 666);
            people.getAccount().makeTransaction(TransactionType.WITHDRAWAL, card, 333);
            people.getAccount().makeTransaction(TransactionType.DEPOSIT, card, 999);
            people.getAccount().makeTransaction(TransactionType.WITHDRAWAL, card, 777);

            System.out.println();
            System.out.println("����� ���� �������� ��� �������� �� �����.");
            Bank.payInterest(card);

            System.out.println();
            System.out.println("���� ���� ���������� �� �����:");
            for (int j = 0; j < card.getTransactionLog().size(); j++) {
                card.getTransactionLog().get(i);
            }

            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter("transactions.txt");
                for (int j = 0; j < card.getTransactionLog().size(); j++) {
                    fileWriter.write(card.getTransactionLog().get(i).toString());
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //TODO ����� � txt-����
        }


    }
}
