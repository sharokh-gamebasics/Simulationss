package com.myprojects.ali.simulation.models;

public class Team {

    private String teamName;
    private int attackingStrength;
    private int defendingStrength;
    private int goalsScored;
    private int goalsConceded;
    private int points;

    public Team(String teamName, int attackingStrength, int defendingStrength) {
        this.teamName = teamName;
        this.attackingStrength = attackingStrength;
        this.defendingStrength = defendingStrength;
        this.points = 0;
        this.goalsConceded = 0;
        this.goalsScored = 0;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public int getAttackingStrength() {
        return this.attackingStrength;
    }

    public int getDefendingStrength() {
        return this.defendingStrength;
    }

    public int getGoalsScored() {
        return this.goalsScored;
    }

    public int getGoalsConceded() {
        return this.goalsConceded;
    }

    public int getPoints() {
        return this.points;
    }

    public void setGoalsScored(int goals) {
        this.goalsScored += goals;
    }

    public void setGoalsConceded(int goals) {
        this.goalsConceded += goals;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public void resetAll() {
        this.goalsScored = 0;
        this.goalsConceded = 0;
        this.points = 0;
    }
}
