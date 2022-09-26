package com.techelevator.model;

public class Match {
    private int matchId;
    private int tournamentId;
    private String homeId;
    private String awayId;
    private String winner;

    public Match(int matchId, int tournamentId, String homeId, String awayId, String winner) {
        this.matchId = matchId;
        this.tournamentId = tournamentId;
        this.homeId = homeId;
        this.awayId = awayId;
        this.winner = winner;
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

    public String getHomeId() {
        return homeId;
    }

    public void setHomeId(String homeId) {
        this.homeId = homeId;
    }

    public String getAwayId() {
        return awayId;
    }

    public void setAwayId(String awayId) {
        this.awayId = awayId;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
