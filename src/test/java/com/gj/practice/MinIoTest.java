package com.gj.practice;

import io.minio.MinioClient;
import org.junit.jupiter.api.Test;

/**
 * @author ：gengjian
 * @date ：Created in 2020/9/21
 */
public class MinIoTest {

    private static String url = "http://192.168.6.128:9000";  //minio服务的IP端口
    private static String accessKey = "minioadmin";
    private static String secretKey = "minioadmin";

    @Test
    public void test01(){
        String url = getUrl();
        System.out.println(url);
    }


    public  String  getUrl(){
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
            String url = minioClient.getObjectUrl("geng", "41adf3bcf0fb44bd9e026adeb4d88eea.jpeg");
            return url;
        }catch (Exception e){
            return "获取失败";
        }
    }

}
