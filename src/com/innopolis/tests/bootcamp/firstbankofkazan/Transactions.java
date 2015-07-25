package com.innopolis.tests.bootcamp.firstbankofkazan;


import com.innopolis.tests.bootcamp.firstbankofkazan.exceptions.BalanceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transactions {

    private enum TransactionType {
        WITHDRAWAL, DEPOSIT, TRANSFER, INTEREST;
    }

    private int id1, id2;
    private TransactionType type;
    private Cards card1, card2;
    private double money;
    private String dateOfTransaction;
    private static SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss dd.MM.yyyy");

    private Transactions(TransactionType type, Cards card1, double money, int id) {
        this.type = type;
        this.card1 = card1;
        this.money = money;
        this.id1 = id;
        dateOfTransaction = formatter.format(new Date());
        Date date = Transactions.getDate(dateOfTransaction);
        card1.recordDailyBalance(date, money);
    }

    private Transactions(TransactionType type, Cards card1, Cards card2, double money, int id1, int id2) {
        this.type = type;
        this.card1 = card1;
        this.card2 = card2;
        this.money = money;
        this.id1 = id1;
        this.id2 = id2;
        dateOfTransaction = formatter.format(new Date());
        Date date = Transactions.getDate(dateOfTransaction);
        card1.recordDailyBalance(date, money);
        card2.recordDailyBalance(date, money);
    }

    protected static void withdrawal(double money, Cards card1, int id) throws BalanceException {
        if (card1.getMoney() < money) throw new BalanceException("������������ ������� ��� ���������� ������ ��������");
        Transactions transaction = new Transactions(TransactionType.WITHDRAWAL, card1, money, id);
        card1.getTransactionLog().add(transaction);
        card1.setMoney(card1.getMoney() - money);
    }

    protected static void deposit(double money, Cards card1, int id) {
        Transactions transaction = new Transactions(TransactionType.DEPOSIT, card1, money, id);
        card1.getTransactionLog().add(transaction);
        card1.setMoney(card1.getMoney()+money);
    }

    protected static void transfer(double money, Cards card1, Cards card2, int id1, int id2) throws BalanceException {
        if (card1.getMoney() < money) throw new BalanceException("������������ ������� ��� ���������� ������ ��������");
        Transactions transaction = new Transactions(TransactionType.TRANSFER, card1, card2, money, id1, id2); //TODO ��� ��� ���� ���� ����
        card1.getTransactionLog().add(transaction);
        card2.getTransactionLog().add(transaction);
        card1.setMoney(card1.getMoney() - money);
        card2.setMoney(card1.getMoney() + money);
    }

    protected static void interest(Cards card1, double money, int id) {
        Transactions transactions = new Transactions(TransactionType.INTEREST, card1, money, id);
        card1.getTransactionLog().add(transactions);
        card1.setMoney(card1.getMoney() + money);
    }

    private static Date getDate(String dateString) {
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public String toString() { //TODO ������� ����� ������ ����� if �� �����
        switch (type) {
            case TRANSFER: return "���������� � " + String.format("%03d", id1) +
                                    ", ����:" + dateOfTransaction +
                                    ", ���:" + type +
                                    ", ����� � 1: " + card1.getCardId() +
                                    ", ����� � 2: " + card2.getCardId() +
                                    ", �����: " + money;
            case DEPOSIT: return "���������� � " + String.format("%03d", id1) +
                                    ", ����:" + dateOfTransaction +
                                    ", ���:" + type +
                                    ", ����� � : " + card1.getCardId() +
                                    ", �����: " + money;
            case WITHDRAWAL: return "���������� � " + String.format("%03d", id1) +
                                    ", ����:" + dateOfTransaction +
                                    ", ���:" + type +
                                    ", ����� � : " + card1.getCardId() +
                                    ", �����: " + money;
            default: return "���������� � " + String.format("%03d", id1) +
                                    ", ����:" + dateOfTransaction +
                                    ", ���:" + type +
                                    ", ����� � : " + card1.getCardId() +
                                    ", �����: " + money;
        }
    }
}
