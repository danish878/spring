package com.danny.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMain {

    public static void main(String[] args) throws SchedulerException {

        //Define a job and tie it to our job

        JobDetail job = JobBuilder.newJob(QuartzJob.class).build();

//        Trigger t1 = TriggerBuilder.newTrigger().withIdentity("SimpleTrigger").startNow().build();

//        Trigger t1 = TriggerBuilder
//                                .newTrigger()
//                                .withIdentity("CronTrigger")
//                                .withSchedule(
//                                        CronScheduleBuilder
//                                                .cronSchedule("0 0/1 * 1/1 * ? *") // generate this 'cron expression' from //http://www.cronmaker.com/
//                                )
//                                .build();

        Trigger t1 = TriggerBuilder
                .newTrigger()
                .withIdentity("CronTrigger")
                .withSchedule(
                        SimpleScheduleBuilder
                                .simpleSchedule()
                                .withIntervalInSeconds(5)
                                .repeatForever()
                )
                .build();

        Scheduler sc = StdSchedulerFactory.getDefaultScheduler();

        sc.start();
        sc.scheduleJob(job, t1);

    }
}
