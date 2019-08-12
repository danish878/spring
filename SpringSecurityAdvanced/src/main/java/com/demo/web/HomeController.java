package com.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.to.UserTo;

@Controller
public class HomeController {

    @Autowired
    UserTo userTo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView visitHome() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @RequestMapping(value = "/customlogout", method = RequestMethod.POST)
    public void logOut() {

    }

    @PreAuthorize("hasRole('CHIEF')")
    @RequestMapping(value = "/chief/updateProfile", method = RequestMethod.GET)
    public ModelAndView updateChiefPage() {
        ModelAndView mav = new ModelAndView();
        if (rememberMeCheck()) {
            mav.setViewName("/login");
        } else {
            mav.setViewName("chiefUpdate");
        }
        return mav;

    }

    @PreAuthorize("hasRole('AGENT')")
    @RequestMapping(value = "/agent/updateProfile", method = RequestMethod.GET)
    public ModelAndView updateUserPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userUpdate");
        return mav;
    }

    @PreAuthorize("principal.username=='agent'")
    @RequestMapping(value = "/withUserNameTest", method = RequestMethod.GET)
    public ModelAndView withUserNameTest(UserTo userTo) {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("userTo", userTo);
        return mav;
    }


    public void withUserDetailTest() {
        // TODO Auto-generated method stub
        System.out.println("Called - withUserDetailTest");
    }

    private boolean rememberMeCheck() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            return (auth instanceof AnonymousAuthenticationToken || auth instanceof RememberMeAuthenticationToken);
        else
            return false;
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
}