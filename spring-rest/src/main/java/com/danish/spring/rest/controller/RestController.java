package com.danish.spring.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/test")
public class RestController {

    // add code for the "/hello" endpoint

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
}
