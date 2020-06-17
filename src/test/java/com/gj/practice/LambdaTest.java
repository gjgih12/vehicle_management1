package com.gj.practice;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author gengjian
 * @date 2019/12/28
 */
public class LambdaTest {

    @Test
    public void test1(){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程启动了");
            }
        };
        runnable.run();

    }

    //用lanbda表达式标识内部类
    @Test
    public void test2(){

        Runnable runnable = ()->System.out.println("线程启动了");
        runnable.run();
    }

    @Test
    public void lombdaList(){

        Map<String,String> map = new HashMap<>();
        map.put("name","小明");
        map.put("date","2000-01-02");
        Map<String,String> map2 = new HashMap<>();
        map2.put("name","小黑");
        map2.put("date","2005-06-12");
        Map<String,String> map3 = new HashMap<>();
        map3.put("name","小花");
        map3.put("date","2002-03-19");

        List<Map<String,String>> list = new ArrayList<>();

        list.add(map);
        list.add(map2);
        list.add(map3);

        //foreach循环
        /*list.forEach(m ->{
            System.out.println(m);
        });*/

        /*for (Map<String, String> strlist : list) {
            System.out.println(strlist);
        }*/


    }

    /**
     * 常用的操作
     */
    @Test
    public void lombda2(){
        int[] arr = {12,3,21,31,41,24,13,1};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }



}
