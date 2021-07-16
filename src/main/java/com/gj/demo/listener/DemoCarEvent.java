package com.gj.demo.listener;

import org.springframework.context.ApplicationEvent;

/**
 * 事件对象
 * @author ：gengjian
 * @date ：Created in 2021/7/16
 */
public class DemoCarEvent extends ApplicationEvent {

    /**
     * 业务对象
     */
    private DemoCarContect demoCarContect;

    public DemoCarEvent(Object source, DemoCarContect demoCarContect) {
        super(source);
        this.demoCarContect = demoCarContect;
    }

    public DemoCarContect getDemoCarContect() {
        return demoCarContect;
    }

    public void setDemoCarContect(DemoCarContect demoCarContect) {
        this.demoCarContect = demoCarContect;
    }
}
