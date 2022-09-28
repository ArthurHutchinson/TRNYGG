package com.techelevator.model;

public class WinnerDTO {
    private String winnerUsername;

    public WinnerDTO(String winnerUsername) {
        this.winnerUsername = winnerUsername;
    }

    public String getWinnerUsername() {
        return winnerUsername;
    }

    public void setWinnerUsername(String winnerUsername) {
        this.winnerUsername = winnerUsername;
    }
}
