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

    @RequestMapping(value="/welcomee")
    public static String welcome() {
        return "Welcome to Spring Boot e";
    }

    @RequestMapping(value = "/users/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user, @PathVariable String id) {
        userService.updateUser(id, user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
