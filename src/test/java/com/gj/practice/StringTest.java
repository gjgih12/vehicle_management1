package com.gj.practice;

import com.baidu.fsg.uid.impl.DefaultUidGenerator;
import com.gj.testpojo.CarDemo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String的常用方法
 * @author gengjian
 * @date 2020/5/9
 */
public class StringTest {

    @Autowired
    private DefaultUidGenerator defaultUidGenerator;

    /**
     * 字符串的常用方法
     */
    @Test
    public void StringDemo(){

        String str = "qwe,QS12,4JJ#,$sdf?.v,v/kj";

        System.out.println("长度"+str.length());
        System.out.println("通过下标找字符"+str.charAt(3));
        System.out.println("追加字符"+str.concat("ooooo"));
        System.out.println("是否包含指定字符"+str.contains("w0"));
        System.out.println("比较"+str.equals("qweQS124JJ#$sdf?.vv/kj"));
        System.out.println("全部小写"+str.toLowerCase());
        System.out.println("全部大写"+str.toUpperCase());
        System.out.println("截取"+str.substring(3,7));
        System.out.println("替换"+str.replace("J","O"));
        System.out.println("第一次出现的下标"+str.indexOf("J"));
        System.out.println("最后一次出现的下标"+str.lastIndexOf("J"));
        String[] split = str.split(",");   //以,分割成数组
        for (int i = 0; i < split.length; i++) {
            System.out.println("被转换成数组后的元素"+split[i]);
        }


    }

    /**
     * 常用的对比
     */
    @Test
    public void StringDemo2(){

        /*String str = "ghj";
        String str1 = new String("ghj");
        String str2 = new String("ghj");
        System.out.println(str2.equals(str1));*/


        /*包装类（应该用equals来对比） 数值在-128-127之间用==也是能比较的
        原因是 JVM 缓存部分基本类型常用的包装类对象*/
        Integer i = 234;
        Integer i2 = 234;
        System.out.println(i==i2);


    }


    /**
     * 排序
     */
    @Test
    public void StringDemo3(){

        //字符串倒排序
        String str = "1234erty678";
        int leng = str.length();
        //使用数组循环
        char[] arr = str.toCharArray();
        for (int i = 0; i < leng/2; i++) {
            arr[i] = str.charAt(leng-1-i);
            arr[leng-1-i] = str.charAt(i);
        }
        System.out.println(new String(arr));


        //使用StringBuffer的reverse
        /*StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        System.out.println(stringBuffer.reverse());*/


    }

    /**
     * 排序
     */
    @Test
    public void getPaixu(){

        /*CarDemo carDemo1 = new CarDemo(1,6,"小明");
        CarDemo carDemo2 = new CarDemo(2,13,"小黄");
        CarDemo carDemo3 = new CarDemo(3,19,"小花");
        CarDemo carDemo4 = new CarDemo(4,15,"灰太狼");


        List<CarDemo> carList = new ArrayList<>();
        List<CarDemo> carList2 = new ArrayList<>();
        carList.add(carDemo1);
        carList.add(carDemo2);
        carList.add(carDemo3);
        carList.add(carDemo4);

        //给装有carDemo对象的list根据属性age进行排序
        carList2 = carList.stream().sorted(Comparator.comparing(CarDemo::getAge).reversed()).collect(Collectors.toList());

        int sort = 1;
        for (CarDemo car:carList2) {
            car.setSort(Integer.valueOf(sort++));
        }

        for (CarDemo car2:carList2) {
            System.out.println(car2);
        }
*/
    }

    @Test
    public void LingShi(){

        String[] str = {"小黄","小明","小花","小黑","小绿"};

        List<CarDemo> carList = new ArrayList();
        CarDemo carDemo = null;
        for (int i = 0; i < 50000; i++) {
            carDemo = new CarDemo();
            carDemo.setcId(1);
            carDemo.setAge(12);
            carDemo.setName(String.valueOf(i));
            carList.add(carDemo);
            System.out.println("循环次数:"+i+",集合长度："+carList.size());
        }

        System.out.println("循环结束:"+carList.get(49998));

    }

    @Test
    public void Lingshi1(){
        String[] str = {"gggggg"};
        Lingshi2("sda","fffff");
    }

    public void Lingshi2(String st,String...str){

        String description = "您的退款申请被拒绝。";
        Matcher m= Pattern.compile("\\{(\\d)\\}").matcher(description);
        while(m.find()){
            description=description.replace(m.group(),str[Integer.parseInt(m.group(1))]);
        }
        StringBuffer s4 = new StringBuffer();

        System.out.println(str[0]);
    }



}
