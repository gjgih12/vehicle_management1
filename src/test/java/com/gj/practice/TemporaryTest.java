package com.gj.practice;

import com.gj.modules.business.mapper.NakedCarMapper;
import com.gj.testpojo.CarDemo;
import com.gj.testpojo.StudentDemo;
import com.gj.testpojo.StudentDemo1;
import com.gj.testpojo.StudentDemo2;
import com.gj.utils.DateTimeUtil;
import com.gj.utils.JacksonJsonUtil;
import lombok.SneakyThrows;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.*;
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

    @Test
    public void test20(){
        //Object testObject = new Vector<>();
        //displayObjectClass(testObject);

        Object obj = new StudentDemo();

        StudentDemo studentDemo = new StudentDemo();
        studentDemo.setId("123");
        studentDemo.setName("小明");

        if(obj instanceof StudentDemo1){
            System.out.println("demo1111");
        }else if(obj instanceof StudentDemo){
            System.out.println("demo2222");
        }else {
            System.out.println("啥也不是");
        }

    }

    public static void displayObjectClass(Object o) {
        if (o instanceof Vector)
            System.out.println("对象是 java.util.Vector 类的实例");
        else if (o instanceof ArrayList)
            System.out.println("对象是 java.util.ArrayList 类的实例");
        else
            System.out.println("对象是 " + o.getClass() + " 类的实例");
    }

    @Test
    public void test21(){

        StudentDemo1 studentDemo1 = new StudentDemo1();
        studentDemo1.setAddress("北京");
        studentDemo1.setSex("1");
        StudentDemo2 studentDemo2 = new StudentDemo2();
        studentDemo2.setAddress("北京");
        studentDemo2.setSex("1");

        if(studentDemo1.equals(studentDemo2)){
            System.out.println("相等");
        }else{
            System.out.println("NONONONONONO");

        }

    }


    @Test
    public void test22(){

        StudentDemo1 studentDemo1 = new StudentDemo1();
        studentDemo1.setAddress("北京");
        studentDemo1.setSex("1");

        try {
            String s = JacksonJsonUtil.beanToJson(studentDemo1);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test23(){
        String str = "{\"address\":\"北京\",\"sex\":\"1\"}";

        try {
            StudentDemo1 studentDemo1 = JacksonJsonUtil.jsonToBean(str,StudentDemo1.class);
            System.out.println(studentDemo1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @SneakyThrows
    @Test
    public void test24(){

        Date data = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String thisDate = "2020-10-30 13:20:18";
        Date thisTime = sdf.parse(thisDate);


        System.out.println(data.getTime() > thisTime.getTime());


    }

    @Test
    public void test25(){

        Integer sum = null;
        Integer sum2 = 2;

        System.out.println(sum - sum2);

    }


    @Test
    public void test26(){

        List<String> str = new ArrayList<>();
        str.add("1");
        str.add("2");
        str.add("3");

        List<String> str2 = new ArrayList<>();

        for (String s : str) {
            if("4".equals(s)){
                str2.add(s);
            }
        }

        System.out.println(str2);

    }


    @Test
    public void test27(){

        HashMap<Object, Object> map = new HashMap<>();
        map.put("A1","a11");
        map.put("A2","a22");
        map.put("B1","b11");

        System.out.println(map.containsKey(""));

    }
    
    @Test
    public void test28(){
        BigDecimal bigDecimal = new BigDecimal("10");
        BigDecimal bigDecimal2 = new BigDecimal("1");
        BigDecimal bigDecimal3 = new BigDecimal("5");
        //System.out.println(bigDecimal.subtract(bigDecimal2));     //减
        //System.out.println(bigDecimal.add(bigDecimal2));          //加
        //System.out.println(bigDecimal3.compareTo(bigDecimal2));   //比较 大于返回1小于返回-1
        System.out.println(bigDecimal2.max(bigDecimal3));         //取最大值


    }


    @Test
    public void test29(){

        List<CarDemo> carList = new ArrayList<>();

        carList.add(new CarDemo(1,18,"小明",1));
        carList.add(new CarDemo(2,19,"狗子",2));
        carList.add(new CarDemo(3,18,"黑妹",1));
        carList.add(new CarDemo(4,21,"火龙",2));
        carList.add(new CarDemo(5,18,"小古",1));
        carList.add(new CarDemo(6,23,"赵四",2));
        carList.add(new CarDemo(7,24,"刘能",1));
        carList.add(new CarDemo(8,25,"夏洛",2));

        //求sort为1的集合
        /*List<Object> carList2 = new ArrayList<>();
        for (CarDemo carDemo : carList) {
            if(carDemo.getSort() == 1){
                carList2.add(carDemo);
            }
        }*/

//        List<CarDemo> carList2 = carList.stream().filter(car -> car.getSort() == 1).collect(Collectors.toList());
//        System.out.println("sort为1的集合======"+carList2);
//
//        //求sort为2的age总数
//        Integer sum = carList.stream().filter(car -> car.getSort() == 2).mapToInt(CarDemo::getAge).sum();
//        System.out.println("sort为2的age总数====="+sum);

//        carList.stream().filter(carDemo -> carDemo.getSort() == 1).filter(
//                carDemo -> carDemo.getName().contains("小")).mapToInt(CarDemo::getAge);

        //求sort为2 年龄大于20的第一个对象
//        CarDemo first = carList.stream().filter(carDemo -> carDemo.getSort() == 2 && carDemo.getAge() > 20).findFirst().get();
//        System.out.println(first);

        //求所有年龄平均数
//        double asDouble = carList.stream().mapToInt(CarDemo::getAge).average().getAsDouble();
//        System.out.println(asDouble);

        //求所有年龄平均数
//        Double collect = carList.stream().collect(averagingInt(CarDemo::getAge));
//        System.out.println(collect);

        //把集合中所有的名字筛选出来
//        List<String> collect = carList.stream().map(CarDemo::getName).collect(Collectors.toList());
//        System.out.println(collect);

        //筛选年龄大于20的
//        List<CarDemo> collect = carList.stream().filter(carDemo -> carDemo.getAge() > 20).collect(Collectors.toList());
//        System.out.println(collect);

        List<String> collect = carList.stream().filter(carDemo -> carDemo.getAge() == 18).map(CarDemo::getName).collect(Collectors.toList());
        System.out.println(collect);

        //查询是否有年龄小于18的 有true
//        boolean b = carList.stream().anyMatch(carDemo -> carDemo.getAge() < 18);
//        System.out.println(b);

        //年龄最大的
//        CarDemo carDemo = carList.stream().collect(maxBy(Comparator.comparing(CarDemo::getAge))).get();
//        System.out.println(carDemo);

        //取年龄最大的 （先排序再取第一个）
        //Optional<CarDemo> first = carList.stream().sorted(Comparator.comparing(CarDemo::getAge).reversed()).findFirst();
        //System.out.println(first.get());

        //倒排序
//        List<CarDemo> collect = carList.stream().sorted(Comparator.comparing(CarDemo::getAge).reversed()).collect(Collectors.toList());
//        System.out.println(collect);

        //根据条件取对象
//        Optional<CarDemo> first = carList.stream().filter(carDemo -> "小明".equals(carDemo.getName())).findFirst();
//        System.out.println(first.get());

    }

    @Test
    public void test30(){

        Integer i = 1;

        if(i == 1)
            System.out.println("是1");
        if(i == 2)
            System.out.println("是2");
        //aaaaabbbbb
    }

    @Test
    public void test31(){

        String str = "Bearer 12edn1oh%201eo12n2od";

        System.out.println(str.replaceAll("%20"," "));

    }

    @Test
    public void test32() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String s = "2020-12-23 17:12:00";

        Date date = sdf.parse(s);
        DateTime dateTime = new DateTime(date);

        //dateTime追加10分钟是否在当前时间之前 在true 不在false
        System.out.println(dateTime.plusMinutes(10).isBeforeNow());

    }

    @Test
    public void test33(){

        Integer a1 = 0;
        Integer a2 = 10;

        Double useRatio = (a1.doubleValue() / a2.doubleValue()) * 100;

        System.out.println(useRatio);

    }


    @Test
    public void test34(){

        StringBuilder projectSb = new StringBuilder();
        System.out.println(projectSb.length());
    }

    @Test
    public void test35(){

//        Date date = new Date();
//
//        Calendar instance = Calendar.getInstance();
//        instance.setTime(date);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar calendar = Calendar.getInstance();
//        String timestamp = df.format(calendar.getTime());
        String timestamp = df.format(new Date());

        System.out.println(timestamp);

    }


    @Test
    public void test36(){

        List<String> list = null;
        //list.add("123");


        Assert.notEmpty(list, "list is empty");

        System.out.println("================");

    }


    @Test
    public void test37(){

        String str = "33de&2qe2";

        String[] split = str.split("&");

        for (String s : split) {
            System.out.println(s);
        }

    }

    @Test
    public void test38(){

        Map<String,String> headers = new HashMap<>();
        headers.put("di1","11111");
        headers.put("di2","22222");
        headers.put("di3","33333");
        headers.put("di4","44444");

        Set<String> keys = headers.keySet();
        for (Iterator<String> i = keys.iterator(); i.hasNext();) {
            String key = (String) i.next();
            System.out.println("key====="+key+">>>>>>"+"headers.get(key)====="+headers.get(key));
            System.out.println();
           // method.addHeader(key, headers.get(key));
        }
    }


    @Test
    public void test39(){
        System.out.println(10 % 5);
    }


    @Test
    public void test40(){

//        Date currentDate = new Date();
//        Date mothDate = addMonths(currentDate, -1);
//        Date startDate = DateUtils.getMonthOfFirst(mothDate);
//        System.out.println(formatDateTime(mothDate, "yyyyMMdd"));

        System.out.println("111===="+formatDateTime(getLocalTime(),"yyyy-MM-dd HH:mm:ss"));
        System.out.println("222===="+formatDateTime(new Date(),"yyyy-MM-dd HH:mm:ss"));
    }





    public static Date addMonths(Date paramDate, int paramInt) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        localCalendar.add(Calendar.MONTH, paramInt);
        return localCalendar.getTime();
    }

    public static String formatDateTime(Date paramDate, String format) {
        if (paramDate == null)
            return null;
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(format);
        localSimpleDateFormat.setLenient(false);
        return localSimpleDateFormat.format(paramDate);
    }


    public static Date getMonthOfFirst(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // 将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        calendar.set(Calendar.MINUTE, 0);
        // 将秒至0
        calendar.set(Calendar.SECOND, 0);
        // 将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        // 获得当前月最后一天
        Date edate = calendar.getTime();
        return edate;

    }

    public static Date getLocalTime() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Calendar rightNow = Calendar.getInstance();
        return rightNow.getTime();
    }


    @Test
    public void test41(){
        String[] str = {"qwedqsax","def"};
        assert str.length == 2;
        //System.out.println(str.length());
    }

   /* @Test
    public void test42(){
        try {
            String[] strings = extractAndDecodeHeader("Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsicmVhZCJdLCJleHBpcmUiOjE2MTE3MzY2NTkwNjMsImV4cCI6MTYxMTc0NzQ1OSwiZGVwYXJ0Ijoicm9vdCIsInVzZXJOYW1lIjoi6LaF57qn566h55CG5ZGYIiwidXNlcklkIjoiMSIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiJkNWZjYzg5Yi1hNTE2LTQyZDQtOTRjNi01ZjJlZDg4NDAwOGEiLCJ0ZW5hbnQiOiJhYzg4Y2ViMzg2YWE0MjMxYjA5YmY0NzJjYjkzN2MyNCIsImNsaWVudF9pZCI6InZ1ZSJ9.aIAJptifFzaW8OhTiSMimTLM_9bcYzsaThd8WWbzNz6XjblJHhnf7GjOaJQ1ZFFzOpqphi6Z0RXVJvWYS1iOr66qKdUPCC4cHV9IWUyBGm_DAyNpyj4UiMam86R-qF4mwpI5jgfMzu-uMtrz5jKtrcLcb5lJPr2ecIIkz2e4E3s");
            System.out.println(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /*private String[] extractAndDecodeHeader(String header)
            throws IOException {

        byte[] base64Token = header.substring(6).getBytes("UTF-8");
        byte[] decoded;
        try {
            Base64.Decoder baseDecoder = Base64.getDecoder();
            decoded = baseDecoder.decode(base64Token);
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException(
                    "Failed to decode basic authentication token");
        }

        String token = new String(decoded, "UTF-8");

        int delim = token.indexOf(":");

        if (delim == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
        }
        return new String[]{token.substring(0, delim), token.substring(delim + 1)};
    }*/




    @Test
    public void test43(){

        BigDecimal discountTotal = new BigDecimal("3");
        BigDecimal couponDealTotal = new BigDecimal("11");

        System.out.println(String.valueOf(discountTotal
                .divide(couponDealTotal,4,BigDecimal.ROUND_HALF_UP)
                .multiply(BigDecimal.valueOf(100)).doubleValue()) + "%");

        //System.out.println(divToPercent(discountTotal,couponDealTotal,2));

        /*BigDecimal b = discountTotal.divide(couponDealTotal,4,BigDecimal.ROUND_HALF_UP);

        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);

        System.out.println(b.multiply(BigDecimal.valueOf(100)).doubleValue() + "%");*/


    }


    public static String divToPercent(double v1,double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        BigDecimal b = b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);

        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(scale);
        return percent.format(b.doubleValue());
    }

    @Test
    public void test44(){

        System.out.println(System.currentTimeMillis());

    }

}
