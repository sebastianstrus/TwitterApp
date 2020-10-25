package com.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

    public List<User> findByUsernameContainingIgnoreCase(String str) {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach( (user) -> {
            if (user.getUsername().toLowerCase().contains(str.toLowerCase()))  {
                users.add(user);
            }
        });
        return users;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }


    public void updateUser(Integer id, User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public List<User> getUsersByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}