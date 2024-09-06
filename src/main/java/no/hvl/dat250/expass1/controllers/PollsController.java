package no.hvl.dat250.expass1.controllers;

import no.hvl.dat250.expass1.components.PollManager;
import no.hvl.dat250.expass1.domains.Polls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class PollsController {
    @Autowired
    private PollManager pollManager;

    @PostMapping("/createPoll")
    public void createPoll(@RequestParam String username, @RequestBody Polls.Poll poll) {
        pollManager.createPoll(poll, username);
    }

    @GetMapping("/listPolls")
    public List<Polls.Poll> listAllPolls() {
        return pollManager.getAllPolls();
    }



}
