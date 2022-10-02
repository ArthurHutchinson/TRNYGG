package com.techelevator.model;

import java.util.List;

public class Bracket {
    private int tournamentId;
    private List<Round> rounds;

    public Bracket(int tournamentId, List<Round> bracket) {
        this.tournamentId = tournamentId;
        this.rounds = bracket;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}
