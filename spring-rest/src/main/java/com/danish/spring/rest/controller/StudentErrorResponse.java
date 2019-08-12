package com.danish.spring.rest.controller;

public class StudentErrorResponse {

    private int status;
    private String messages;
    private long timeStamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String messages, long timeStamp) {
        super();
        this.status = status;
        this.messages = messages;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

}
