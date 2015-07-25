package com.innopolis.tests.tasksB4Camp.bootcampQ2;

import java.util.ArrayList;

public class Fights {

    public static void fightOfPlayers(ArrayList<Players> playersArray, int player1, int player2) {
        int count1=0, count2=0;
        String player1step, player2step;

        while (count1 < 2 | count2 < 2) {
            while (true) {
                int rand1 = (int) (Math.random() * 4);
                int rand2 = (int) (Math.random() * 4);
                player1step = GameMainClass.KNB_Array[playersArray.get(player1).getTactic()[rand1]];
                player2step = GameMainClass.KNB_Array[playersArray.get(player1).getTactic()[rand2]];
                if (!player1step.equals(player2step)) break;
            }
            if (compare(player1step, player2step)) {
                count1++;
            } else {
                count2++;
            }
        }
        System.out.print(playersArray.get(player1).getName() + " vs " + playersArray.get(player2).getName() + " - ");
        if (count1 == 2) {
            System.out.println("победил " + playersArray.get(player1).getName() + "!");
            playersArray.remove(player2);
        }
        else {
            System.out.println("победил " + playersArray.get(player2).getName() + "!");
            playersArray.remove(player1);
        }
    }

    public static boolean compare(String player1Move, String player2Move) {

        if (player1Move.equals("Камень") & player2Move.equals("Ножницы")) return true;
        if (player1Move.equals("Камень") & player2Move.equals("Бумага")) return false;

        if (player1Move.equals("Ножницы") & player2Move.equals("Бумага")) return true;
        if (player1Move.equals("Ножницы") & player2Move.equals("Камень")) return false;

        if (player1Move.equals("Бумага") & player2Move.equals("Камень")) return true;
        if (player1Move.equals("Бумага") & player2Move.equals("Ножницы")) return false;

        return true;
    }

}
