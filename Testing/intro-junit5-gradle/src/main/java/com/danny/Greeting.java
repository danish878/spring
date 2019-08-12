package com.danny;

public class Greeting {

    public static final String HELLO = "Hello";
    public static final String WORLD = "World";

    public String helloWorld() {
        return HELLO + " " + WORLD;
    }

    public String helloWorld(String name) {
        return HELLO + " " + name;
    }
}
