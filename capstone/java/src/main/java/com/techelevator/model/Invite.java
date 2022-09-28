package com.techelevator.model;

public class Invite {

    private int inviteId;
    private int tournamentId;
    private int organizerId;
    private int playerId;
    private String status;
    private String type;

    public Invite() { }

    public Invite(int inviteId, int tournamentId, int organizerId, int playerId, String status) {
        this.inviteId = inviteId;
        this.tournamentId = tournamentId;
        this.organizerId = organizerId;
        this.playerId = playerId;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getInviteId() {
        return inviteId;
    }

    public void setInviteId(int inviteId) {
        this.inviteId = inviteId;
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

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
