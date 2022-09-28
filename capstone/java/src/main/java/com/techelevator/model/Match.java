package com.techelevator.model;

public class Match {
    private int matchId;
    private int tournamentId;
    private int homeId;
    private int awayId;
    private String winner;
    private int round;

    public Match() { }

    public Match(int matchId, int tournamentId, int homeId, int awayId, String winner, int round) {
        this.matchId = matchId;
        this.tournamentId = tournamentId;
        this.homeId = homeId;
        this.awayId = awayId;
        this.winner = winner;
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public int getAwayId() {
        return awayId;
    }

    public void setAwayId(int awayId) {
        this.awayId = awayId;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
