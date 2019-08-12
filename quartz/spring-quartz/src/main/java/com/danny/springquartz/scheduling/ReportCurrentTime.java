package com.danny.springquartz.scheduling;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component("reportCurrentTime")
public class ReportCurrentTime {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public void printCurrentTime() {
        System.out.println("Current time = " + dateFormat.format(new Date()));
    }

}