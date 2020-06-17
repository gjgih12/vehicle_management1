package com.gj.practice;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author gengjian
 * @date 2020/5/21
 */
public class FileDemo {


    /**
     * 创建一个文件
     */
    @Test
    public void createFileTest(){

        try {
            boolean file = new File("E:/JavaDemo/geng/g/jgjs.txt").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 常用操作
     */
    @Test
    public void fileTest() throws IOException {


        System.out.println("当前操作系统的名称分隔符是：" + java.io.File.separator);
        System.out.println("当前操作系统的路径分隔符是：" + java.io.File.pathSeparator);

        String gengStr = "jkjk.txt";


        File file = new File("src",gengStr);
        //创建一个目录用mkdir  多层目录用mkdirs
        //file.mkdirs();

        file.createNewFile();
        boolean b;

        b = file.canExecute();
        System.out.println("测试应用程序是否可以执行该文件" + b);

    }

}
