package com.gj.demo.scheduling;

import com.gj.modules.model.NakedCarEntity;
import com.gj.modules.service.NakedCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author gengjian
 * @date 2020/6/12
 */

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling  // 2.开启定时任务
//配置文件读取是否启用此配置
@ConditionalOnProperty(prefix = "scheduling", name = "enabled", havingValue = "true")
public class SaticScheduleTask {

    @Autowired
    private NakedCarService nakedCarService;

    //3.添加定时任务
    //@Scheduled(cron = "0/10 * * * * ? ")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }


    //3.添加定时任务
    @Scheduled(cron = "0/10 * * * * ? ")
    public void addNakedCar(){

        NakedCarEntity nakedCar = new NakedCarEntity();
        nakedCar.setcBrand("大G");
        nakedCar.setcName("小G");
        nakedCar.setcColor(1);
        nakedCar.setcType(1);
        nakedCar.setcPrice(23.21);
        nakedCar.setcLocal("huagd");
        nakedCar.setcDate(new Date());


        nakedCarService.addNakedCar(nakedCar);
    }

}
