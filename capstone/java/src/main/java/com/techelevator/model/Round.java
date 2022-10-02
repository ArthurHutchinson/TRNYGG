package com.techelevator.model;

import java.util.List;

public class Round {
    private List<Match> matches;
    private int roundNumber;

    public Round(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
