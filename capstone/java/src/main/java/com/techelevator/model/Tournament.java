package com.techelevator.model;

import java.util.Date;

public class Tournament {

private int tournamentId;
private int organizerId;
private String tournamentName;
private int numOfParticipants;
private Date fromDate;
private Date toDate;
private String tournamentType;

    public Tournament(int tournamentId, int organizerId, String tournamentName, int numOfParticipants, Date fromDate, Date toDate, String tournamentType) {
        this.tournamentId = tournamentId;
        this.organizerId = organizerId;
        this.tournamentName = tournamentName;
        this.numOfParticipants = numOfParticipants;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.tournamentType = tournamentType;
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
