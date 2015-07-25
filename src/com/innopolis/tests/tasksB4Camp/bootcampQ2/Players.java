package com.innopolis.tests.tasksB4Camp.bootcampQ2;

import java.util.ArrayList;

public class Players {
    private String name;
    private int[] tactic;

    public Players(String name, int[] tactic) {
        this.name = name;
        this.tactic = tactic;
    }

    public static ArrayList<Players> makePlayers(int k) {
        ArrayList<Players> tempArray = new ArrayList<Players>();
        int rand;
        Players player;

        for (int i = 0; i < Math.pow(2,k); i++) {
            rand = (int) (Math.random()*3);
            player = new Players("игрок"+(i+1), GameMainClass.ALL_Tactics[rand]);
            tempArray.add(player);
        }
        return tempArray;
    }

    public String getName() {
        return name;
    }

    public int[] getTactic() {
        return tactic;
    }

    @Override
    public String toString()
    {
        return name + ": " + GameMainClass.KNB_Array[tactic[0]];
    }
}