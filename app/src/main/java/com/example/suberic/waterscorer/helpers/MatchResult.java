package com.example.suberic.waterscorer.helpers;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class MatchResult {
    private int scoreTeamA;
    private int scoreTeamB;
    private int foulsTeamA;
    private int foulsTeamB;

    private ArrayList<Integer> scoreList;
    private ArrayList<Integer> foulList;

    public MatchResult() {
        scoreList = new ArrayList<>();
        scoreList = new ArrayList<>();
    }

    public void teamScored(int team){
        scoreList.add(team);
    }

    public void teamFoul(int team){
        foulList.add(team);
    }

    public void playerScored(int player){
        scoreList.add(player);
    }
    public void playerFoul(int player){
        foulList.add(player);
    }

    public void removeGoalTeam(int team) {
        for(ListIterator<Integer> iterator = scoreList.listIterator(scoreList.size()); iterator.hasPrevious();){
            Log.d("Element", iterator.previous()+"");
        }
    }

}
