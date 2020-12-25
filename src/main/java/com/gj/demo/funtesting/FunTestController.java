package com.gj.demo.funtesting;

import com.gj.common.entity.car.NakedCarEntity;
import com.gj.common.msg.ObjectRestResponse;
import com.gj.common.msg.RestResponse;
import com.gj.modules.business.mapper.NakedCarMapper;
import com.gj.modules.business.service.NakedCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * @author ：gengjian
 * @date ：Created in 2020/9/4
 */
@Slf4j
@RestController
@RequestMapping("/funTest")
public class FunTestController {

    @Autowired
    private NakedCarMapper nakedCarMapper;
    @Autowired
    private NakedCarService nakedCarService;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/testException")
    public ObjectRestResponse testException(){

        ObjectRestResponse res = new ObjectRestResponse<>();

        log.info("1111111111111111111111");
        log.info("2222222222222222222222");

        Integer[] strArr = {12,23};
        Integer integer;
        try {
            integer = ceshi3(strArr);
            log.info("第三行数据是："+integer);
        }catch (Exception e){
            log.error("数据失败:{}",strArr);
            //throw new BusinessException("失败");
            res.setStatus(501);
            res.setMessage("参数错误");
            res.setData(strArr);
            return res;
        }

        log.info("444444444444444444444444");

        res.setData(strArr);
        return res;
    }

    public Integer ceshi3(Integer[] str){
        return str[5];
    }

    @RequestMapping("/testObject")
    public String testObject(Integer data){

        NakedCarEntity nakedCarEntity = new NakedCarEntity();
        nakedCarEntity.setcBrand(data.toString());

        RestResponse restResponse = nakedCarService.queryNakedCar(0, 10, nakedCarEntity);

        restResponse.get("rows");

        if(restResponse.get("rows")==null){
            return "集合为空";
        }

        //NakedCarEntity nakedCarEntity = nakedCarService.oneNakedCar(data);
        /*if(nakedCarEntity==null){
            return "对象为空";
        }*/
        return  restResponse.get("rows").toString();
    }

    /**
     * 测试下载远程视频
     * @return
     */
    @RequestMapping("/download")
    public String download() {

        //String url = "http://211.94.93.168:7580/prod/temp/20200904/f49b0d5c7835dfd275f16b6a4a76048f.mp4";   //13.5M
        String url = "http://211.94.93.168:7580/prod/temp/20200618/ce21f8d3453cf461d364386f7448571a.mp4";   //50M

        //String url = "https://elearning-oss.jinmaowy.com/prod/temp/20200904/f49b0d5c7835dfd275f16b6a4a76048f.mp4";

        String name= System.currentTimeMillis()+".mp4";

        String dir = "D:\\mp4";

        System.out.println(name+"========开始========"+System.currentTimeMillis());

        downRemoteFile(url,name,dir);
        System.out.println(name+"========结束========"+System.currentTimeMillis());

        return name;
    }

    public static String downRemoteFile(String remoteFileUrl, String saveFileName, String saveDir) {

        HttpURLConnection conn = null;
        OutputStream oputstream = null;
        InputStream iputstream = null;

        try {
            // 创建保存文件的目录
            File savePath = new File(saveDir);
            if (!savePath.exists()) {
                savePath.mkdir();
            }
            // 创建保存的文件
            File file = new File(savePath + "/" + saveFileName);
            if (file != null && !file.exists()) {
                file.createNewFile();
            }

            URL url = new URL(remoteFileUrl);
            // 将url以open方法返回的urlConnection连接强转为HttpURLConnection连接(标识一个url所引用的远程对象连接)
            // 此时cnnection只是为一个连接对象,待连接中
            conn = (HttpURLConnection) url.openConnection();
            // 设置是否要从 URL连接读取数据,默认为true
            conn.setDoInput(true);
            // 建立连接
            // (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)
            conn.connect();
            // 连接发起请求,处理服务器响应 (从连接获取到输入流)
            iputstream = conn.getInputStream();
            // 创建文件输出流，用于保存下载的远程文件
            oputstream = new FileOutputStream(file);
            //  用来存储响应数据
            byte[] buffer = new byte[4 * 1024];
            int byteRead = -1;
            //  循环读取流
            while ((byteRead = (iputstream.read(buffer))) != -1) {
                oputstream.write(buffer, 0, byteRead);
            }
            //  输出完成后刷新并关闭流
            oputstream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //  重要且易忽略步骤 (关闭流,切记!)
                if (iputstream != null) {
                    iputstream.close();
                }
                if (oputstream != null) {
                    oputstream.close();
                }
                // 销毁连接
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 返回保存后的文件路径
        return saveDir + "/" + saveFileName;
    }


    @GetMapping("/testObjectJson")
    public NakedCarEntity testObjectJson(){
        NakedCarEntity nakedCarEntity = new NakedCarEntity();
        nakedCarEntity.setcBrand("12313");
        return nakedCarEntity;
    }

    @PostMapping("/testRestApi")
    public NakedCarEntity testRestApi(){
        NakedCarEntity nakedCarEntity = new NakedCarEntity();
        nakedCarEntity.setId(1);
        nakedCarEntity.setcBrand("保时捷");
        nakedCarEntity.setcName("卡宴");
        nakedCarEntity.setcColor(1);
        nakedCarEntity.setcLocal("中国");
        nakedCarEntity.setcType(1);
        nakedCarEntity.setcPrice(123.14);
        nakedCarEntity.setcDate(new Date());




        return nakedCarEntity;
    }

    @GetMapping("/redisDemo")
    public ObjectRestResponse redisDemo(){
        ObjectRestResponse<Object> result = new ObjectRestResponse<>();

        //redisTemplate.opsForValue().set("GENG","123456");

        //String geng = (String) redisTemplate.opsForValue().get("GENG");
        Boolean geng = redisTemplate.hasKey("GENG");
        result.setData(geng);

        return result;
    }



}
