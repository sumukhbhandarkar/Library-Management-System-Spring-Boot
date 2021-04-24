package com.developer.sumukh.lms.service;

import com.developer.sumukh.lms.model.Book;
import com.developer.sumukh.lms.model.User;
import com.developer.sumukh.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public String addUser(User user) {
        if (user.getUserId() == 0 || userRepository.findById(user.getUserId()).isPresent())
            return "User already exists or incorrect user id";
        userRepository.save(user);
        return "User added successfully";
    }

    public List<User> searchUser(String key) {
        key = key.toLowerCase();
        List<User> results = new ArrayList<>();
        List<User> searchResult = userRepository.findAll();
        for(User user : searchResult) {
            if (user.getUserName().toLowerCase().contains(key) ||
                    user.getUserEmail().toLowerCase().contains(key) ||
                    user.getUserPhone().toLowerCase().contains(key)) {
                results.add(user);
            }
        }
        if (results.size() == 0) {
            User user = new User();
            user.setUserName("No such user found");
            results.add(user);
        }
        return results;
    }
}
