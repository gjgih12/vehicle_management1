package com.gj.practice;

import com.baidu.fsg.uid.impl.DefaultUidGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gj.testpojo.CarDemo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

//        System.out.println("长度"+str.length());
//        System.out.println("通过下标找字符"+str.charAt(3));
//        System.out.println("追加字符"+str.concat("ooooo"));
//        System.out.println("是否包含指定字符"+str.contains("w0"));
//        System.out.println("比较"+str.equals("qweQS124JJ#$sdf?.vv/kj"));
//        System.out.println("全部小写"+str.toLowerCase());
//        System.out.println("全部大写"+str.toUpperCase());
//        System.out.println("截取"+str.substring(3,7));
//        System.out.println("替换"+str.replace("J","O"));
//        System.out.println("第一次出现的下标"+str.indexOf("J"));
//        System.out.println("最后一次出现的下标"+str.lastIndexOf("J"));
//        String[] split = str.split(",");   //以,分割成数组
//        for (int i = 0; i < split.length; i++) {
//            System.out.println("被转换成数组后的元素"+split[i]);
//        }

        System.out.println(str.replaceAll(",","~"));


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


    @Test
    public void Lingshi3(){
        CarDemo carDemo;
        carDemo = Lingshi3dd();
        System.out.println("第一次"+carDemo);
        carDemo = Lingshi3dd2();
        carDemo.setcId(66);
        System.out.println("第二次"+carDemo);

    }

    public CarDemo Lingshi3dd(){
        CarDemo carDemo = new CarDemo();
        carDemo.setcId(123);
        carDemo.setName("都");
        carDemo.setAge(1);
        carDemo.setSort(12);
        return carDemo;
    }
    @Test
    public void LingShi22(){

        List<String> strList = new ArrayList<>();
        strList.add("aa");
        strList.add("bb");
        strList.add("cc");
        strList.add("dd");
        strList.add("ee");
        strList.add("ff");
        strList.add("gg");
        strList.add("hh");
        strList.add("ii");
        strList.add("jj");
        strList.add("kk");
        strList.add("ll");

        List<List<String>> cidsBatch = Lists.partition(strList, 3);
        List<String> targets = new ArrayList<>();

        for (List<String> batch : cidsBatch) {

            for (String cid : batch) {
                targets.add(cid);
            }
            System.out.println(targets);
        }


    }


    @Test
    public void LingShi23(){

        String[] keys = {"mobilePhone","nickname","projectName","roleName"};

        System.out.println(Arrays.binarySearch(keys, "roleName"));

    }


    @Test
    public void LingShi24(){

       String str1 = "136";
       String str2 = "134";
       int str = str1.compareTo(str2);
        System.out.println(str);

    }

    @Test
    public void LingShi25(){

        for (int i = 0; i < 100; i++) {
            System.out.println(1+(int)(Math.random()*2));
        }

    }


    public CarDemo Lingshi3dd2(){
        CarDemo carDemo = new CarDemo();
        carDemo.setName("哈哈");
        return carDemo;
    }


    @Test
    public void Lingshi4(){
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = Lists.partition(intList, 3);

        System.out.println("1111111111:::"+subSets.get(0));
        System.out.println("222222222:::"+subSets.get(1));
        System.out.println("333333333:::"+subSets.get(2));

    }

    @Test
    public void Lingshi5(){
        char a = 'A';
        for (int i = 0; i < 15; i++) {
            System.out.println(a++);
        }

    }

    @Test
    public void Lingshi6(){
        String a = "sd";
        String b = "sdfwefdcs";
        if(b.startsWith(a)){
            System.out.println("是");
        }else{
            System.out.println("否");
        }

    }

    private static ObjectMapper mapper;

    @Test
    public void Lingshi7(){

        CarDemo carDemo = new CarDemo();
        carDemo.setcId(1);
        carDemo.setName("大苏打");
        carDemo.setAge(23);
        carDemo.setSort(3);
        System.out.println("对象"+carDemo);

        ObjectMapper objectMapper = getMapperInstance(false);
        try {
            String json = objectMapper.writeValueAsString(carDemo);
            System.out.println("JSON"+json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    public static ObjectMapper getMapperInstance(boolean createNew) {
        if (createNew) {
            return new ObjectMapper();
        } else if (mapper == null) {
            mapper = new ObjectMapper();
        }
        return mapper;
    }

    @Test
    public void linShi8(){

        String str = "qweqweqewqe,12213";
        //返回仅包含指定对象的不可变列表
        System.out.println(Collections.singletonList(str));

    }

    @Test
    public void linShi26(){

        Integer[] strArr = {123,213,23,4,5};
        System.out.println(strArr[strArr.length-7]);

    }


    @Test
    public void test1(){

        String key = getKey("one", "two","2131");

        System.out.println(key);

    }


    public static String getKey(Object... params){
        return StringUtils.join(params, "_");
    }

    protected String getDefault(String strategy){
        String orderType = strategy.split("_")[0];
        return getKey(orderType, "1");
    }

    @Test
    public void test2(){
        /*Integer a = 127;
        Integer b = 127;
        System.out.println("eq>>>> "+a.equals(b));
        System.out.println("==>>>> "+(a == b));*/
        String str = "15101163606";
        System.out.println(str.substring(5));
    }


    @Test
    public void test3(){
        //getKey1("12f","q,22");

        BigDecimal actualPrice = new BigDecimal(0);
        BigDecimal actualPrice2 = new BigDecimal("2");
        BigDecimal actualPrice3 = new BigDecimal("3");
        actualPrice = actualPrice.add(actualPrice2);
        actualPrice = actualPrice.add(actualPrice3);
        System.out.println(actualPrice);

    }

    public void getKey1(Object... params){
        for (Object param : params) {
            System.out.println(param);
        }
    }

    @Test
    public void test4(){

        String str = "123";
        if(StringUtils.isNoneBlank(str)){
            System.out.println("11111");
        }else{
            System.out.println("2222222");
        }

    }

}
