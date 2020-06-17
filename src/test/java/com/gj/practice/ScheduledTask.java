package com.gj.practice;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author gengjian
 * @date 2020/6/12
 */
@Component
public class ScheduledTask {

    @Scheduled(initialDelay=1000, fixedDelay = 1000)
    public void task1() {
        System.out.println("延迟1000毫秒后执行，任务执行完1000毫秒之后执行！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 2000)
    public void task2() {
        System.out.println("延迟1000毫秒后执行，之后每2000毫秒执行一次！");
    }

}
