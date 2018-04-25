package com.myprojects.ali.simulation.models;

import java.util.ArrayList;

public class Poule {

    private ArrayList<Team> pouleTeams;
    private ArrayList<Match> pouleMatches;

    public Poule(ArrayList<Team> teams) {
        this.pouleTeams = teams;
        pouleMatches = new ArrayList<Match>();

        initPouleGames();
    }

    private void initPouleGames() {

        for (int i = 0; i < pouleTeams.size(); i++) {
            for (int ii = 0; ii < pouleTeams.size(); ii++) {
                if (ii != i && i < ii) {
                    Match pouleGame = new Match(pouleTeams.get(i), pouleTeams.get(ii));
                    this.pouleMatches.add(pouleGame);
                }
            }
        }
    }

    public void simulatePoule() {
        for (Match match : pouleMatches) {
            match.simulateGame();
        }
    }

    public void resetPoule() {
        for (Team t : pouleTeams) {
            t.resetAll();
        }
        pouleMatches.clear();
        initPouleGames();
    }

    public ArrayList<Team> sortPoule(ArrayList<Team> foundTeams) {
        ArrayList<Team> sortedTeams = new ArrayList<Team>(foundTeams);
        for (int i = 0; i < foundTeams.size(); i++) {
            for (int ii = 0; ii < foundTeams.size(); ii++) {
                //Check to see if a team has more points then a other team
                if (CheckPointDifference(foundTeams.get(i), sortedTeams.get(ii))) {
                    sortedTeams.remove(foundTeams.get(i));
                    sortedTeams.add(ii, foundTeams.get(i));
                }
            }
        }
        this.pouleTeams = sortedTeams;
        return sortedTeams;
    }

    private Boolean CheckPointDifference(Team homeTeam, Team awayTeam) {
        //check if home teams point are lesser then the away teams.
        if (homeTeam.getPoints() < awayTeam.getPoints()) {
            return true;
        }
        //Check if teamPoints are equal.
        if (homeTeam.getPoints() == awayTeam.getPoints()) {
            //Check to see which team has a better goal difference.
            return CheckGoalDifference(homeTeam, awayTeam);
        } else {
            return false;
        }
    }

    private Boolean CheckGoalDifference(Team homeTeam, Team awayTeam) {
        //Set variable for goal difference for each team.
        int homeTeamGoalDifference = homeTeam.getGoalsScored() - homeTeam.getGoalsConceded();
        int awayTeamGoalDifference = awayTeam.getGoalsScored() - awayTeam.getGoalsConceded();

        if (homeTeamGoalDifference < awayTeamGoalDifference) {
            return true;
        } else if (homeTeamGoalDifference == awayTeamGoalDifference) {
            //Check to see which team has  scored more goals.
            return CheckHomeGoalDifference(homeTeam, awayTeam);
        } else {
            return false;
        }

    }

    private boolean CheckHomeGoalDifference(Team homeTeam, Team awayTeam) {
        int homeTeamScoredGoals = homeTeam.getGoalsScored();
        int awayTeamScoredGoals = awayTeam.getGoalsScored();
        if (homeTeamScoredGoals < awayTeamScoredGoals) {
            return true;
        } else if (homeTeamScoredGoals == awayTeamScoredGoals) {
            return CheckMutualResult(homeTeam, awayTeam);
        } else {
            return false;
        }
    }

    private Boolean CheckMutualResult(Team homeTeam, Team awayTeam) {
        //loop through the poule games to get the mutual game.
        for (Match pouleGame : pouleMatches) {
            if (pouleGame.getHomeTeam().equals(homeTeam) && pouleGame.getAwayTeam().equals(awayTeam)) {
                if (pouleGame.getHomeGoals() < pouleGame.getAwayGoals()) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public ArrayList<Team> getPouleTeams() {
        return pouleTeams;
    }

    public ArrayList<Match> getPouleMatches() {
        return pouleMatches;
    }

}
