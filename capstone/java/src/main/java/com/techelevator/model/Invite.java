package com.techelevator.model;

public class Invite {

    private int inviteId;
    private int tournamentId;
    private int senderId;
    private int receiverId;
    private String status;

    public Invite() { }

    public Invite(int inviteId, int tournamentId, int senderId, int receiverId, String status) {
        this.inviteId = inviteId;
        this.tournamentId = tournamentId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.status = status;
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

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
