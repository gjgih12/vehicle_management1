package com.gj.utils;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author gengjian
 * @date 2020/7/11
 */
public class WorkerAppPushUtil {

    //采用"Java SDK 快速入门"， "第二步 获取访问凭证 "中获得的应用配置，用户可以自行替换


    /**
     * 开发环境配置信息
     */
	/*private static String develop_appId = "JrKGEGLjyX5F5EkjrlMVf7";
    private static String develop_appKey = "vg08KBdhjm6dPFelX9ocGA";
    private static String develop_masterSecret = "nqAJrLTi626sfOMFtJylL5";*/


    /**
     * 市场环境配置信息
     */
//    private static String appId = "NEW6Xa9TuC7lTUoepMy45A";
//    private static String appKey = "KlyrHUVdl16IGeCdS7C3r2";
//    private static String masterSecret = "h9bqx87bIx7a70mf6HP4g6";
//
//
//
//  //测试
//	/*private static String appId = "kPhCXeb6U67Whdwxs2iEc8";
//    private static String appKey = "ZPbIa4gyEA6yRjBUWbpPT4";
//    private static String masterSecret = "Dv2zxK9vvLAuH9XOmHxpp7";*/
//
//
//
//    static String CID = "de291534db03fb76d824630f51596a7c";
//    //别名推送方式
//    // static String Alias = "";
//    static String host = "http://sdk.open.api.igexin.com/apiex.htm";
//
//    /******************************************
//     * 请求方式
//     ******************************************/
//
//    /**
//     * 单个用户
//     * @param
//     * @return
//     */
//    public static String sendSingle(Map<String, Object> map){
//
//        IGtPush push = null;
//
//		/*if(map.get("develop")!=null && map.get("develop").toString().equals("1")){
//			push = new IGtPush(host, develop_appKey, develop_masterSecret);
//		}
//		else{
//			push = new IGtPush(host, appKey, masterSecret);
//		}*/
//        push = new IGtPush(host, appKey, masterSecret);
//
//        int model = 5;
//        SingleMessage message = new SingleMessage();
//
//        switch (model) {
//            case 1:{
//                NotificationTemplate template = notificationTemplateDemo(map);//app
//                message.setData(template);}
//            break;
//            case 2:{
//                LinkTemplate template = linkTemplateDemo(map);//网页
//                message.setData(template);}
//            break;
//            case 3:{
//                NotyPopLoadTemplate template = notyPopLoadTemplateDemo(map);//点击通知弹窗下载模板
//                message.setData(template);}
//            break;
//            case 4:{
//                TransmissionTemplate template = transmissionTemplateDemo(map);//透传消息模版
//                message.setData(template);}
//
//            break;
//            case 5:{
//                TransmissionTemplate template =  getTemplate(map);//iOS模版说明（JAVA）
//                message.setData(template);}
//            break;
//
//            default:{
//                NotificationTemplate template = notificationTemplateDemo(map);//点击通知打开应用模板
//                message.setData(template);}
//            break;
//        }
//        message.setOffline(true);
//        // 离线有效时间，单位为毫秒，可选
//        message.setOfflineExpireTime(24 * 3600 * 1000);
//        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
//        message.setPushNetWorkType(0);
//        Target target = new Target();
//
//       /* if(map.get("develop")!=null && map.get("develop").toString().equals("1")){
//        	target.setAppId(develop_appId);
//		}
//		else{
//			target.setAppId(appId);
//		}*/
//        target.setAppId(appId);
//
//
//        target.setClientId(map.get("sev_cid").toString());
//        //target.setAlias(Alias);
//        IPushResult ret = null;
//        try {
//            ret = push.pushMessageToSingle(message, target);
//        } catch (RequestException e) {
//            e.printStackTrace();
//            ret = push.pushMessageToSingle(message, target, e.getRequestId());
//        }
//        if (ret != null) {
////            System.out.println(ret.getResponse().toString());
//            return ret.getResponse().toString();
//        } else {
////            System.out.println("服务器响应异常");
//            return "";
//        }
//    }
//    /**
//     * 全部用户
//     * @param json
//     * @return
//     */
//    public static String sendAll(Map<String, Object> map){
//        IGtPush push = new IGtPush(host, appKey, masterSecret);
//        int model = 5;
//
//        AppMessage message = new AppMessage();
//        switch (model) {
//            case 1:{
//                NotificationTemplate template = notificationTemplateDemo(map);
//                message.setData(template);}
//            break;
//            case 2:{
//                LinkTemplate template = linkTemplateDemo(map);
//                message.setData(template);}
//            break;
//            case 3:{
//                NotyPopLoadTemplate template = notyPopLoadTemplateDemo(map);
//                message.setData(template);}
//            break;
//            case 4:{
//                TransmissionTemplate template = transmissionTemplateDemo(map);
//                message.setData(template);}
//            break;
//            case 5:{
//                TransmissionTemplate template =  getTemplate(map);
//                message.setData(template);}
//            break;
//
//            default:{
//
//                NotificationTemplate template = notificationTemplateDemo(map);
//                message.setData(template);}
//            break;
//        }
//        message.setOffline(true);
//        //离线有效时间，单位为毫秒，可选
//        message.setOfflineExpireTime(24 * 1000 * 3600);
//        //推送给App的目标用户需要满足的条件
//        AppConditions cdt = new AppConditions();
//        List<String> appIdList = new ArrayList<String>();
//        appIdList.add(appId);
//        message.setAppIdList(appIdList);
//        //手机类型
//        List<String> phoneTypeList = new ArrayList<String>();
//        //省份
//        List<String> provinceList = new ArrayList<String>();
//        //自定义tag
//        List<String> tagList = new ArrayList<String>();
//
//        cdt.addCondition(AppConditions.PHONE_TYPE, phoneTypeList);
//        cdt.addCondition(AppConditions.REGION, provinceList);
//        cdt.addCondition(AppConditions.TAG,tagList);
//        message.setConditions(cdt);
//
//        IPushResult ret = push.pushMessageToApp(message,"任务别名_toApp");
////        System.out.println(ret.getResponse().toString());
//        return ret.getResponse().toString();
//    }
//
//    /******************************************
//     * 模板
//     ******************************************/
//
//    //1.点击通知打开应用模板
//    public static NotificationTemplate notificationTemplateDemo(Map<String, Object> map) {
//        NotificationTemplate template = new NotificationTemplate();
//        // 设置APPID与APPKEY
//        template.setAppId(appId);
//        template.setAppkey(appKey);
//        // 设置通知栏标题与内容
//        template.setTitle(map.get("title").toString());
//        template.setText(map.get("content").toString());
//        // 配置通知栏图标
//        template.setLogo("");
//        // 配置通知栏网络图标
//        template.setLogoUrl("");
//        // 设置通知是否响铃，震动，或者可清除
//        template.setIsRing(true);
//        template.setIsVibrate(true);
//        template.setIsClearable(true);
//        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
//        template.setTransmissionType(1);
//        template.setTransmissionContent("请输入您要透传的内容");
//        // 设置定时展示时间
//        // template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
//        return template;
//    }
//
//    //2. 点击通知打开网页模板
//    public static LinkTemplate linkTemplateDemo(Map<String, Object> map) {
//        LinkTemplate template = new LinkTemplate();
//        // 设置APPID与APPKEY
//        template.setAppId(appId);
//        template.setAppkey(appKey);
//        // 设置通知栏标题与内容
//        template.setTitle(""+map.get("title"));
//        template.setText(""+map.get("content"));
//        // 配置通知栏图标
//        template.setLogo("");
//        // 配置通知栏网络图标，填写图标URL地址
//        template.setLogoUrl("");
//        // 设置通知是否响铃，震动，或者可清除
//        template.setIsRing(true);
//        template.setIsVibrate(true);
//        template.setIsClearable(true);
//        // 设置打开的网址地址
//        template.setUrl("http://www.baidu.com");
//        return template;
//    }
//    //3. 点击通知弹窗下载模板
//    public static NotyPopLoadTemplate notyPopLoadTemplateDemo(Map<String, Object> map) {
//        NotyPopLoadTemplate template = new NotyPopLoadTemplate();
//        // 设置APPID与APPKEY
//        template.setAppId(appId);
//        template.setAppkey(appKey);
//        // 设置通知栏标题与内容
//        template.setNotyTitle("请输入通知栏标题");
//        template.setNotyContent("请输入通知栏内容");
//        // 配置通知栏图标
//        template.setNotyIcon("");
//        // 设置通知是否响铃，震动，或者可清除
//        template.setBelled(true);
//        template.setVibrationed(true);
//        template.setCleared(true);
//        // 设置弹框标题与内容
//        template.setPopTitle("弹框标题");
//        template.setPopContent("弹框内容");
//        // 设置弹框显示的图片
//        template.setPopImage("");
//        template.setPopButton1("下载");
//        template.setPopButton2("取消");
//        // 设置下载标题
//        template.setLoadTitle("下载标题");
//        template.setLoadIcon("file://icon.png");
//        //设置下载地址
//        template.setLoadUrl("http://gdown.baidu.com/data/wisegame/80bab73f82cc29bf/shoujibaidu_16788496.apk");
//        // 设置定时展示时间
//        // template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
//        return template;
//    }
//
//    //4. 透传消息模版
//    public static TransmissionTemplate transmissionTemplateDemo(Map<String, Object> map) {
//        TransmissionTemplate template = new TransmissionTemplate();
//        template.setAppId(appId);
//        template.setAppkey(appKey);
//        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
//        template.setTransmissionType(2);
//        template.setTransmissionContent("请输入需要透传的内容");
//        // 设置定时展示时间
//        // template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
//        return template;
//    }
//
//    //5. iOS模版说明（JAVA）
//    public static TransmissionTemplate getTemplate(Map<String, Object> map) {
//        TransmissionTemplate template = new TransmissionTemplate();
//        template.setAppId(appId);
//        template.setAppkey(appKey);
//        template.setTransmissionContent("透传内容");
//        template.setTransmissionType(2);
//        APNPayload payload = new APNPayload();
//        payload.setBadge(1);
//        payload.setContentAvailable(1);
//        payload.setSound("default");
//        payload.setCategory("$由客户端定义");
//        //简单模式APNPayload.SimpleMsg
//        //payload.setAlertMsg(new APNPayload.SimpleAlertMsg(""+map.get("content")));
//        //字典模式使用下者
//        payload.setAlertMsg(getDictionaryAlertMsg( map));
//        template.setAPNInfo(payload);
//        return template;
//    }
//    private static APNPayload.DictionaryAlertMsg getDictionaryAlertMsg(Map<String, Object> map){
//        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
//        alertMsg.setBody("");
//        alertMsg.setActionLocKey("ActionLockey");
//        alertMsg.setLocKey(""+map.get("content"));
//        alertMsg.addLocArg("");
//        alertMsg.setLaunchImage("launch-image");
//        // IOS8.2以上版本支持
//        alertMsg.setTitle(""+map.get("title"));
//        alertMsg.setTitleLocKey(""+map.get("title"));
//        alertMsg.addTitleLocArg("TitleLocArg");
//        return alertMsg;
//    }
}
