package com.techelevator.controller;


import com.techelevator.dao.MatchDao;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.awt.*;

@RestController
@CrossOrigin
public class MatchController {

    @Autowired
    MatchDao matchDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/match/create", method = RequestMethod.POST)
    public Match createMatch(@RequestBody Match match) throws MatchNotFoundException {
        int newId = matchDao.createMatch(match);
        if (newId != 0) {
            return matchDao.findMatchById(newId);
        } else {
            throw new MatchNotFoundException();
        }
    }

    // updates all match properties
    @RequestMapping(path = "match/{id}/update", method = RequestMethod.PUT)
    public Match updateMatch (@RequestBody Match match, @PathVariable int id) {
        boolean success = matchDao.updateMatch(match, id);
        if (success) {
            return matchDao.findMatchById(id);
        } else {
            throw new MatchNotFoundException();
        }
    }

    // only updates winner
    @RequestMapping(path = "match/{id}/winner", method = RequestMethod.POST)
    public Match setWinner (@RequestBody String winner, @PathVariable int id) {
        Match match = matchDao.findLastMatchByTournamentId(id);
        boolean success = matchDao.setWinner(match.getMatchId(), winner);
        if (success) {
            return matchDao.findMatchById(match.getMatchId());
        } else {
            throw new MatchNotFoundException();
        }
    }

    @RequestMapping(path = "tournaments/{id}/startround", method = RequestMethod.POST)
    public Bracket generateBracket (@RequestBody List<String> winnerList, @PathVariable int id) {
        return matchDao.generateBracket(id,winnerList);
    }
    @RequestMapping(path = "tournaments/{id}/bracket", method = RequestMethod.GET)
    public Bracket loadBracket (@PathVariable int id) {
        return matchDao.loadBracket(id);
    }

    @RequestMapping(path = "matches/{id}/players", method = RequestMethod.GET)
    public List<UserDTO> getUsersByMatchId(@PathVariable int id) {
        return matchDao.findUsersByMatchId(id);
    }




}

