package com.gj.demo.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 实验定时任务demo
 * @author gengjian
 * @date 2020/6/13
 */
public class PrintWordsJob implements Job {



    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        System.err.println(jobExecutionContext.getJobDetail().getJobDataMap().get("jobDetail1"));
        System.err.println(jobExecutionContext.getTrigger().getJobDataMap().get("trigger1"));

        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
        System.err.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));

    }
}
