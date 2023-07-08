package com.longklxs;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class HelloQuartz implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        String name = jobDetail.getKey().getName();
        String group = jobDetail.getKey().getGroup();
        System.out.println("job执行，job：" + name + " group:" + group);
        System.out.println(new Date());
    }
}
