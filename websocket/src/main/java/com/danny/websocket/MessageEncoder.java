package com.danny.websocket;

import com.danny.model.Message;
import com.google.gson.Gson;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<Message> {

    private static Gson gson = new Gson();

    public String encode(Message message) {
        return gson.toJson(message);
    }

    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    public void destroy() {
        // Close resources
    }
}