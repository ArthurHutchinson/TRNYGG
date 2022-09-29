package com.techelevator.controller;


import com.techelevator.dao.MatchDao;
import com.techelevator.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MatchController {

    @Autowired
    MatchDao matchDao;

}
