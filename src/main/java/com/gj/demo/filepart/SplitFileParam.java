package com.gj.demo.filepart;

/**
 * @author gengjian
 * @date 2020/9/23
 */
public class SplitFileParam {

    public static String file="D:\\miniodata\\test\\temp\\20200927\\05a89b4e0ab5f0f251d9938b6af727d8\\05a89b4e0ab5f0f251d9938b6af727d8.mp4"; //文件的路径
    public static String outfile="D:\\miniodata\\test\\temp\\20200927\\05a89b4e0ab5f0f251d9938b6af727d8.mp4"; //文件的路径
    public static int count=10;   //将文件切割成多少份  这个 不是符合我的要求 不予使用
    public static int maxSize=300*1024;   //将文件切割成多大
}
