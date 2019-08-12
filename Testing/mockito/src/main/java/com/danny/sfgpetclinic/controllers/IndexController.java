package com.danny.sfgpetclinic.controllers;

import com.danny.sfgpetclinic.controllers.ValueNotFoundException;

public class IndexController {

    public String index() {
        return "index";
    }

    public String oopsHandler() {
        throw new ValueNotFoundException();
    }
}
