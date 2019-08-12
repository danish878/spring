package com.danny.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/hello/{name}")
    public String home(@PathVariable("name") String name) {
        return "Hello " + name;
    }
}
