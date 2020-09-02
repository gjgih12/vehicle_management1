package com.gj.practice;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

/**
 * @author gengjian
 * @date 2019/12/29
 */
public class BaseCodeTest {

    //定义变量
    @Test
    public void test1(){

        {
            int a = 0;
            System.out.println("括号内的内容"+a);
        }

        int a,b,c;
        a = 10;
        b = 20;
        c = 30;
        System.out.println("定义多个变量"+a+","+b+","+c);

    }

    //数据类型转换
    @Test
    public void test2(){

        /**
         * 数据范围大小 duble>float>long>int...
         */

        System.out.println("小数据类型转大数据类型，自动转换====");
        //数据类型不一样时，会发生转换，以下i = 12为int类型 附给long类型的a时已经自动转换为long类型
        int i = 12;
        long a = i;
        System.out.println("变量a的数据为"+a);
        //再例如： float类型数据给了double 就自动转换为了double
        double b = 123.12F;
        //将int类型转换为float;
        float d = i;

        System.out.println("大数据类型转小数据类型，强制转换====");

        long c = 123445L;
        int c1 = (int) c;
        System.out.println("被转换为int类型的查c1是"+c1);


        float f = (float) b;
        int f1 = (int) f;


    }

    //算数取模
    @Test
    public void test3(){

        System.out.println("3模2的结果是"+3%2);

    }


    /**
     * 冒泡排序
     */
    @Test
    public void arrayPaiXun(){

        int[] arr = {12,34,2,234,1,24,23,4,1324,123,5};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    @Test
    public void linShi(){

        System.out.println("AAA"+DateTime.now().plusSeconds(60));
        System.out.println("BBB"+DateTime.now());
        //System.out.println("Date"+new Date());

    }

    /**
     * 做对比
     */
    @Test
    public void duiBi(){

        String aa = "1.0.1";
        String bb = "1.1";

        String[] versionArray1 = aa.split("\\.");
        String[] versionArray2 = bb.split("\\.");

        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值

        int diff = 0;
        System.out.println(versionArray1[idx].compareTo(versionArray2[idx]));
        /*while (idx < minLength
                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符
            ++idx;
        }*/

        //System.out.println(diff);

    }


    @Test
    public void ceshi1(){
        Integer inte = 1;
        Integer sd = 1;
        if(sd.equals(inte)){
            System.out.println("相等");
        }else{
            System.out.println("不相等");
        }
    }

}
