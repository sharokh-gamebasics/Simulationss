package com.myprojects.ali.simulation.models;

import java.util.Random;

public class Match implements java.io.Serializable{

    //constant to define maximum goals a team can score.
    private static final int MAXGOALS = 3;

    //Constant to define the amount of points a team can get when they WIN, DRAW or LOSE a game.
    private static final int WIN = 3;
    private static final int DRAW = 1;
    private static final int LOSS = 0;

    private Team homeTeam;  // The Object of the home team.
    private Team awayTeam;  // The Object of the away team.
    private int homeGoals;  // amount of goals the home team has scored.
    private int awayGoals;  //amount of goals the away team can scored.
    private boolean played; // can be true if played otherwise false.

    public Match(Team homeTeam, Team awayTeam) {

        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.played = false;

    }

    public void simulateGame() {

        //Calculate goals for teams;
        int maxHomeGoals = calculateGoals(homeTeam, awayTeam);
        int maxAwayGoals = calculateGoals(awayTeam, homeTeam);

        //Create  Random object to generate random integers
        Random random = new Random();

        //Set score for the game base on the calculated goals
        this.homeGoals = random.nextInt(maxHomeGoals);
        this.awayGoals = random.nextInt(maxAwayGoals);
        this.homeTeam.setGoalsConceded(this.awayGoals);
        this.homeTeam.setGoalsScored(this.homeGoals);
        this.awayTeam.setGoalsConceded(this.homeGoals);
        this.awayTeam.setGoalsScored(this.awayGoals);

        //Set status of the game to played.
        this.played = true;

        //Hand out points to the Team object
        this.addPointsToTeam();

    }

    private int calculateGoals(Team home, Team away) {
        //Compare the home teams attacking strength to the away teams defending strength.
        if (home.getAttackingStrength() > away.getDefendingStrength()) {
            return MAXGOALS + MAXGOALS;
        } else {
            return MAXGOALS;
        }
    }

    private void addPointsToTeam() {

        if (homeGoals > awayGoals) {
            homeTeam.setPoints(WIN);
            awayTeam.setPoints(LOSS);
        } else if (homeGoals < awayGoals) {
            homeTeam.setPoints(LOSS);
            awayTeam.setPoints(WIN);
        } else {
            homeTeam.setPoints(DRAW);
            awayTeam.setPoints(DRAW);
        }
    }

    public Team getHomeTeam() {
        return this.homeTeam;
    }


    public Team getAwayTeam() {
        return this.awayTeam;
    }

    public int getHomeGoals() {
        return this.homeGoals;
    }

    public int getAwayGoals() {
        return this.awayGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public boolean isPlayed() {
        return this.played;
    }
}
