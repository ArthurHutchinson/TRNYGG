package com.techelevator.dao;

import com.techelevator.model.Invite;

import java.util.List;

public interface InviteDao {

    List<Invite> findAllInvites ();

    List<Invite> getInvitesById (int userId);

    List<Invite> getPendingInvitesById (int userId);

    List<Invite> getInvitesByTournamentId (int tournamentId);

    boolean createInvite (Invite invite);
}
