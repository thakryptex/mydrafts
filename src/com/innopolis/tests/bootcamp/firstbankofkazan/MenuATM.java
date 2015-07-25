package com.innopolis.tests.bootcamp.firstbankofkazan;

import com.innopolis.tests.bootcamp.firstbankofkazan.enums.Sex;

import java.util.Scanner;

public class MenuATM {

    public static People menuCreatePeople() {
        Scanner scanner = new Scanner(System.in);
        People people = new People();

        System.out.println("������� ���� ������� ��� ��������");
        people.setSecondName(scanner.next());
        people.setFirstName(scanner.next());
        people.setPatronym(scanner.next());

        System.out.println("����������, ������� ���� ���:");
        while (true) {
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

        System.out.println("������� ���� �������� (������: 01.03.1980):");
        while (true) {
            try {
                people.setDateOfBirth(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("�� ����� ���� � ������������ �������. �������, ����������, � ���� �������: 01.03.1980, ��� 01 - ��� ����, 03 - ��� �����, � 1980 - ��� ��������");
            }
        }

        System.out.println("��������� ����� - ������� ����� ��������:");
        while (true) {
            try {
                people.setPassportNum(scanner.nextLong());
                break;
            } catch (Exception e) {
                System.out.println("�� ����� �������� ����� �������� (������� ����� ����), ���������� ��� ���...");
            }
        }

        return people;
    }

}
