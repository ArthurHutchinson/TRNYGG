package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;

public interface MatchDao {

    int createMatch(Match match);

    boolean updateMatch(Match match, int matchId);

    boolean setWinner(int matchId, WinnerDTO winnerDTO);

    List<Match> generateMatches(List<UserDTO> winnerList);

    Match findMatchById(int matchId);

    List<UserDTO> findUsersByMatchId(int matchId);

    List<Match> findMatchesByRoundAndTournamentId (int tournamentId, int round);

    List<Match> findMatchesByUserId (int userId);
}
