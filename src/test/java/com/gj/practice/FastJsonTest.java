package com.gj.practice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author ：gengjian
 * @date ：Created in 2020/12/18
 */
public class FastJsonTest {

    @Test
    public void Test1(){


        HashMap<Object, Object> map = new HashMap<>();
        map.put("a","11");
        map.put("b",12);

        String s = JSON.toJSONString(map);
        System.out.println("map转换成json======"+s);

        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println("json转换未JSONObject======"+jsonObject);
        System.out.println("b:get======="+jsonObject.get("a"));
        System.out.println("b:getInteger======="+jsonObject.getInteger("a"));

        Object a = jsonObject.get("a");
        Integer a1 = jsonObject.getInteger("a");
        String a2 = jsonObject.getString("a");


    }

}
