package com.developer.sumukh.lms.controller;

import com.developer.sumukh.lms.model.User;
import com.developer.sumukh.lms.repository.UserRepository;
import com.developer.sumukh.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping(value = "getUsers")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "addUser")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping(value = "searchUser")
    public List<User> searchUser(@RequestParam String key) {
        return userService.searchUser(key);
    }
}
