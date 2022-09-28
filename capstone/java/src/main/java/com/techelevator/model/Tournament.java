package com.techelevator.model;

import java.util.Date;

public class Tournament {

private int tournamentId;
private int organizerId;
private String organizerName;
private String tournamentName;
private int numOfParticipants;
private Date fromDate;
private Date toDate;
private String tournamentType;
private String imgUrl;
private String game;

    public Tournament() {}

    public Tournament(int tournamentId, int organizerId, String organizerName, String tournamentName, int numOfParticipants, Date fromDate, Date toDate, String tournamentType, String imgUrl, String game) {
        this.tournamentId = tournamentId;
        this.organizerId = organizerId;
        this.organizerName = organizerName;
        this.tournamentName = tournamentName;
        this.numOfParticipants = numOfParticipants;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.tournamentType = tournamentType;
        this.imgUrl = imgUrl;
        this.game = game;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    public void setNumOfParticipants(int numOfParticipants) {
        this.numOfParticipants = numOfParticipants;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getTournamentType() {
        return tournamentType;
    }

    public void setTournamentType(String tournamentType) {
        this.tournamentType = tournamentType;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "tournamentId=" + tournamentId +
                ", organizerId=" + organizerId +
                ", tournamentName='" + tournamentName + '\'' +
                ", numOfParticipants=" + numOfParticipants +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", tournamentType='" + tournamentType + '\'' +
                '}';
    }
}
