package com.gj.modules.controller.funtesting;

import com.gj.modules.model.PushMessage;
import com.gj.utils.AppPushUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试个推消息请求
 * @author gengjian
 * @date 2020/7/10
 */

@RestController
@RequestMapping("pushNews")
@Slf4j
public class AppPushMessageController {

    @RequestMapping("/appPushNews")
    public void appPushNews(){
        PushMessage pushMessage = new PushMessage();
        pushMessage.setModel(8);//模式，详看代码
        //待推送的用户ID
        pushMessage.setCid("de291534db03fb76d824630f51596a7c");
        pushMessage.setTitle("测试标题");
        pushMessage.setContent("测试内容");
        pushMessage.setIconUrl("测试网络icon");
        pushMessage.setMsgId(123);//可用户覆盖的消息id
        pushMessage.setIntent("透传内容");
        AppPushUtil appPushUtil = new AppPushUtil();
        log.info(appPushUtil.getAppId());
        String strResponse = new AppPushUtil().singlePush(pushMessage);
        System.out.println("返回内容：" + strResponse);

    }

}
