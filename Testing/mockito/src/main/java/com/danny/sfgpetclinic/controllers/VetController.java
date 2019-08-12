package com.danny.sfgpetclinic.controllers;


import com.danny.sfgpetclinic.fauxspring.Model;
import com.danny.sfgpetclinic.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
