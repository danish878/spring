package com.danish.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {

        // create a student object
        Student theStudent = new Student();
        theStudent.setFirstName("Totha");
        theStudent.setLastName("Saleem");

        // add student object to the model
        model.addAttribute("student", theStudent);


        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {
        return "student-confirmation";
    }

}
