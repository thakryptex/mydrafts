package com.innopolis.tests.bootcamp.firstbankofkazan;


import com.innopolis.tests.bootcamp.firstbankofkazan.enums.CardType;
import com.innopolis.tests.bootcamp.firstbankofkazan.enums.TransactionType;
import com.innopolis.tests.bootcamp.firstbankofkazan.exceptions.BalanceException;
import com.innopolis.tests.bootcamp.firstbankofkazan.exceptions.TooManyTransactionsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Accounts {
    private static final int CHEQUING_MIN = 1000;
    private static final int SAVINGS_MIN = 50000;
    private static final int BUSINESS_MIN = 5000000;

    private int accountId;
    private People people;
    private List<Cards> cards = new ArrayList<>();

    public Accounts(People people) {
        this.people = people;
        accountId = (int) (Math.random() * 1000000);
    }

    public void createCard(double money, CardType type) {
        try {
            switch (type) {
                case CHEQUING:
                    if (money < CHEQUING_MIN) throw new BalanceException("Недостаточно средств для открытия счёта");
                    break;
                case SAVINGS:
                    if (money < SAVINGS_MIN) throw new BalanceException("Недостаточно средств для открытия счёта");
                    break;
                case BUSINESS:
                    if (money < BUSINESS_MIN) throw new BalanceException("Недостаточно средств для открытия счёта");
                    break;
            }
        } catch (BalanceException e) {
            System.out.println(e.getMessage());
            return;
        }
        Cards card = new Cards(people.getAccount(), money, type);
        cards.add(card);
        System.out.println(card);
    }

    public void closeCard() {
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(cards.get(i));
        }
        System.out.println("Введите id карты, которую Вы хотите закрыть:");
        Scanner scanner = new Scanner(System.in);
        int cardId = scanner.nextInt();

        cards.remove(cardId);
    }

    public void makeTransaction(TransactionType type, Cards card, double money) {
        try {
            if (card.getTransactionLog().size() >= 100) {
                throw new TooManyTransactionsException("Вы израсходовали лимит транзакций за этот месяц. Пожалуйста, дождитесь следующего месяца.");
            }
            switch (type) {
                case DEPOSIT:
                    Transactions.deposit(money, card, card.getTransactionLog().size());
                    break;
                case WITHDRAWAL:
                    Transactions.withdrawal(money, card, card.getTransactionLog().size());
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void makeTransaction(TransactionType type, Cards card1, Cards card2, double money) {
        try {
            if (card1.getTransactionLog().size() >= 100) throw new TooManyTransactionsException("Вы израсходовали лимит транзакций за этот месяц. Пожалуйста, дождитесь следующего месяца.");
            Transactions.transfer(money, card1, card2, card1.getTransactionLog().size(), card2.getTransactionLog().size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Cards> getCards() {
        return cards;
    }

    public int getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "аккаунт № " + accountId;
    }
}