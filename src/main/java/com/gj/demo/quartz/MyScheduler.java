package com.gj.demo.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author gengjian
 * @date 2020/6/13
 */
public class MyScheduler {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class).usingJobData("jobDetail1", "这个Job用来测")
                .withIdentity("job1", "group1").build();


        // 3、构建Trigger实例,每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                .usingJobData("trigger1", "这是jobDetail1的trigger")
                .startNow()//立即生效
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule()
                 //       .withIntervalInSeconds(5)//每隔10s执行一次
                 //       .repeatForever()).build();//一直执行
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 7-8 23-23 * * ?"))
                .build();

        //4、执行
        scheduler.scheduleJob(jobDetail, trigger);
        System.err.println("--------scheduler start ! ------------");
        scheduler.start();

        //睡眠
        //TimeUnit.MINUTES.sleep(1);
        //scheduler.shutdown();
        //System.err.println("--------scheduler shutdown ! ------------");


    }

}
