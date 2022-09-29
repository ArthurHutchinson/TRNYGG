package com.techelevator.model;

import java.util.List;

public class StartRoundDTO {

    private List<UserDTO> winnerList;
    private int round;

    public StartRoundDTO(List<UserDTO> winnerList, int round) {
        this.winnerList = winnerList;
        this.round = round;
    }

    public List<UserDTO> getWinnerList() {
        return winnerList;
    }

    public void setWinnerList(List<UserDTO> winnerList) {
        this.winnerList = winnerList;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
