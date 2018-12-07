package com.example.suberic.waterscorer.helpers;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
    When score teamA add to list 1
    When score teamB add to list 2
    When score teamA player add to list plNumber * 2 + 1
    When score teamB player add to list plNumber * 2 + 2

 */
public class MatchResult implements Serializable {
    private int scoreTeamA;
    private int scoreTeamB;
    private int foulsTeamA;
    private int foulsTeamB;

    private ArrayList<Integer> scoreList;
    private ArrayList<Integer> foulList;

    public MatchResult() {
        scoreList = new ArrayList<>();
        foulList = new ArrayList<>();
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
            int temp =  iterator.previous();
            if(Utils.isEven(temp + team)){
                Log.d("iterator", "removing element " + temp);
                iterator.remove();
                break;
            }
        }
    }
    public void removeFoulTeam(int team) {
        for(ListIterator<Integer> iterator = foulList.listIterator(foulList.size()); iterator.hasPrevious();){
            int temp =  iterator.previous();
            if(Utils.isEven(temp + team)){
                Log.d("iterator", "removing element " + temp);
                iterator.remove();
                break;
            }
        }
    }

    public ArrayList<Integer> getScoreList() {
        return scoreList;
    }
    public ArrayList<Integer> getFoulList() {
        return foulList;
    }


    private int getScore(int team) {
        int score = 0;

        for (Integer i : scoreList) {
            score += (Utils.isEven(i + team) ? 1 : 0);
        }
        return score;
    }

    public int getScoreTeamA() {
        return getScore(1);
    }
    public int getScoreTeamB() {
        return getScore(2);
    }

    private int getFouls(int team) {
        int score = 0;

        for (Integer i : foulList) {

            score += (Utils.isEven(i + team) ? 1 : 0);
        }
        return score;
    }

    public int getFoulsTeamA() {
        return getFouls(1);
    }
    public int getFoulsTeamB() {
        return getFouls(2);
    }


}
