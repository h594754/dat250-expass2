package no.hvl.dat250.expass1.components;

import org.springframework.stereotype.Component;
import no.hvl.dat250.expass1.domains.Polls;

import java.util.Collection;
import java.util.HashMap;

@Component
public class PollManager {
    private final HashMap<String, Polls.User> users = new HashMap<>();
    private final HashMap<Polls.User, Polls.Poll> polls = new HashMap<>();

    public void addUser(Polls.User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        System.out.println("Add user: " + user.getUsername() + "," + user.getEmail());
        users.put(user.getUsername(), user);
    }

    public Polls.User getUserByUsername(String username)
    {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
        System.out.println("Get user " + username + "users " + users);
        return users.get(username);
    }

    public Collection<Polls.User> getAllUsers() {
        return users.values();
    }
}
