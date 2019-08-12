package com.danish.thymeleaf.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("myDate" + LocalDateTime.now());

        return "hello";
    }
}
