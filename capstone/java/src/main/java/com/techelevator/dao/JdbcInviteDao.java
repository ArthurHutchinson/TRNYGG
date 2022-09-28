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
    public int createInvite(Invite invite) {
        String sql = "INSERT INTO invites (tournament_id, sender_id, receiver_id, status) VALUES (?,?,?,?) RETURNING invite_id";
        int id = jdbcTemplate.queryForObject(sql, Integer.class, invite.getTournamentId(), invite.getSenderId(),
                invite.getReceiverId(), "pending");
        return id;
    }

    @Override
    public boolean updateInvite(String status, int id) {
        String sql = "UPDATE invites SET status = ? WHERE invite_id = ?";
        return jdbcTemplate.update(sql, status, id) == 1;
    }

    public Invite mapRowToInvite(SqlRowSet rs) {
        Invite invite = new Invite();
        invite.setInviteId(rs.getInt("invite_id"));
        invite.setTournamentId(rs.getInt("tournament_id"));
        invite.setSenderId(rs.getInt("sender_id"));
        invite.setReceiverId(rs.getInt("receiver_id"));
        invite.setStatus(rs.getString("status"));
        return invite;
    }
}
