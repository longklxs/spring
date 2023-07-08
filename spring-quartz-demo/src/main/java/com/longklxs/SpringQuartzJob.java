package com.longklxs;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class SpringQuartzJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        System.out.println("job执行了：" + new Date() + "=====任务名称："+jobDetail.getKey().getName()+"=======任务组名称"+jobDetail.getKey().getGroup());

    }
}
