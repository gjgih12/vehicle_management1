package com.gj.demo.multithreading;

/**
 * @author gengjian
 * @date 2020/6/22
 */
public class MyThread implements Runnable{

    /**
     * 线程名称
     */
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name+"运行，i="+i);
        }
    }
}
