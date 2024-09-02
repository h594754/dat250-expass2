package no.hvl.dat250.expass1.components;

import org.springframework.stereotype.Component;
import no.hvl.dat250.expass1.domains.Polls;

import java.util.HashMap;

@Component
public class PollManager {
    private HashMap<Polls.Poll, Polls.User> pollUsers = new HashMap<>();

}
