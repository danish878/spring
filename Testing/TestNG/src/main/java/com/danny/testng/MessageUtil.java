package com.danny.testng;

class MessageUtil {

    private String message;

    //Constructor
    //@param message to be printed
    MessageUtil(String message) {
        this.message = message;
    }

    // prints the message
    String printMessage() {
        System.out.println(message);
        return message;
    }

    // add "Hi!" to the message
    String salutationMessage() {
        message = "Hi!" + message;
        System.out.println(message);
        return message;
    }

    // add "www." to the message
    String exitMessage() {
        message = "www." + message;
        System.out.println(message);
        return message;
    }
}  