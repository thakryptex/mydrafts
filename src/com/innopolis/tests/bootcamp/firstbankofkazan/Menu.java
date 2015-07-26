package com.innopolis.tests.bootcamp.firstbankofkazan;

import com.innopolis.tests.bootcamp.firstbankofkazan.enums.CardType;
import com.innopolis.tests.bootcamp.firstbankofkazan.enums.Sex;
import com.innopolis.tests.bootcamp.firstbankofkazan.enums.TransactionType;

import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private static String t;
    private static int i, j;

    public static People menuCreatePeople() {
        People people = new People();
        System.out.println();

        System.out.println("������� ���� ������� ��� ��������");
        people.setSecondName(scanner.next());
        people.setFirstName(scanner.next());
        people.setPatronym(scanner.nextLine().replace(" ", ""));
        System.out.println();

        System.out.println("����������, ������� ���� ���:");
        do {
            t = scanner.nextLine().toUpperCase();
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

    public static void menuCards(Accounts account) {
        System.out.println();
        if (account.getCards().size() == 0) {
            System.out.println("�������� ���� �� �����:");
            System.out.println("1 - ������ ������ � ����� ������ � ��������");
            System.out.println("2 - ������� ����");
            while (true) {
                i = scanner.nextInt();
                if (i == 1) {
                    menuInfoCardTypes(account);
                    break;
                } else if (i == 2) {
                    menuCreateCard(account);
                    break;
                } else System.out.println("����� ��� �������� ���� ������� ���. �������� 1 ��� 2.");
            }
        } else {
            menuShowCardsList(account);
            System.out.println();
            System.out.println("������� ���������� � �����, � ������� ������ ��������:");
            while (true) {
                i = scanner.nextInt();
                if (i < 1 || i > account.getCards().size()) {
                    System.out.println("����� ������������ �����. ���������� ��� ���.");
                } else break;
            }
            System.out.println();
            System.out.println(account.getCards().get(i - 1));
            System.out.println();
            while (true) {
                System.out.println("�������� �����:");
                System.out.println("1 - ��������� ����������");
                System.out.println("2 - ������� ������ ����������");
                j = scanner.nextInt();
                if (j == 1) {
                    menuChooseTransaction(account.getCards().get(i - 1));
                    break;
                } else if (j == 2) {
                    menuPrintCardTransactions(account.getCards().get(i - 1));
                    break;
                } else
                    System.out.println("����� ��� �������� ���� ������� ���. �������� 1 ��� 2.");
            }
        }
    }

    private static void menuChooseTransaction(Cards card) {
        System.out.println();
        while (true) {
            System.out.println("������ ���� ���������� �� ������ ���������:");
            System.out.println("1 - �������� ������ �� ����");
            System.out.println("2 - ����� ������ �� �����");
            System.out.println("3 - ��������� ������");
            i = scanner.nextInt();
            if (i == 1) {
                menuMakeTransaction(card, TransactionType.DEPOSIT);
                break;
            } else if (i == 2) {
                menuMakeTransaction(card, TransactionType.WITHDRAWAL);
                break;
            } else if (i == 3) {
                menuMakeTransaction(card, TransactionType.TRANSFER);
                break;
            } else
                System.out.println("����� ��� �������� ���� ������� ���. �������� 1, 2 ��� 3.");
        }
    }

    private static void menuMakeTransaction(Cards card, TransactionType type) {
        System.out.println();
        while (true) {
            System.out.println("������� ����� ����������:");
            i = scanner.nextInt();
            if (i < 0) System.out.println("����� �� ����� ���� ������ ����. ������� ������ �����.");
            else break;
        }
        switch (type) {
            case DEPOSIT:
                card.getAccount().makeTransaction(type, card, i);
                break;
            case WITHDRAWAL:
                card.getAccount().makeTransaction(type, card, i);
                break;
            case TRANSFER:
                while (true) {
                    System.out.println("�������� ���������� � �����, �� ������� �� ������ ��������� ��������:");
                    menuShowCardsList(card.getAccount());
                    j = scanner.nextInt();
                    if (j < 1 || j > card.getAccount().getCards().size()) {
                        System.out.println("������ ������������ �����. ���������� ��� ���.");
                    }
                    else break;
                }
                card.getAccount().makeTransaction(type, card, card.getAccount().getCards().get(j - 1), i);
                break;
        }
    }

    private static void menuPrintCardTransactions(Cards cards) {
        System.out.println();
        System.out.println("���������� ����� " + cards.getCardId() + ":");
        for (int k = 0; k < cards.getTransactionLog().size(); k++) {
            cards.getTransactionLog().get(i);
        }
    }

    private static void menuShowCardsList(Accounts account) {
        System.out.println();
        for (int k = 0; k < account.getCards().size(); k++) {
            System.out.println(account.getCards().get(k));
        }
    }

    private static void menuInfoCardTypes(Accounts account) {
        System.out.println();
        System.out.println("��� ���� ���������� ��� 3 ���� ������:");
        System.out.println("1) Chequing: ����������� ��������� ����� - 1000 �., ����������� ����� - 1000 �./���.");
        System.out.println("2) Savings: ����������� ��������� ����� - 50000 �., ����������� ����� - 5% � ���.");
        System.out.println("3) Business: ����������� ��������� ����� - 5000000 �., ����������� ����� - 1% � ���.");
        System.out.println();
        System.out.println("������ ������� ���� ��� ������ �����?");
        System.out.println("1 - ������� ����");
        System.out.println("2 - ��������� ������������");
        while (true) {
            i = scanner.nextInt();
            if (i == 1) {
                menuCreateCard(account);
            } else if (i == 2) {
                System.exit(0);
            } else System.out.println("����� ��� �������� ���� ������� ���. �������� 1 ��� 2.");
        }
    }

    private static void menuCreateCard(Accounts account) {
        System.out.println();
        System.out.println("��� �������� ����� ���������� ������� ���� �� ��� ����� ������ � �������� ����������� ����� �� ����.");
        System.out.println();
        while (true) {
            System.out.println("�������� ��� �����:");
            System.out.println("1 - Chequing (���. 1000 �.)");
            System.out.println("2 - Savings (���. 50000 �.)");
            System.out.println("3 - Business (���. 5000000 �.)");
            i = scanner.nextInt();
            if (!(i == 1 || i == 2 || i == 3)) {
                System.out.println("����� ��� �������� ���� ������� ���. �������� 1, 2 ��� 3.");
                System.out.println();
                continue;
            }
            System.out.println();
            System.out.println("������� �����, ������� ������ �������� �� ����:");
            j = scanner.nextInt();
            if ((i == 1 && j < 1000) || (i == 2 && j < 50000) || (i == 3 && j < 5000000)) {
                System.out.println("��������� ����� ������� ���� ��� ���������� ���� ����. ���������� ��� ���.");
                System.out.println();
                continue;
            }
            Cards card;
            switch (i) {
                case 1:
                    card = new Cards(account, j, CardType.CHEQUING);
                    break;
                case 2:
                    card = new Cards(account, j, CardType.SAVINGS);
                    break;
                case 3:
                    card = new Cards(account, j, CardType.BUSINESS);
                    break;
            }
            break;
        }
    }

    public static void menuAccountMain(Accounts account) {
        System.out.println();
        while (true) {
            System.out.println("������� ���� ��� ������� ����� ������.");
            System.out.println("�������� ���� �� �����:");
            System.out.println("1 - �������/������� ����");
            System.out.println("2 - �������� �� �������");
            System.out.println("3 - ���������� ������ ������ ��������");
            System.out.println("4 - �������� ������ ������ ���������� �� ���� ������ ��������");
            i = scanner.nextInt();
            if (i == 1) { //TODO ������� ��� ��� ��������
                System.out.println("1 - �������/������� ����");
                break;
            } else if (i == 2) {
                System.out.println("2 - �������� �� �������");
                break;
            } else if (i == 3) {
                System.out.println("3 - ���������� ������ ������ ��������");
                break;
            } else if (i == 4) {
                System.out.println("4 - �������� ������ ������ ���������� �� ���� ������ ��������");
                break;
            } else
                System.out.println("����� ��� �������� ���� ������� ���. �������� 1, 2, 3 � 4.");
        }
    }
}
