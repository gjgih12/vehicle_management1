package com.gj.demo.service;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：gengjian
 * @date ：Created in 2020/8/25
 */
public abstract class CallTestBase implements CallTest{

    @Override
    public List<Integer> getIntegerTest(Integer intCode){

        List<Integer> integers = Arrays.asList(12, 3, 32, 123);
        System.out.println(integers);
        return integers;
    }

    public String code(String str){
        return str+"111";
    }

}
