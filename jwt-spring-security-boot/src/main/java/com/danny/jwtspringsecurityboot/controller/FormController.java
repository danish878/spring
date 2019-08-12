package com.danny.jwtspringsecurityboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

    @GetMapping("/hello")
    public @ResponseBody String hello() {
        return "Ahoy";
    }
}
