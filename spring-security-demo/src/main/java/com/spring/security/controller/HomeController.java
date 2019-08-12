package com.spring.security.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

//	@Value("${welcome.message}")
//	private String welcome;
//	
//	@GetMapping("/")
//	public String home(Model model) {
//		
//		model.addAttribute("welcome", welcome);
//		
//		return "home";
//	}

    @GetMapping("/user")
    @ResponseBody
    public Principal user(Principal principal) {
        return principal;
    }
}
