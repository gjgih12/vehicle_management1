package com.gj.practice;

import com.gj.testpojo.CarDemo;
import com.gj.testpojo.StudentDemo;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void test0() throws Exception {
        System.out.println("main函数开始执行");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

                Integer[] intArr = {12,3,3,2,45,2,2,3,4,12,123};
                for (int i = 0; i < 100; i++) {
                    try {
                        System.out.println("第"+i+"次");
                        System.out.println("此处下表"+intArr[i]);
                    } catch (Exception e) {
                        System.err.println("第"+i+"次问题在于：");
                    }

                }

                /*try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println("===task finish逻辑执行完毕==================");
            }
        });

        thread.start();
        System.out.println("main函数执行结束，逻辑执行开始，先返回啊===================");

    }

    @Test
    public void test1(){

        List<String> list = Arrays.asList();

        if(CollectionUtils.isEmpty(list)){
            System.out.println("此集合为空");
        }else{
            System.out.println("总长度是"+list.size());
            System.out.println("一半的长度是"+list.size()/2);
        }

    }


    @Test
    public void test2(){

        Integer str = null;
        for (int i = 0; i < 10; i++) {

            System.out.println("第"+i+"次循环");
            if(str == null){
                System.out.println("str是空，开始赋值");
                str = i;
            }
            System.out.println("第"+i+"次循环时str是"+str);
        }

    }

    @Test
    public void test3(){

        List<CarDemo> carDemos = new ArrayList<>();

        CarDemo carDemo = new CarDemo();
        carDemo.setSort(1);
        CarDemo carDemo2 = new CarDemo();
        carDemo2.setSort(5);
        CarDemo carDemo3 = new CarDemo();
        carDemo3.setSort(3);
        CarDemo carDemo4 = new CarDemo();
        carDemo4.setSort(8);
        CarDemo carDemo5 = new CarDemo();
        carDemo5.setSort(10);
        CarDemo carDemo6 = new CarDemo();
        carDemo6.setSort(2);

        carDemos.add(carDemo);
        carDemos.add(carDemo2);
        carDemos.add(carDemo3);
        carDemos.add(carDemo4);
        carDemos.add(carDemo5);
        carDemos.add(carDemo6);

        //List<CarDemo> appList = new ArrayList<>();

        carDemos=carDemos.stream()
                .sorted(Comparator.comparing(CarDemo::getSort))
                .collect(Collectors.toList());

        System.out.println(carDemos);

    }


    @Test
    public void test4(){

        List<CarDemo> str;

        str = diaoTest4();

        StudentDemo studentDemo = new StudentDemo();
        studentDemo.setId("123");
        studentDemo.setName("的话我都");
        studentDemo.setStuCarDemo(str);

        System.out.println(studentDemo);

    }


    public List<CarDemo> diaoTest4(){

        List<CarDemo> list = null;

        return list;
    }


}
