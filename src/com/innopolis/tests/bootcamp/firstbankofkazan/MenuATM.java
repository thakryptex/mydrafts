package com.innopolis.tests.bootcamp.firstbankofkazan;

import com.innopolis.tests.bootcamp.firstbankofkazan.enums.Sex;

import java.util.Scanner;

public class MenuATM {

    public static People menuCreatePeople() {
        Scanner scanner = new Scanner(System.in);
        People people = new People();

        System.out.println("Введите свои фамилию имя отчество");
        people.setSecondName(scanner.next());
        people.setFirstName(scanner.next());
        people.setPatronym(scanner.next());

        System.out.println("Пожалуйста, укажите свой пол:");
        while (true) {
            String t = scanner.nextLine().toUpperCase();
            if (t.equals("MALE") || t.equals("M") || t.equals("М") || t.equals("МУЖСКОЙ")) {
                people.setSex(Sex.MALE);
                break;
            }
            else if (t.equals("FEMALE") || t.equals("F") || t.equals("Ж") || t.equals("ЖЕНСКИЙ")) {
                people.setSex(Sex.FEMALE);
                break;
            }
            else {
                System.out.println("Укажите пол корректно");
            }
        }

        System.out.println("Укажите дату рождения (формат: 01.03.1980):");
        while (true) {
            try {
                people.setDateOfBirth(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Вы ввели дату в неправильном формате. Введите, пожалуйста, в этом формате: 01.03.1980, где 01 - это день, 03 - это месяц, а 1980 - год рождения");
            }
        }

        System.out.println("Последний пункт - укажите номер паспорта:");
        while (true) {
            try {
                people.setPassportNum(scanner.nextLong());
                break;
            } catch (Exception e) {
                System.out.println("Вы ввели неверный номер паспорта (слишком много цифр), попробуйте ещё раз...");
            }
        }

        return people;
    }

}
