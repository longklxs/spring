package com.longklxs;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))
                .build();

        JobDetail jobDetail = JobBuilder.newJob(HelloQuartz.class)
                .withIdentity("job1","group1")
                .build();

        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

    }
}
