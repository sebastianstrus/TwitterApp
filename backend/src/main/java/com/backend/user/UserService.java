package com.backend.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    User user1 = new User("u1", "Sebek3257", "password1", "I'm happy.");
    User user2 = new User("u2", "Jadon", "password2", "All good.");

    List<User> users = new ArrayList<>(Arrays.asList(user1, user2));


    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(String id) {
        User user = users.stream()
                .filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return user;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(String id, User user) {
        for(int i = 0; i < users.size(); i++) {
            User l = users.get(i);
            if (l.getId().equals(id)) {
                users.set(i, user);
            }
        }
    }

    public void deleteUser(String id) {
        users.removeIf(u -> u.getId().equals(id));
    }
}
