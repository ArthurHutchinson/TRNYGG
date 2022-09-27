package com.techelevator.dao;

import com.techelevator.model.Match;
import com.techelevator.model.Tournament;
import com.techelevator.model.User;

import java.util.List;

public interface TournamentDao {

    List<Tournament> findAllTournaments();

    Tournament getTournamentById(int tournamentId);

    Tournament findByTournamentName(String tournamentName);

    int findIdByTournamentName(String tournamentName);

    List<User> findUsersByTournamentId(int tournamentId);

    List<Match> findMatchesByTournamentId(int tournamentId);

    boolean createTournament(Tournament tournament);

    boolean updateTournament(Tournament tournament, int tournamentId);
}