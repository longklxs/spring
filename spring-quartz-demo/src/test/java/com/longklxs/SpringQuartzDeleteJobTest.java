package com.longklxs;

import org.quartz.JobKey;
import org.quartz.impl.StdScheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringQuartzDeleteJobTest {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("=============");
        StdScheduler scheduler = (StdScheduler) context.getBean("scheduled");
        System.out.println(scheduler.getClass());
        Thread.sleep(3000);

        scheduler.deleteJob(JobKey.jobKey("myJob","group1"));
    }
}
