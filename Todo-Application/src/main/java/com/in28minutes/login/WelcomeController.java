package com.in28minutes.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@SessionAttributes("name")
public class WelcomeController {

//	@Autowired
//	LoginService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
//	@ResponseBody
    public String showWelcomePage(ModelMap model) {
        return "welcome";
    }

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String handleLoginRequest(@RequestParam String name, 
//			@RequestParam String password,
//			ModelMap model) {
//		
//		if( !service.validateUser(name, password) ) {
//			model.put("errorMessage", "Invalid Credentials!");
//			return "login";
//		}
//		model.put("name", name);
//		model.put("password", password);
//		return "welcome";
//	}

}
