package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;

public interface MatchDao {

    int createMatch(Match match);

    boolean updateMatch(Match match, int matchId);

    boolean setWinner(int matchId, String winner);

    List<Match> generateMatches(List<UserDTO> winnerList, int tournamentId);

    Match findMatchById(int matchId);

    List<UserDTO> findUsersByMatchId(int matchId);

    List<Match> findMatchesByRoundAndTournamentId (int tournamentId, int round);

    List<Match> findMatchesByUserId (int userId);

    public Match findLastMatchByTournamentId(int tournamentId);

    public Bracket generateBracket(int tournamentId, List<String> winnerList);

    public Bracket loadBracket(int tournamentId);

}
