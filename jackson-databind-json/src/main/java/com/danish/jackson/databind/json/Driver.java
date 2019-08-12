package com.danish.jackson.databind.json;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

    public static void main(String[] args) {

        try {

            // create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read JSON file and map/convert to Java POJO: data/sample-lite.json
            Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

            // print first name and last name
            System.out.println(String.format("FirstName = %s", student.getFirstName()));
            System.out.println(String.format("LastName = %s", student.getLastName()));

            // print out address: street and city
            Address address = student.getAddress();
            System.out.println("Address = " + address);

            String[] languages = student.getLanguages();
            for (String language : languages) {
                System.out.println(language);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
