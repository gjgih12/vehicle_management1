package com.gj.demo.redisdemocontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * redis点赞功能
 * @author gengjian
 * @date 2020/5/15
 */
@RestController
@RequestMapping("fabulous")
public class RedisFabulous {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/addFabulous")
    public void addFabulous(){



    }

    /**
     * redis操作String
     */
    @RequestMapping("/redisDemoString")
    public void redisDemoString(){
        //检查"geng"这个key是否存在 true存在  false不存在
        //Boolean geng = redisTemplate.hasKey("geng");
        //System.out.println(geng);


        //存一个字符串  ,过期时间为10s
        //redisTemplate.opsForValue().set("alll","12345",10, TimeUnit.SECONDS);

        //获取key为geng的value
        /*Object geng = redisTemplate.opsForValue().get("geng");

        //设置键的字符串值并返回其旧值
        Object geng = redisTemplate.opsForValue().getAndSet("geng","ggggg");

        System.out.println(geng);
        */

        //返回key所对应的value值得长度
        //Object geng = redisTemplate.opsForValue().size("geng");

    }

    /**
     * redis操作list
     */
    @RequestMapping("/redisDemoList")
    public void redisDemoList(){

        //返回存储在键中的列表的长度。如果键不存在，则将其解释为空列表，并返回0。当key存储的值不是列表时返回错误
       /* Long aerw = redisTemplate.opsForList().size("aerw");
        System.out.println(aerw);*/

        //将所有指定的值插入存储在键的列表的头部。如果键不存在，则在执行推送操作之前将其创建为空列表。（从左边插入）
        /*redisTemplate.opsForList().leftPush("aerw","diyi");
        redisTemplate.opsForList().leftPush("aerw","dier");
        redisTemplate.opsForList().leftPush("aerw","disan");*/


        //批量把一个数组插入到列表中
        /*String[] strs = new String[]{"1","2","3"};
        redisTemplate.opsForList().leftPushAll("aerw",strs);
        System.out.println(redisTemplate.opsForList().range("aerw",0,-1));*/



    }

    /**
     * redis操作Hash 散列
     */
    @RequestMapping("/redisDemoHash")
    public void redisDemoHash(){


        //将一个map直接存入hash
        HashMap<String, String> gMap = new HashMap<>();
        gMap.put("qq","111");
        gMap.put("aa","221");

        redisTemplate.opsForHash().putAll("agg",gMap);


        //相当于hset 存一个hash key为agg2   元素key为filed3 value为10
        //redisTemplate.opsForHash().put("agg2", "filed3", "10");

        //相当于hexists key filed //是否存在  查看指定hash指定key是否存在
        /*boolean bool = redisTemplate.opsForHash().hasKey("agg2", "filed3");
        System.out.println(bool);*/

        //相当于hgetall {filed1=value1, filed2=value2, filed3=10}获取所有hash的键=值
        /*Map map1 = redisTemplate.opsForHash().entries("agg");
        System.out.println(map1);*/

        //指定hash的指定key的value加5  如果是原数据是float类型会异常
        //redisTemplate.opsForHash().increment("agg2", "filed3", 5);

        //hvals [value1, value2, 17.199999999999999] 获取所有的value
        //System.out.println(redisTemplate.opsForHash().values("agg"));


        //hkeys [filed1, filed2, filed3] //获取所有的键
        /*System.out.println(redisTemplate.opsForHash().keys("agg"));*/



        //hmget  [value1, value2] // 获取对于的键  值 没有就返回空
        /*List<String> list = new ArrayList<>();
        list.add("qq");
        list.add("aa");
        System.out.println(redisTemplate.opsForHash().multiGet("agg", list));*/

        //keys方法，获取key对应的hash表的大小
        //long size = redisTemplate.opsForHash().size("agg");
        //System.out.println(size);
    }

    /**
     * redis操作set  无序集合
     */
    @RequestMapping("/redisDemoSet")
    public void redisDemoSet(){
        //无序集合中添加元素，返回添加个数 也可以直接在add里面添加多个值
        //System.out.println(redisTemplate.opsForSet().add("ass2","123","34","we"));//1

        //查询长度
        //System.out.println(redisTemplate.opsForSet().size("ass2"));//1

        //返回集合中的所有成员
        //System.out.println(redisTemplate.opsForSet().members("ass2"));//[f, g, d, a, e, b, c]

        //移除集合中一个或多个成员
        //System.out.println(redisTemplate.opsForSet().remove("ass2", "123","we"));//2

        //判断 member 元素是否是集合 key 的成员
       // System.out.println(redisTemplate.opsForSet().isMember("ass2", "a"));//false

    }


    /**
     * redis zSet 有序集合
     */
    @RequestMapping("/redisDemoZset")
    public void redisDemoZset(){

        //新增一个有序集合，存在的话为false，不存在的话为true
       // System.out.println(redisTemplate.opsForZSet().add("azzz","123",1.0));

    }


}
