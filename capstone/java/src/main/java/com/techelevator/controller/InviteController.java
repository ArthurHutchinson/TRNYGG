package com.techelevator.controller;

import com.techelevator.dao.InviteDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Invite;
import com.techelevator.model.TournamentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class InviteController {

    @Autowired
    InviteDao inviteDao;

    @Autowired
    UserDao userDao;

    @GetMapping(path="/invites")
    public List<Invite> getInvitesById(Principal principal){
        int id = userDao.findIdByUsername(principal.getName());
        return inviteDao.getInvitesById(id);
    }

    @PostMapping(path="/create/invite")
    public Invite createInvite(Invite invite){
        boolean success = inviteDao.createInvite(invite);
        if (success) {
            return inviteDao.getInviteByInviteId(invite.getInviteId());
        } else {
            throw new TournamentNotFoundException();
        }
    }
}
