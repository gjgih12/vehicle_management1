package com.gj.demo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件发布类
 * @author ：gengjian
 * @date ：Created in 2021/7/16
 */
@Component
public class DemoCarPublisher {

    @Autowired
    ApplicationContext applicationContext;

    public void publish(DemoCarEvent event) {
        applicationContext.publishEvent(event);
    }
}
