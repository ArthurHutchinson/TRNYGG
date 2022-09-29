package com.techelevator.controller;

import com.techelevator.dao.InviteDao;
import com.techelevator.dao.TournamentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Invite;
import com.techelevator.model.InviteDTO;
import com.techelevator.model.TournamentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    TournamentDao tournamentDao;

    @GetMapping(path="/invites")
    public List<Invite> getInvitesById(Principal principal){
        int id = userDao.findIdByUsername(principal.getName());
        return inviteDao.getInvitesById(id);
    }

    @PostMapping(path="/create/invite")
    public Invite createInvite(@RequestBody Invite invite, Principal principal){
        String string = "";
        if (userDao.findByUsername(principal.getName()).getId() == invite.getOrganizerId()){
            string = "invite";
        }else {
            string = "request";
        }
        int id = inviteDao.createInvite(invite, string);
        if (id != 0) {
            return inviteDao.getInviteByInviteId(id);
        } else {
            throw new TournamentNotFoundException();
        }
    }

    @GetMapping(path="/invites/pending")
    public List<Invite> getPendingInvitesById(Principal principal){
        int id = userDao.findIdByUsername(principal.getName());
        return inviteDao.getPendingInvitesById(id);
    }

    @GetMapping(path="/tournaments/{id}/invites")
    public List<Invite> getInvitesByTournament(@PathVariable int id, Principal principal){
        if (userDao.findByUsername(principal.getName()).getId() == tournamentDao.findTournamentById(id).getOrganizerId()){
            return inviteDao.getInvitesByTournamentId(id);
        }else {
            throw new TournamentNotFoundException();
        }

    }

    @PutMapping(path="/invites/{id}/update")
    public Invite updateInvite(@PathVariable int id, @RequestBody InviteDTO inviteDTO){
        boolean success = inviteDao.updateInvite(inviteDTO.getStatus(), id);
        if(success){
            return inviteDao.getInviteByInviteId(id);
        }else {
            throw new TournamentNotFoundException();
        }
    }
}
