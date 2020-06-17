package com.gj.modules.controller.funtesting;

import com.gj.modules.model.NakedCarEntity;
import com.gj.modules.model.ScheduleJobEntity;
import com.gj.utils.ScheduleUtils;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * 功能测试的请求
 * @author gengjian
 * @date 2020/6/14
 */

@RestController
@RequestMapping("/funtest")
public class FunTestController {

    @Autowired
    private Scheduler scheduler;

    /**
     * 开启一条定时任务
     */
    @RequestMapping("/openSchedulerJob")
    public void openSchedulerJob() {

        ScheduleJobEntity scheduleJobEntity = new ScheduleJobEntity();
        scheduleJobEntity.setJobId("1232111");
        scheduleJobEntity.setBeanName("nakedCarController");
        scheduleJobEntity.setMethodName("addNakedCar");
        scheduleJobEntity.setParams("");
        scheduleJobEntity.setCronExpression("0/10 * * * * ? ");
        scheduleJobEntity.setStatus(0);

        ScheduleUtils.createScheduleJob(scheduler, scheduleJobEntity);

    }

    /**
     * 关闭定时任务
     */
    @RequestMapping("/closeSchedulerJob")
    public void closeSchedulerJob(){

        ScheduleUtils.deleteScheduleJob(scheduler,"1232111");

    }

}
