package com.techelevator.controller;


import com.techelevator.dao.MatchDao;
import com.techelevator.model.Match;
import com.techelevator.model.MatchNotFoundException;
import com.techelevator.model.StartRoundDTO;
import com.techelevator.model.UserDTO;
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
    @RequestMapping(path = "match/{id}/winner", method = RequestMethod.PUT)
    public Match setWinner (@RequestBody UserDTO userDTO, @PathVariable int id) {
        boolean success = matchDao.setWinner(id, userDTO);
        if (success) {
            return matchDao.findMatchById(id);
        } else {
            throw new MatchNotFoundException();
        }
    }

    @RequestMapping(path = "tournaments/{id}/startround", method = RequestMethod.POST)
    public List<Match> generateMatches (@RequestBody StartRoundDTO startRound, @PathVariable int id) {
     List<Match> matchList = matchDao.generateMatches(startRound.getWinnerList(), id, startRound.getRound());
     return matchList;
    }




}
