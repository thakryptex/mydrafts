package com.innopolis.tests.tasksB4Camp.bootcampQ2;

//Разработайте программу, моделирующую турнир плей-офф “камень, ножницы, бумага” среди 2^K игроков,
// где K - количество раундов, задается пользователем.
//?	Перед турнирном каждому игроку присваивается номер от 1 до 2^K и случайная тактика с равной вероятностью:
// “ножницы”, “камень” или “бумага”, где игрок с тактикой, например, “ножницы” показывает ножницы с вероятностью - 0,5,
// камень - 0,25, бумага - 0,25. В остальных тактиках распределение вероятностей аналогично.
//?	В каждом раунде происходят поединки между игроками до 2-х побед.
//?	Победитель поединка определяется по следующим правилам:
//    ?	Камень побеждает ножницы («камень затупляет или ломает ножницы»)
//    ?	Ножницы побеждают бумагу («ножницы разрезают бумагу»)
//    ?	Бумага побеждает камень («бумага накрывает камень»)
//?	Если игроки показали одинаковый знак, то игра переигрывается.
//?	Результаты раундов выводятся на экран.
//
//        Пример:
//        Входные данные:
//        3
//
//        Выходные данные:
//        игрок1: ножницы
//        игрок2: бумага
//        игрок3: бумага
//        игрок4: камень
//        игрок5: ножницы
//        игрок6: бумага
//        игрок7: бумага
//        игрок8: камень
//
//        Раунд 1:
//        игрок1 vs игрок2 - победил игрок1!
//        игрок3 vs игрок4 - победил игрок4!
//        игрок5 vs игрок6 - победил игрок5!
//        игрок7 vs игрок8 - победил игрок8!
//
//        Раунд 2:
//        игрок1 vs игрок4 - победил игрок1!
//        игрок5 vs игрок8 - победил игрок5!
//
//        Финал:
//        игрок1 vs игрок5 - победил игрок5!


import java.util.ArrayList;
import java.util.Scanner;

public class GameMainClass {

    public final static String[] KNB_Array = {"Камень", "Ножницы", "Бумага"};
    public final static int[] K_Tactic = {0, 0, 1, 2}; // 0 - это камень   >
    public final static int[] N_Tactic = {1, 1, 0, 2}; // 1 - это ножницы  > это реализация вероятности 50/25/25
    public final static int[] B_Tactic = {2, 2, 0, 1}; // 2 - это бумага   >
    public final static int[] ALL_Tactics[] = {K_Tactic, N_Tactic, B_Tactic};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число раундов К:");
        int k = scanner.nextInt();

        ArrayList<Players> playersList = new ArrayList<Players>(Players.makePlayers(k));

        System.out.println();
        System.out.println("Список игроков и тактика:");
        for (int i = 0; i < playersList.size(); i++)
        {
            System.out.println(playersList.get(i));
        }

        System.out.println();

        for (int i = 1; i <= k; i++) {
            if (i < k) {
                System.out.println("Раунд " + i + ":");
                for (int j = 0; j < playersList.size(); j++) {
                    Fights.fightOfPlayers(playersList, j, j+1);
                }
                System.out.println();
            } else {
                System.out.println("Финал:");
                for (int j = 0; j < playersList.size(); j++) {
                    Fights.fightOfPlayers(playersList, j, j + 1);
                }
            }
        }
    }
}
