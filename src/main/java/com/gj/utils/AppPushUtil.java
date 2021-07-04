package com.gj.utils;

import com.gj.common.vo.msg.PushMessage;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gengjian
 * @date 2020/7/10
 */
@Data
public class AppPushUtil {

//    @Value("${config.gexin.host}")
//    static String host;
//
//    @Value("${config.gexin.appId}")
//    private String appId;
//
//    @Value("${config.gexin.appKey}")
//    private String appKey;
//
//    @Value("${config.gexin.masterSecret}")
//    private String masterSecret;



//    private static APNPayload getAPNPayload(PushMessage pushMessage) {
//        APNPayload payload = new APNPayload();
//        //在已有数字基础上加1显示，设置为-1时，在已有数字上减1显示，设置为数字时，显示指定数字
//        payload.setContentAvailable(0);//推送直接带有透传数据
//        //ios 12.0 以上可以使用 Dictionary 类型的 sound
//        payload.setSound("default");
//        payload.setCategory("$由客户端定义");
//        payload.addCustomMsg("由客户自定义消息key", "由客户自定义消息value");
//        //简单模式APNPayload.SimpleMsg
//        //payload.setAlertMsg(new APNPayload.SimpleAlertMsg(map.get("title").toString()));
//        payload.setAlertMsg(getDictionaryAlertMsg(pushMessage));  //字典模式使用APNPayload.DictionaryAlertMsg
//        return payload;
//    }
//
//    private static APNPayload.DictionaryAlertMsg getDictionaryAlertMsg(
//            PushMessage pushMessage) {
//        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
//        alertMsg.setBody(pushMessage.getContent());
//       /* alertMsg.setActionLocKey("ActionLockey");
//        alertMsg.setLocKey("loc-key1");
//        alertMsg.addLocArg("loc-ary1");
//        alertMsg.setLaunchImage("launch-image");*/
//        // IOS8.2以上版本支持
//        alertMsg.setTitle(pushMessage.getTitle());
//        /*alertMsg.setTitleLocKey("自定义通知标题");
//        alertMsg.addTitleLocArg("自定义通知标题组");*/
//        return alertMsg;
//    }
//
//    /**
//     * 单个用户推送
//     *
//     * @param pushMessage
//     * @return
//     */
//    public String singlePush(PushMessage pushMessage) {
//        IGtPush push = new IGtPush("http://api.getui.com/apiex.htm",
//                "KlyrHUVdl16IGeCdS7C3r2",
//                "h9bqx87bIx7a70mf6HP4g6");
//        SingleMessage message = new SingleMessage();
//        setMessageData(message, pushMessage);
//        message.setOffline(true);
//        // 离线有效时间，单位为毫秒，可选
//        message.setOfflineExpireTime(24 * 3600 * 1000);
//        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
//        message.setPushNetWorkType(0);
//        Target target = new Target();
//        target.setAppId("NEW6Xa9TuC7lTUoepMy45A");
//        target.setClientId(pushMessage.getCid());
//        IPushResult ret = null;
//        try {
//            ret = push.pushMessageToSingle(message, target);
//        } catch (RequestException e) {
//            e.printStackTrace();
//            ret = push.pushMessageToSingle(message, target, e.getRequestId());
//        }
//        if (ret != null) {
//            return ret.getResponse().toString();
//        } else {
//            System.out.println("个推服务器响应异常");
//            return "";
//        }
//    }
//
//    /**
//     * 设置消息数据
//     *
//     * @param message
//     * @param pushMessage
//     */
//    private void setMessageData(Message message, PushMessage pushMessage) {
//        int model = pushMessage.getModel();
//        switch (model) {
//            case 1: {
//                NotificationTemplate template = notificationTemplateDemo(pushMessage);//app首页
//                message.setData(template);
//            }
//            break;
//            case 2: {
//                StartActivityTemplate template = startActivityTemplateDemo(pushMessage);//app内页
//                message.setData(template);
//            }
//            break;
//            case 3: {
//                LinkTemplate template = linkTemplateDemo(pushMessage);//网页
//                message.setData(template);
//            }
//            break;
//            case 4: {
//                TransmissionTemplate template = transmissionTemplateDemo(pushMessage);//透传消息模版
//                message.setData(template);
//            }
//            break;
//            case 5: {
//                TransmissionTemplate template = getTemplate(pushMessage);//iOS模版说明（JAVA）
//                message.setData(template);
//            }
//            break;
//            case 6: {
//                RevokeTemplate template = revokeTemplateDemo(pushMessage);//通知消息撤回
//                message.setData(template);
//            }
//            break;
//            default: {
//                NotificationTemplate template = notificationTemplateDemo(pushMessage);//点击通知打开应用模板
//                message.setData(template);
//            }
//            break;
//        }
//    }
//
//    /**
//     * 用户列表推送  单次推送数量限制1000以内，此接口频次限制200万次/天
//     *
//     * @param pushMessage
//     */
//    public String listPush(PushMessage pushMessage) {
//        IIGtPush push = new IGtPush("http://sdk.open.api.igexin.com/apiex.htm",
//                "KlyrHUVdl16IGeCdS7C3r2",
//                "h9bqx87bIx7a70mf6HP4g6");
//
//        ListMessage message = new ListMessage();
//
//        setMessageData(message, pushMessage);
//
//        // 设置消息离线，并设置离线时间
//
//        message.setOffline(true);
//
//        // 离线有效时间，单位为毫秒，可选
//
//        message.setOfflineExpireTime(24 * 3600 * 1000);
//
//        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
//
//        message.setPushNetWorkType(0);
//
//        // 配置推送目标
//
//        List targets = new ArrayList<>();
//
//        String[] cids = pushMessage.getCid().split(",");
//
//        if (cids.length > 0) {
//
//            for (String cid : cids) {
//
//                Target target = new Target();
//
//                target.setAppId("NEW6Xa9TuC7lTUoepMy45A");
//
//                target.setClientId(cid);
//
//                targets.add(target);
//
//            }
//
//            // taskId用于在推送时去查找对应的message
//
//            String taskId = push.getContentId(message);
//
//            IPushResult ret = null;
//
//            try {
//
//                ret = push.pushMessageToList(taskId, targets);
//
//            } catch (RequestException e) {
//
//                e.printStackTrace();
//
//                ret = push.pushMessageToList(taskId, targets);
//
//            }
//
//            if (ret != null) {
//
//                return ret.getResponse().toString();
//
//            } else {
//
//                System.out.println("个推服务器响应异常");
//
//                return "";
//
//            }
//
//        }
//
//        return "";
//
//    }
//
//    /**
//     * 全部用户推送
//     *
//     * @param pushMessage
//     * @return
//     */
//    public String allPush(PushMessage pushMessage) {
//
//        IGtPush push = new IGtPush(host, appKey, masterSecret);
//
//        AppMessage message = new AppMessage();
//
//        setMessageData(message, pushMessage);
//
//        message.setOffline(true);
//
//        //离线有效时间，单位为毫秒，可选
//
//        message.setOfflineExpireTime(24 * 1000 * 3600);
//
//        //推送给App的目标用户需要满足的条件
//
//        AppConditions cdt = new AppConditions();
//
//        List appIdList = new ArrayList();
//
//        appIdList.add(appId);
//
//        message.setAppIdList(appIdList);
//
//        //手机类型
//
//        List phoneTypeList = new ArrayList();
//
//        //省份
//
//        List provinceList = new ArrayList();
//
//        //自定义tag
//
//        List tagList = new ArrayList();
//
//        cdt.addCondition(AppConditions.PHONE_TYPE, phoneTypeList);
//
//        cdt.addCondition(AppConditions.REGION, provinceList);
//
//        cdt.addCondition(AppConditions.TAG, tagList);
//
//        message.setConditions(cdt);
//
//        IPushResult ret = push.pushMessageToApp(message, "任务别名_toApp");
//
//        return ret.getResponse().toString();
//
//    }
//
//    //3 点击通知打开网页模板
//
//    /****************************************************************************************************************
//     模板 1-打开应用首页 2-打开应用内页面 3-点击通知打开网页模板 4-透传消息模版 5-iOS模版说明 6-通知消息撤回 7-停止批量推
//     *****************************************************************************************************************/
//    //1 打开应用首页
//    public NotificationTemplate notificationTemplateDemo(PushMessage pushMessage) {
//
//        NotificationTemplate template = new NotificationTemplate();
//
//        template.setAppId("NEW6Xa9TuC7lTUoepMy45A");
//
//        template.setAppkey("KlyrHUVdl16IGeCdS7C3r2");
//
//        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
//
//        template.setTransmissionType(1);
//
//        //透传内容，不在通知栏中展示，自定义内容，开发者自行处理，不支持转义字符
//
////规定intent规则：zw://项目名/activity 全路径?parm1=value1&parm2=value2
//
//        template.setTransmissionContent(pushMessage.getIntent());
//
//        Style0 style = new Style0();
//
//        // 设置通知栏标题与内容
//
//        style.setTitle(pushMessage.getTitle());
//
//        style.setText(pushMessage.getContent());
//
//        // 配置通知栏图标
//
//        style.setLogo("icon.png");
//
//        // 配置通知栏网络图标
//
//        style.setLogoUrl(pushMessage.getIconUrl());
//
//        // 设置通知是否响铃，震动，或者可清除
//
//        style.setRing(true);
//
//        style.setVibrate(true);
//
//        style.setClearable(true);
//
//        //style.setChannel("默认channel");
//
//        //style.setChannelName("默认channel名称");
//
//        //style.setChannelLevel(3);//3：有声音，有震动，锁屏和通知栏中都显示，通知唤醒屏幕。（推荐）
//
//        template.setStyle(style);
//
//        // 设置定时展示时间，安卓机型可用
//
//// template.setDuration("2019-08-16 11:40:00", "2019-08-16 12:24:00");
//
//// 消息覆盖
//
//        template.setNotifyid(pushMessage.getMsgId()); // 在消息推送的时候设置自定义的notifyid。如果需要覆盖此条消息，则下次使用相同的notifyid发一条新的消息。客户端sdk会根据notifyid进行覆盖。
//
//        return template;
//
//    }
//
//    //2 打开应用内页面
//    public StartActivityTemplate startActivityTemplateDemo(PushMessage pushMessage) {
//
//        StartActivityTemplate template = new StartActivityTemplate();
//
//        template.setAppId(appId);
//
//        template.setAppkey(appKey);
//
//        Style0 style = new Style0();
//
//        // 设置通知栏标题与内容
//
//        style.setTitle(pushMessage.getTitle());
//
//        style.setText(pushMessage.getContent());
//
//        // 配置通知栏图标
//
//        style.setLogo("icon.png");
//
//        // 配置通知栏网络图标
//
//        style.setLogoUrl(pushMessage.getIconUrl());
//
//        // 设置通知是否响铃，震动，或者可清除
//
//        style.setRing(true);
//
//        style.setVibrate(true);
//
//        style.setClearable(true);
//
//        //style.setChannel("默认channel");
//
//        //style.setChannelName("默认channel名称");
//
//        //style.setChannelLevel(3);
//
//        template.setStyle(style);
//
//        //intent:#Intent;component=你的包名/你要打开的 activity 全路径;S.parm1=value1;S.parm2=value2;end
//
//        //String intent = "intent:#Intent;component=com.yourpackage/.NewsActivity;end";
//
//        template.setIntent(pushMessage.getIntent()); //目标页面地址,最大长度限制为1000
//
//        // 设置定时展示时间，安卓机型可用
//
//        // template.setDuration("2019-08-16 11:40:00", "2019-08-16 12:24:00");
//
//        // 消息覆盖
//
//        template.setNotifyid(pushMessage.getMsgId()); // 在消息推送的时候设置自定义的notifyid。如果需要覆盖此条消息，则下次使用相同的notifyid发一条新的消息。客户端sdk会根据notifyid进行覆盖。
//
//        return template;
//
//    }
//
//    public LinkTemplate linkTemplateDemo(PushMessage pushMessage) {
//
//        LinkTemplate template = new LinkTemplate();
//
//        template.setAppId(appId);
//
//        template.setAppkey(appKey);
//
//        Style0 style = new Style0();
//
//        // 设置通知栏标题与内容
//
//        style.setTitle(pushMessage.getTitle());
//
//        style.setText(pushMessage.getContent());
//
//        // 配置通知栏图标
//
//        style.setLogo("icon.png");
//
//        // 配置通知栏网络图标
//
//        style.setLogoUrl(pushMessage.getIconUrl());
//
//        // 设置通知是否响铃，震动，或者可清除
//
//        style.setRing(true);
//
//        style.setVibrate(true);
//
//        style.setClearable(true);
//
//        //style.setChannel("环球直聘-191022");
//
//        //style.setChannelName("环球直聘");
//
//        //style.setChannelLevel(3);
//
//        template.setStyle(style);
//
//        // 设置打开的网址地址
//
//        template.setUrl(pushMessage.getGoUrl());
//
//        // 设置定时展示时间，安卓机型可用
//
//        template.setNotifyid(pushMessage.getMsgId()); // 在消息推送的时候设置自定义的notifyid。如果需要覆盖此条消息，则下次使用相同的notifyid发一条新的消息。客户端sdk会根据notifyid进行覆盖。
//
//        return template;
//
//    }
//
//    //4 透传消息模版
//    public TransmissionTemplate transmissionTemplateDemo(PushMessage pushMessage) {
//
//        TransmissionTemplate template = new TransmissionTemplate();
//
//        template.setAppId(appId);
//
//        template.setAppkey(appKey);
//
//        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
//
//        template.setTransmissionType(2);
//
//        template.setTransmissionContent(pushMessage.getIntent());
//
//        // 设置定时展示时间
//
//// template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
//
//        return template;
//
//    }
//
//    //5 iOS模版说明（JAVA）
//    public TransmissionTemplate getTemplate(PushMessage pushMessage) {
//
//        TransmissionTemplate template = new TransmissionTemplate();
//
//        template.setAppId(appId);
//
//        template.setAppkey(appKey);
//
//        template.setTransmissionContent(pushMessage.getIntent());//透传内容
//
//        template.setTransmissionType(2);
//
//        template.setAPNInfo(getAPNPayload(pushMessage));
//
//        return template;
//
//    }
//
//    //6.通知消息撤回
//    public RevokeTemplate revokeTemplateDemo(PushMessage pushMessage) {
//
//        RevokeTemplate template = new RevokeTemplate();
//
//        template.setAppId(appId);
//
//        template.setAppkey(appKey);
//
//        template.setOldTaskId(pushMessage.getMsgId().toString());
//
//        template.setForce(false);
//
//        return template;
//
//    }
//
//    //7.停止批量推
//    public void stopListPushDemo(String contentId) {
//
//        IIGtPush push = new IGtPush(host, appKey, masterSecret);
//
//        push.stop(contentId);
//
//    }


    /*public static void main(String[] args) {
        PushMessage pushMessage = new PushMessage();
        pushMessage.setModel(8);//模式，详看代码
        //待推送的用户ID
        pushMessage.setCid("de291534db03fb76d824630f51596a7c");
        pushMessage.setTitle("测试标题");
        pushMessage.setContent("测试内容");
        pushMessage.setIconUrl("测试网络icon");
        pushMessage.setMsgId(123);//可用户覆盖的消息id
        pushMessage.setIntent("透传内容");
        String strResponse = new AppPushUtil().singlePush(pushMessage);
        System.out.println("返回内容：" + strResponse);
    }*/

}
