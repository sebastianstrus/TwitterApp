package com.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ComponentScan({"com.backend"})
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();

    }

    @RequestMapping(value = "/users/{id}")
    public Optional<User> getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/users/username/{username}")
    public List<User> getUsersByUsername(@PathVariable String username) {
        return userService.getUsersByUsername(username);
    }

    @RequestMapping(value = "/users/search/{str}")
    public List<User> findByUsernameContainingIgnoreCase(@PathVariable String str) {
        return userService.findByUsernameContainingIgnoreCase(str);
    }

    @RequestMapping(method= RequestMethod.POST, value="/users")
    public Optional<User> addUser(@RequestBody User user) {
        userService.addUser(user);
        return userService.getUser(user.getId());// TODO: update to void
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public Optional<User> updateUser(@RequestBody User user, @PathVariable Integer id) {
        userService.updateUser(id, user);
        return userService.getUser(id);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}