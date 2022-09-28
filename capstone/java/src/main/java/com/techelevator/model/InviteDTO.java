package com.techelevator.model;

public class InviteDTO {
    private int inviteId;
    private String status;

    public InviteDTO(int inviteId, String status) {
        this.inviteId = inviteId;
        this.status = status;
    }

    public int getInviteId() {
        return inviteId;
    }

    public void setInviteId(int inviteId) {
        this.inviteId = inviteId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
