package com.gj.demo.funtesting;

import com.gj.common.vo.msg.PushMessage;
import com.gj.utils.AppPushUtil;
import com.gj.utils.WorkerAppPushUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试个推消息请求
 * @author gengjian
 * @date 2020/7/10
 */

@RestController
@RequestMapping("pushNews")
@Slf4j
public class AppPushMessageController {

//    @RequestMapping("/appPushNews")
//    public String appPushNews(String userCid){
//        PushMessage pushMessage = new PushMessage();
//        pushMessage.setModel(8);//模式，详看代码
//        //待推送的用户ID
//        pushMessage.setCid(userCid);
//        pushMessage.setTitle("测试标题");
//        pushMessage.setContent("测试内容");
//        pushMessage.setIconUrl("测试网络icon");
//        pushMessage.setMsgId(123);//可用户覆盖的消息id
//        pushMessage.setIntent("透传内容");
//        String strResponse = new AppPushUtil().singlePush(pushMessage);
//        System.out.println("返回内容：" + strResponse);
//        return strResponse;
//    }
//
//    @RequestMapping("/appPushNews2")
//    public String appPushNews2(String userCid){
//        Map<String, Object> server= new HashMap<>();
//        server.put("sev_cid",userCid);
//        server.put("model",8);//启用 模板5  ios模板
//        server.put("title", "通知");
//        server.put("content", "您有新的订单");
//        //server.put("page", "PC0002");
//        String strResponse = WorkerAppPushUtil.sendSingle(server);
//        return strResponse;
//    }

}
