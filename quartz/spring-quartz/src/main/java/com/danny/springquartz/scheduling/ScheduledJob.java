package com.danny.springquartz.scheduling;

import lombok.Setter;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

//@Getter
@Setter
public class ScheduledJob extends QuartzJobBean {

    private ReportCurrentTime reportCurrentTime;

    @Override
    protected void executeInternal(JobExecutionContext arg0) {
        reportCurrentTime.printCurrentTime();
    }

}
