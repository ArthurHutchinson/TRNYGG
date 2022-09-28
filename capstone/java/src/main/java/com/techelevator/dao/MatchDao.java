package com.techelevator.dao;

import com.techelevator.model.Match;
import com.techelevator.model.Tournament;
import com.techelevator.model.User;
import com.techelevator.model.WinnerDTO;

import java.util.List;

public interface MatchDao {

    int createMatch(Match match);

    boolean updateMatch(Match match, int matchId);

    boolean setWinner(int matchId, WinnerDTO winnerDTO);

    List<Match> generateMatches(List<WinnerDTO> winnerList);

    Match findMatchById(int matchId);

    List<User> findUsersByMatchId(int matchId);

    List<Match> findMatchesByRoundAndTournamentId (int tournamentId, int round);

    List<Match> findMatchesByUserId (int userId);
}
