package com.gj.practice;

import io.minio.MinioClient;
import org.junit.jupiter.api.Test;

/**
 * @author ：gengjian
 * @date ：Created in 2020/9/21
 */
public class MinIoTest {

    private static String url = "https://elearning.jinmaowy.com/minio";  //minio服务的IP端口
    private static String accessKey = "elearning";
    private static String secretKey = "cOE3terjFbBr&haW";

    @Test
    public void test01(){
        String url = getUrl();
        System.out.println(url);
    }


    public  String  getUrl(){
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
            String url = minioClient.presignedGetObject("prod", "/temp/20200916/8c35285ae81efdc91cf6735d9da29904.mp4");
            return url;
        }catch (Exception e){
            return "获取失败";
        }
    }

}
