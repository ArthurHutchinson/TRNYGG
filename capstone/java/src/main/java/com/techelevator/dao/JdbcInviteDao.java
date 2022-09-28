package com.techelevator.dao;

import com.techelevator.model.Invite;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInviteDao implements InviteDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcInviteDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Invite> findAllInvites() {
        List<Invite> invites = new ArrayList<>();
        String sql = "SELECT * FROM invites";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Invite invite = mapRowToInvite(results);
            invites.add(invite);
        }
        return invites;
    }

    @Override
    public List<Invite> getInvitesById(int userId) {
        List<Invite> invites = new ArrayList<>();
        String sql = "SELECT * FROM invites WHERE sender_id = ? OR receiver_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, userId);
        while (results.next()) {
            Invite invite = mapRowToInvite(results);
            invites.add(invite);
        }
        return invites;
    }

    @Override
    public List<Invite> getPendingInvitesById(int userId) {
        List<Invite> invites = new ArrayList<>();
        String sql = "SELECT * FROM invites WHERE sender_id = ? OR receiver_id = ? AND status = pending";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, userId);
        while (results.next()) {
            Invite invite = mapRowToInvite(results);
            invites.add(invite);
        }
        return invites;
    }

    @Override
    public Invite getInviteByInviteId(int Id){
        Invite invite = null;
        String sql = "SELECT * FROM invites WHERE invite_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, Id);
        if(results.next()) {
            invite = mapRowToInvite(results);
        }
        return invite;
    }

    @Override
    public List<Invite> getInvitesByTournamentId(int tournamentId) {
        List<Invite> invites = new ArrayList<>();
        String sql = "SELECT * FROM invites WHERE tournament_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tournamentId);
        while (results.next()) {
            Invite invite = mapRowToInvite(results);
            invites.add(invite);
        }
        return invites;
    }

    @Override
    public int createInvite(Invite invite, String string) {
        String sql = "INSERT INTO invites (tournament_id, organizer_id, player_id, status, type) VALUES (?,?,?,?,?) RETURNING invite_id";
        int id = jdbcTemplate.queryForObject(sql, Integer.class, invite.getTournamentId(), invite.getOrganizerId(),
                invite.getPlayerId(), "pending", string);
        return id;
    }

    @Override
    public boolean updateInvite(String status, int id) {
        String sql = "UPDATE invites SET status = ? WHERE invite_id = ?";
        boolean success = jdbcTemplate.update(sql, status, id) == 1;
        return success;
    }

    @Override
    public boolean addUserToTournament(int userId, int tournamentId) {
        return false;
    }

    public Invite mapRowToInvite(SqlRowSet rs) {
        Invite invite = new Invite();
        invite.setInviteId(rs.getInt("invite_id"));
        invite.setTournamentId(rs.getInt("tournament_id"));
        invite.setOrganizerId(rs.getInt("organizer_id"));
        invite.setPlayerId(rs.getInt("player_id"));
        invite.setStatus(rs.getString("status"));
        invite.setType(rs.getString("type"));
        return invite;
    }
}
