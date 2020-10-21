package com.gj.practice;

import com.gj.modules.business.mapper.NakedCarMapper;
import com.gj.testpojo.CarDemo;
import com.gj.testpojo.StudentDemo;
import com.gj.utils.DateTimeUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：gengjian
 * @date ：Created in 2020/9/4
 */
public class TemporaryTest {

    @Autowired
    private NakedCarMapper nakedCarMapper;

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


    @Test
    public void test5(){

    List<String> list = Arrays.asList("1");

        System.out.println("前"+list);

        if(list!=null&&list.size()>0){
            StringBuffer stringBuffer = new StringBuffer();

            for (String s : list) {
                stringBuffer.append(","+s);
            }
            System.out.println(stringBuffer.substring(1));
        }else{
            System.out.println("nonononononono");
        }

    }

    @Test
    public void test6(){

        StudentDemo studentDemo = new StudentDemo();

        ArrayList<StudentDemo> list = new ArrayList<>();
        ArrayList<StudentDemo> list2 = null;
        //list.add(studentDemo);

        Assert.notEmpty(list,"kong");

        System.out.println("结束");


    }

    @Test
    public void test7(){
        StudentDemo studentDemo = new StudentDemo();
        StudentDemo studentDemo2 = null;
        //Assert.notNull(studentDemo,"kong");
        if(studentDemo==null){
            System.out.println("对象为空");
        }else{
            System.out.println("结束");
        }


    }

    @Test
    public void test8(){
        String str = "";
        String str2 = null;
        Assert.notNull(str,"kong");
        System.out.println("结束");
    }

    @Test
    public void test9(){
        HashMap<String, String> stringStringHashMap = null;
        if(stringStringHashMap==null){
            System.out.println("空map");
        }else{
            System.out.println("有");
        }
    }

    @Test
    public void test10(){

        String str = "D:\\miniodata\\test\\temp\\20200926\\gengjian.mp4";

        InputStream is = null;
        FileOutputStream fos = null;
        try {
            String filePath = str.substring(0,str.lastIndexOf("."));
            is = new FileInputStream("C:\\Users\\Administrator\\Desktop\\eleProdData\\111.mp4");

            File file = new File(filePath);
            if(!file.exists()){
                file.mkdirs();
            }
            fos = new FileOutputStream(filePath+"/hhh.mp4");
            byte[] b = new byte[1024];
            while ((is.read(b)) != -1) {
                fos.write(b);// 写入数据
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 删除目录
     */
    @Test
    public void test13(){
        deleteAnyone("D:\\miniodata\\test\\temp\\20200926\\8dbdde60913696f2a7f80399d963adf8");
    }


    public static boolean deleteAnyone(String FileName){

        File file = new File(FileName);//根据指定的文件名创建File对象


        if ( !file.exists() ){  //要删除的文件不存在
            System.out.println("文件"+FileName+"不存在，删除失败！" );
            return false;
        }else{ //要删除的文件存在

            if ( file.isFile() ){ //如果目标文件是文件

                return deleteFile(FileName);

            }else{  //如果目标文件是目录
                return deleteDir(FileName);
            }
        }
    }


    public static boolean deleteFile(String fileName){


        File file = new File(fileName);//根据指定的文件名创建File对象

        if (  file.exists() && file.isFile() ){ //要删除的文件存在且是文件

            if ( file.delete()){
                System.out.println("文件"+fileName+"删除成功！");
                return true;
            }else{
                System.out.println("文件"+fileName+"删除失败！");
                return false;
            }
        }else{

            System.out.println("文件"+fileName+"不存在，删除失败！" );
            return false;
        }


    }



    public static boolean deleteDir(String dirName){

        if ( dirName.endsWith(File.separator) )//dirName不以分隔符结尾则自动添加分隔符
            dirName = dirName + File.separator;

        File file = new File(dirName);//根据指定的文件名创建File对象

        if ( !file.exists() || ( !file.isDirectory() ) ){ //目录不存在或者
            System.out.println("目录删除失败"+dirName+"目录不存在！" );
            return false;
        }

        File[] fileArrays = file.listFiles();//列出源文件下所有文件，包括子目录


        for ( int i = 0 ; i < fileArrays.length ; i++ ){//将源文件下的所有文件逐个删除

            deleteAnyone(fileArrays[i].getAbsolutePath());

        }


        if ( file.delete() )//删除当前目录
            System.out.println("目录"+dirName+"删除成功！" );


        return true;

    }

    /**
     * 获取时间
     */
    @Test
    public void test11(){

        System.out.println(DateTimeUtil.getLocalTime());
        System.out.println(System.currentTimeMillis());

    }


    /**
     * 查看字符串是否以指定字符开头
     */
    @Test
    public void test14(){

        String str = "Basicfewdws123";

        System.out.println(str.startsWith("Basic"));


    }


    @SneakyThrows
    @Test
    public void test15(){

        String str = "sdasdAS+&123的";
        String encode = URLEncoder.encode(str, "UTF-8");
        System.out.println("前======"+str);
        System.out.println("前======"+encode);
    }

    @Test
    public void test16(){

        List<String> list = new ArrayList<>();
        list.add("as");
        list.add("ad");
        list.add("af");
        list.add("ag");

        System.out.println("list=========="+list);

        String [] strArr = list.toArray(new String[4]);
        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        System.out.println("arr"+strArr);

    }


    @Test
    public void test17(){
        ThreadLocal<String> local = new ThreadLocal<>();

        Random random = new Random();

        IntStream.range(0,5).forEach(a-> new Thread(()->{

            local.set(a+" "+random.nextInt(10));
            System.out.println("线程和local值分别是"+local.get());

            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("等待1秒======================");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }).start());


    }

    @Test
    public void test18(){

        IntStream range = IntStream.range(0, 5);
        //range.forEach(System.out::println);
        //long count = range.count();
        //System.out.println("数量："+count);
        //int sum = range.sum();
        //System.out.println("求和"+sum);
    }

    @Test
    public void test19(){

        BigDecimal[] productTotalPrice = {BigDecimal.ZERO};

        BigDecimal bigDecimal = new BigDecimal("2");
        BigDecimal bigDecimal2 = new BigDecimal("3");

        System.out.println(bigDecimal.compareTo(bigDecimal2));

        System.out.println(new BigDecimal("0").compareTo(BigDecimal.ZERO));

    }


}
