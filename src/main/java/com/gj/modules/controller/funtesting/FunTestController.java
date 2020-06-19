package com.gj.modules.controller.funtesting;

import com.gj.modules.model.ScheduleJobEntity;
import com.gj.utils.ScheduleUtils;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能测试的请求
 * @author gengjian
 * @date 2020/6/14
 */

@RestController
@RequestMapping("/funtest")
//@Component  //项目启动直接加载 实现ApplicationRunner 重写run方法
public class FunTestController /*implements ApplicationRunner */{

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

    /*@Override
    public void run(ApplicationArguments args) throws Exception {
        ScheduleJobEntity scheduleJobEntity = new ScheduleJobEntity();
        scheduleJobEntity.setJobId("1232111");
        scheduleJobEntity.setBeanName("nakedCarController");
        scheduleJobEntity.setMethodName("addNakedCar");
        scheduleJobEntity.setParams("");
        scheduleJobEntity.setCronExpression("0/10 * * * * ? ");
        scheduleJobEntity.setStatus(0);

        ScheduleUtils.createScheduleJob(scheduler, scheduleJobEntity);
    }*/
}
