package com.gj.demo.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author ：gengjian
 * @date ：Created in 2021/7/16
 */
@Component
public class DemoCarBiz2 {

    //事件监听器2
    @EventListener
    public void doDemoCar(DemoCarEvent demoCarEvent){
        DemoCarContect demoCarContect = demoCarEvent.getDemoCarContect();
        System.out.println("==================22222===================");
        System.out.println("=====第二个监听处理=====");
        System.out.println("=====↓↓↓↓↓↓↓↓↓↓↓↓↓=====");
        System.out.println("第二个监听id====="+demoCarContect.getCarId());
        System.out.println("第二个监听name====="+demoCarContect.getCarName());
        System.out.println("第二个监听price====="+demoCarContect.getPrice());
    }
}
