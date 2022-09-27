package com.techelevator.controller;

import com.techelevator.dao.TournamentDao;
import com.techelevator.model.Match;
import com.techelevator.model.Tournament;
import com.techelevator.model.TournamentNotFoundException;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
public class TournamentController {

    @Autowired
    TournamentDao tournamentDao;

    @RequestMapping(path = "/tournaments", method = RequestMethod.GET)
    public List<Tournament> findAllTournaments() {
        List<Tournament> tournaments = tournamentDao.findAllTournaments();
        return tournaments;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/tournaments/{tournamentId}", method = RequestMethod.GET)
    public Tournament findTournamentById (@PathVariable int tournamentId) {
        Tournament tournament = tournamentDao.findTournamentById(tournamentId);
        return tournament;
    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @RequestMapping(path = "/tournaments/{tournamentName}", method = RequestMethod.GET)
//    public Tournament findByTournamentName (@PathVariable String tournamentName) {
//        Tournament tournament = tournamentDao.findByTournamentName(tournamentName);
//        return tournament;
//    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/tournaments/{tournamentId}/players", method = RequestMethod.GET)
    public List<User> findUsersByTournamentId (@PathVariable int tournamentId) {
        List<User> users = tournamentDao.findUsersByTournamentId(tournamentId);
        return users;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/tournaments/{tournamentId}/matches", method = RequestMethod.GET)
    public List<Match> findMatchesByTournamentId (@PathVariable int tournamentId) {
        List<Match> matches = tournamentDao.findMatchesByTournamentId(tournamentId);
        return matches;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping (path = "/tournaments/create", method = RequestMethod.POST)
    public Tournament createTournament (@RequestBody Tournament tournament) throws TournamentNotFoundException {
        int newId = tournamentDao.createTournament(tournament);
        if (newId != 0) {
            return tournamentDao.findTournamentById(newId);
        } else {
            throw new TournamentNotFoundException();
        }
    }

    @RequestMapping (path = "/tournaments/{tournamentId}/update", method = RequestMethod.PUT)
    public Tournament updateTournament (@RequestBody Tournament tournament, @PathVariable int tournamentId) {
        boolean success = tournamentDao.updateTournament(tournament, tournamentId);
        if (success) {
            return tournamentDao.findTournamentById(tournament.getTournamentId());
        } else {
            throw new TournamentNotFoundException();
        }
    }
}
