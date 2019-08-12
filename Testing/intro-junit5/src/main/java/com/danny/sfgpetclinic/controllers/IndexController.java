package com.danny.sfgpetclinic.controllers;

import com.danny.sfgpetclinic.exceptions.ValueNotFoundException;

public class IndexController {

    public String index() {
        return "index";
    }

    public String oupsHandler() {
        throw new ValueNotFoundException();
//        return "notimplemented";
    }
}
