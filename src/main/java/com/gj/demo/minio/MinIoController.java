package com.gj.demo.minio;

import io.minio.MinioClient;
import io.minio.ObjectStat;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author gengjian
 * @date 2020/9/21
 */
@Slf4j
@RestController
@RequestMapping("/minio")
public class MinIoController {

    private static String url = "http://192.168.6.128:9000";  //minio服务的IP端口
    private static String accessKey = "minioadmin";
    private static String secretKey = "minioadmin";

    @RequestMapping("/getUrl")
    public  String  getUrl(){
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
            String url = minioClient.getObjectUrl("test", "minio/test/1-1PG3152R5.jpg");
            return url;
        }catch (Exception e){
            return e.toString();
        }
    }

    @RequestMapping("/download/{fileName}")
    public void download(HttpServletResponse response, @PathVariable("fileName") String fileName) {

        InputStream in = null;
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
            ObjectStat stat = minioClient.statObject("geng", fileName);
            response.setContentType(stat.contentType());
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

            in = minioClient.getObject("geng", fileName);
            IOUtils.copy(in, response.getOutputStream());
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

}
