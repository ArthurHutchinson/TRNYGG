package com.techelevator.dao;

import com.techelevator.model.Match;
import com.techelevator.model.Tournament;
import com.techelevator.model.TournamentNotFoundException;
import com.techelevator.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JdbcTournamentDao implements TournamentDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTournamentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tournament> findAllTournaments() {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "SELECT * FROM tournaments";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Tournament tournament = mapRowToTournament(results);
            tournaments.add(tournament);
        }
        return tournaments;
    }

    @Override
    public Tournament getTournamentById(int tournamentId) {
        String sql = "SELECT * FROM tournaments WHERE tournament_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tournamentId);
        if (results.next()) {
            return mapRowToTournament(results);
        } else {
            throw new TournamentNotFoundException();
        }
    }

    @Override
    public Tournament findByTournamentName(String tournamentName) {
        String sql = "SELECT * FROM tournaments WHERE name = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tournamentName);
        if (results.next()) {
            return mapRowToTournament(results);
        } else {
            throw new TournamentNotFoundException();
        }
    }

    @Override
    public int findIdByTournamentName(String tournamentName) {
        if (tournamentName == null) throw new IllegalArgumentException("Tournament Name cannot be Null");
        int tournamentId;
        try {
            tournamentId = jdbcTemplate.queryForObject("SELECT tournament_id FROM tournaments WHERE name = ?", int.class, tournamentName);
        } catch (EmptyResultDataAccessException e) {
            throw new TournamentNotFoundException();
        }
        return tournamentId;
    }

    // should this go in UserDao??
    @Override
    public List<User> findUsersByTournamentId(int tournamentId) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id FROM tournament_user WHERE tournament_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,tournamentId);
        while(results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }
// should this go in MatchDao??
    @Override
    public List<Match> findMatchesByTournamentId(int tournamentId) {
        List<Match> matches = new ArrayList<>();
        String sql = "SELECT * FROM matches WHERE tournament_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,tournamentId);
        while(results.next()) {
            Match match = mapRowToMatch(results);
            matches.add(match);
        }
        return matches;
    }

    @Override
    public boolean createTournament(Tournament tournament) {
        String sql = "INSERT INTO tournaments (organizer_id, name, num_of_participants, type, from_date, to_date) VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.update
                (sql,tournament.getOrganizerId(), tournament.getTournamentName(),
                        tournament.getNumOfParticipants(), tournament.getTournamentType(),
                        tournament.getFromDate(), tournament.getToDate()) == 1;
    }

    @Override
    public boolean updateTournament(Tournament tournament, int tournamentId) {
        String sql = "UPDATE tournaments SET organizer_id = ?, name = ?, num_of_participants = ?, type = ?, from_date = ?, to_date = ? WHERE tournament_id = ?";
        return jdbcTemplate.update
                (sql,tournament.getOrganizerId(), tournament.getTournamentName(),
                        tournament.getNumOfParticipants(), tournament.getTournamentType(),
                        tournament.getFromDate(), tournament.getToDate(), tournamentId) == 1;
    }

    private Tournament mapRowToTournament(SqlRowSet rs) {
        Tournament tournament = new Tournament();
        tournament.setTournamentId(rs.getInt("tournament_id"));
        tournament.setOrganizerId(rs.getInt("organizer_id"));
        tournament.setTournamentName(rs.getString("name"));
        tournament.setNumOfParticipants(rs.getInt("num_of_participants"));
        tournament.setTournamentType(rs.getString("type"));
        tournament.setFromDate(rs.getDate("from_date"));
        tournament.setToDate(rs.getDate("to_date"));
        return tournament;
    }
    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(Objects.requireNonNull(rs.getString("role")));
        user.setActivated(true);
        return user;
    }

    private Match mapRowToMatch(SqlRowSet rs) {
        Match match = new Match();
        match.setMatchId(rs.getInt("match_id"));
        match.setTournamentId(rs.getInt("tournament_id"));
        match.setHomeId(rs.getInt("home_id"));
        match.setAwayId(rs.getInt("away_id"));
        match.setWinner(rs.getString("winner"));
        return match;
    }
}
