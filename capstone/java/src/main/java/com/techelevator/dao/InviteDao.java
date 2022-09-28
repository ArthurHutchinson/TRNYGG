package com.techelevator.dao;

import com.techelevator.model.Invite;

import java.util.List;

public interface InviteDao {

    List<Invite> findAllInvites ();

    List<Invite> getInvitesById (int userId);

    List<Invite> getPendingInvitesById (int userId);

    List<Invite> getInvitesByTournamentId (int tournamentId);

    int createInvite (Invite invite);

    Invite getInviteByInviteId(int inviteId);

    boolean updateInvite (String status, int id);
}
