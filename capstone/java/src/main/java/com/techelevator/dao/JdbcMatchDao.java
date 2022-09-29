package com.techelevator.dao;

import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class JdbcMatchDao implements MatchDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcMatchDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Autowired
    UserDao userDao;

    @Override
    public int createMatch(Match match) {
        String sql = "INSERT INTO matches (tournament_id, home_id, away_id, round) VALUES (?,?,?,?)";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class,
                match.getTournamentId(), match.getHomeId(), match.getAwayId());
        return  newId;
    }

    @Override
    public boolean updateMatch(Match match, int matchId) {
        String sql = "UPDATE matches SET tournament_id = ?, home_id = ?, away_id = ?, winner = ?, round = ?";
        return jdbcTemplate.update(sql, match.getTournamentId(),
                match.getHomeId(), match.getAwayId(), match.getWinner(), match.getRound()) == 1;
    }

    @Override
    public boolean setWinner(int matchId, WinnerDTO winnerDTO) {
        String sql = "UPDATE matches SET winner = ? WHERE match_id = ?";
        return jdbcTemplate.update(sql, winnerDTO.getWinnerUsername(), matchId) == 1;
    }

    // To Do
    @Override
    public List<Match> generateMatches(List<UserDTO> winnerList) {
    return null;
    }

    @Override
    public Match findMatchById(int matchId) {
        String sql = "SELECT * FROM matches WHERE match_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, matchId);
        if (results.next()) {
            return mapRowToMatch(results);
        } else {
            throw new MatchNotFoundException();
        }
    }

    @Override
    public List<UserDTO> findUsersByMatchId(int matchId) {
        Match match;
        List<UserDTO> userList = new ArrayList<>();
        String sql = "SELECT * FROM matches WHERE match_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, matchId);
        if (results.next()) {
            match = mapRowToMatch(results);
        } else {
            throw new MatchNotFoundException();
        }
        userList.add(userDao.getUserDTOById(match.getHomeId()));
        userList.add(userDao.getUserDTOById(match.getAwayId()));
        return userList;
    }

    @Override
    public List<Match> findMatchesByRoundAndTournamentId(int tournamentId, int round) {
        List<Match> matchList = new ArrayList<>();
        String sql = "SELECT * FROM matches WHERE tournament_id = ? AND round = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tournamentId, round);
        while (results.next()) {
            Match match = mapRowToMatch(results);
            matchList.add(match);
        }
        return matchList;
    }

    @Override
    public List<Match> findMatchesByUserId(int userId) {
        List<Match> matchList = new ArrayList<>();
        String sql = "SELECT * FROM matches WHERE home_id = ? OR away_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, userId);
        while (results.next()) {
            Match match = mapRowToMatch(results);
            matchList.add(match);
        }
        return matchList;
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
