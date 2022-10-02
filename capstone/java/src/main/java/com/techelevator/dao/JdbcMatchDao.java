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
        String sql = "INSERT INTO matches (tournament_id, home_player, away_player, round) VALUES (?,?,?,?)";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class,
                match.getTournamentId(), match.getHomePlayer(), match.getAwayPlayer());
        return  newId;
    }

    @Override
    public boolean updateMatch(Match match, int matchId) {
        String sql = "UPDATE matches SET tournament_id = ?, home_player = ?, away_player = ?, winner = ?, round = ?";
        return jdbcTemplate.update(sql, match.getTournamentId(),
                match.getHomePlayer(), match.getAwayPlayer(), match.getWinner(), match.getRound()) == 1;
    }

    @Override
    public boolean setWinner(int matchId, UserDTO UserDTO) {
        String sql = "UPDATE matches SET winner = ? WHERE match_id = ?";
        return jdbcTemplate.update(sql, UserDTO.getUsername(), matchId) == 1;
    }

    // To Do
    @Override
    public List<Match> generateMatches(List<UserDTO> winnerList, int tournamentId) {
        int round = 1;
        Match match = findLastMatchByTournamentId(tournamentId);
        if (match != null) {
            round = match.getRound();
            round++;
        }
        if (round == 1) {
            Collections.shuffle(winnerList);
        }
        String sql = "INSERT INTO matches (tournament_id, home_player, away_player, round) VALUES (?,?,?,?)";
        if (!isPowerOfTwo(winnerList.size())) {
            UserDTO playerOne = winnerList.remove(0);
            jdbcTemplate.update(sql, tournamentId, playerOne.getUsername(), "none", round);
        }
        if (winnerList.size() % 2 == 1) {
            UserDTO playerOne = winnerList.remove(0);
            jdbcTemplate.update(sql, tournamentId, playerOne.getUsername(), -1, round);
        }
        for (int i = 1; i < winnerList.size(); i+=2) {
            jdbcTemplate.update(sql, tournamentId, winnerList.get(i-1).getUsername(), winnerList.get(i).getUsername(), round);
        }
        return findMatchesByRoundAndTournamentId(tournamentId, round);

    }
    @Override
    public Bracket generateBracket(int tournamentId, List<UserDTO> winnerList) {
        int roundNumber = 1;
        Match match = findLastMatchByTournamentId(tournamentId);
        if (match != null) {
            roundNumber = match.getRound();
            roundNumber++;
        }
        if (roundNumber == 1) {
            Collections.shuffle(winnerList);
        }
        String sql = "INSERT INTO matches (tournament_id, home_player, away_player, round) VALUES (?,?,?,?)";
        if (!isPowerOfTwo(winnerList.size())) {
            UserDTO playerOne = winnerList.remove(0);
            jdbcTemplate.update(sql, tournamentId, playerOne.getUsername(), "none", roundNumber);
        }
        if (winnerList.size() % 2 == 1) {
            UserDTO playerOne = winnerList.remove(0);
            jdbcTemplate.update(sql, tournamentId, playerOne.getUsername(), -1, roundNumber);
        }
        for (int i = 1; i < winnerList.size(); i+=2) {
            jdbcTemplate.update(sql, tournamentId, winnerList.get(i-1).getUsername(), winnerList.get(i).getUsername(), roundNumber);
        }
        List<Round> rounds = new ArrayList<>();
        for (int i = 1; i <= roundNumber; i++) {
            Round round = new Round(i);
            round.setMatches(findMatchesByRoundAndTournamentId(tournamentId, i));
            rounds.add(round);
        }
        Bracket bracket = new Bracket(tournamentId, rounds);
        return bracket;
    }

    @Override
    public Match findLastMatchByTournamentId(int tournamentId) {
        Match match = null;
        String sql = "SELECT * FROM matches WHERE tournament_id = ? ORDER BY match_id DESC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,tournamentId);
        if(results.next()) {
            match = mapRowToMatch(results);
        }
        return match;
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
        return null;
    }

//    @Override
//    public List<UserDTO> findUsersByMatchId(int matchId) {
//        Match match;
//        List<UserDTO> userList = new ArrayList<>();
//        String sql = "SELECT * FROM matches WHERE match_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, matchId);
//        if (results.next()) {
//            match = mapRowToMatch(results);
//        } else {
//            throw new MatchNotFoundException();
//        }
//        userList.add(userDao.getUserDTOById(match.getHomePlayer()));
//        userList.add(userDao.getUserDTOById(match.getAwayPlayer()));
//        return userList;
//    }

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
        match.setHomePlayer(rs.getString("home_player"));
        match.setAwayPlayer(rs.getString("away_player"));
        match.setWinner(rs.getString("winner"));
        match.setRound(rs.getInt("round"));
        return match;
    }

    static boolean isPowerOfTwo(int n)
    {
        if (n == 0)
            return false;
        return (int)(Math.ceil((Math.log(n) / Math.log(2))))
                == (int)(Math.floor(
                ((Math.log(n) / Math.log(2)))));
    }


}
