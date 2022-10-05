package com.techelevator.dao;

import com.techelevator.model.Match;
import com.techelevator.model.Tournament;
import com.techelevator.model.User;
import com.techelevator.model.UserDTO;

import java.util.List;

public interface TournamentDao {

    List<Tournament> findAllTournaments();

    Tournament findTournamentById(int tournamentId);

    Tournament findByTournamentName(String tournamentName);

    int findIdByTournamentName(String tournamentName);

    List<UserDTO> findUsersByTournamentId(int tournamentId);

    List<Match> findMatchesByTournamentId(int tournamentId);

    int createTournament(Tournament tournament);

    boolean updateTournament(Tournament tournament, int tournamentId);

    List<Integer> getAllTournamentsByUserId(int id);
}
