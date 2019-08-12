package com.danish.mysqlconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danish.mysqlconnect.entity.User;
import com.danish.mysqlconnect.repository.UserRepository;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    public @ResponseBody
    User add(@RequestParam String name, @RequestParam String email) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        userRepository.save(user);

        return user;
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}
