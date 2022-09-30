package com.techelevator.model;

public class Match {
    private int matchId;
    private int tournamentId;
    private String homePlayer;
    private String awayPlayer;
    private String winner;
    private int round;

    public Match() { }

    public Match(int matchId, int tournamentId, String homePlayer, String awayPlayer, String winner, int round) {
        this.matchId = matchId;
        this.tournamentId = tournamentId;
        this.homePlayer = homePlayer;
        this.awayPlayer = awayPlayer;
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

    public String getHomePlayer() {
        return homePlayer;
    }

    public void setHomePlayer(String homePlayer) {
        this.homePlayer = homePlayer;
    }

    public String getAwayPlayer() {
        return awayPlayer;
    }

    public void setAwayPlayer(String awayPlayer) {
        this.awayPlayer = awayPlayer;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
