package com.danny.sfgpetclinic.fauxspring;


import com.danny.sfgpetclinic.model.PetType;

import java.text.ParseException;
import java.util.Locale;

public interface Formatter<T> {

    String print(PetType petType, Locale locale);

    PetType parse(String text, Locale locale) throws ParseException;
}
