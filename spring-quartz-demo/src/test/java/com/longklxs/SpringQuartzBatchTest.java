package com.longklxs;

import org.quartz.JobKey;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringQuartzBatchTest {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("=======================");
        StdScheduler scheduler = (StdScheduler) context.getBean("scheduled");
        System.out.println(scheduler.getClass());
        Thread.sleep(3000);
        GroupMatcher<JobKey> group = GroupMatcher.groupEquals("group1");
        scheduler.pauseJobs(group);
        Thread.sleep(3000);
        scheduler.resumeJobs(group);

    }
}
