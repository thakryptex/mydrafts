package com.innopolis.tests.bootcamp.firstbankofkazan;

import com.innopolis.tests.bootcamp.firstbankofkazan.enums.TransactionType;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Загрузка ATM...");
        System.out.println();
        System.out.println("Добро пожаловать в Первый Банк Казани!");
        System.out.println();
        System.out.println("Для работы с АТМ Вам необходимо открыть свой аккаунт в нашем Банке.");
        System.out.println("Для этого Вам потребуется ввести следующие данные:");
        System.out.println("Фамилия Имя Отчество, Дата рождения, Пол, Номер паспорта.");
        System.out.println();
        System.out.println("Вы хотите продолжить?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");

        int i;
        while (true) {
            i = scanner.nextInt();
            if (i == 1 || i == 2) break;
            else {
                System.out.println("Вам необходимо ввести либо 1 = Да, либо 2 = Нет. Попробуйте ещё раз:");
            }
        }
        if (i == 2) {
            System.out.println("Без личных данных мы не можем открыть Вам аккаунт в нашем Банке. Всего Вам доброго!");
            System.exit(0);
        }

        People people = Menu.menuCreatePeople();

        System.out.println("Ваши данные:");
        System.out.println(people);
        System.out.println();

        System.out.println("Вы успешно прошли регистрацию аккаунта в Первом Банке Казани.");
        System.out.println("Теперь Вы можете открывать счета в нашем Банке, хранить на них деньги и получать за это проценты.");

        Menu.menuCards(people.getAccount());

        Menu.menuAccountMain(people.getAccount());
        System.out.println();

        if (people.getAccount().getCards().size() > 0) {
            Cards card = people.getAccount().getCards().get(0);
            System.out.println("Введём 4 транзакции с картой...");
            people.getAccount().makeTransaction(TransactionType.DEPOSIT, card, 666);
            Thread.sleep(1000);
            people.getAccount().makeTransaction(TransactionType.WITHDRAWAL, card, 333);
            Thread.sleep(1000);
            people.getAccount().makeTransaction(TransactionType.DEPOSIT, card, 999);
            Thread.sleep(1000);
            people.getAccount().makeTransaction(TransactionType.WITHDRAWAL, card, 777);

            System.out.println();
            System.out.println("Пусть Банк выплатит Вам проценты за месяц...");
            Bank.payInterest(card);

            Menu.menuSaveTransactionLogsIntoTxt(card);

            System.out.println();
            System.out.println("Спасибо за использование услуг Первого Банка Казани. Всего доброго!");
        }


    }
}
