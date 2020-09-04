package com.gj.practice;

import com.gj.testpojo.CarDemo;
import org.junit.jupiter.api.Test;

/**
 * @author ：gengjian
 * @date ：Created in 2020/9/4
 */
public class TemporaryTest {

    @Test
    public void linshi1(){

        String str = null;
        CarDemo carDemo = null;
        CarDemo carDemo2 = new CarDemo();
        carDemo.setName(str);
        System.out.println(carDemo2.getName());

    }


}
