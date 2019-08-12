package com.danny.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class QuartzJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("Hello");
        System.out.println(new Date());
    }
}
