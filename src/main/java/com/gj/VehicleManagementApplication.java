package com.gj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@EnableScheduling
@SpringBootApplication
//@EnableEncryptableProperties //开启加密注解
@MapperScan("com.gj.modules.business.mapper")
public class VehicleManagementApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(VehicleManagementApplication.class, args);

        System.err.println("====================启动成功====================");

    }

    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

}
