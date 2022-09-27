package com.techelevator.controller;

import com.techelevator.dao.InviteDao;
import com.techelevator.model.Invite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class InviteController {

    @Autowired
    InviteDao inviteDao;

    @GetMapping(path="/invites/{id}")
    public List<Invite> getInvitesById()
}
