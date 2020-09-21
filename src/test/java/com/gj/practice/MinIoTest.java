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
            String url = minioClient.getObjectUrl("test", "/test/temp/20200610/e8d56335aa3438f268215b3b611795e8.png");
            return url;
        }catch (Exception e){
            return "获取失败";
        }
    }

}
