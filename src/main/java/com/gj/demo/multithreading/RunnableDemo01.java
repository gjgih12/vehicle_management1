package com.gj.demo.multithreading;

/**
 * @author gengjian
 * @date 2020/6/22
 */
public class RunnableDemo01 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread("线程A");
        MyThread myThread2 = new MyThread("线程B");
        MyThread myThread3 = new MyThread("线程C");
        MyThread myThread4 = new MyThread("线程D");
        MyThread myThread5 = new MyThread("线程E");

        Thread thread = new Thread(myThread);
        Thread thread2 = new Thread(myThread2);
        Thread thread3 = new Thread(myThread3);
        Thread thread4 = new Thread(myThread4);
        Thread thread5 = new Thread(myThread5);
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

}
