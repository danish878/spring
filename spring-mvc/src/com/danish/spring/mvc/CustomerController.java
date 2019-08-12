package com.danish.spring.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // add an initBinder ... to convert trim input strings
    // remove leading and trailing white spaces
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        Customer customer = new Customer();
        customer.setFreePasses(5);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult validationResult) {
        /*********************************************************/
        // get the value "typeMismatch.customer.freePasses" and set in "messages.properties" file
        System.out.println(validationResult);
        /*********************************************************/
        if (validationResult.hasErrors())
            return "customer-form";
        else
            return "customer-confirmation";
    }
}
