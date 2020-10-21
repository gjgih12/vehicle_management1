package com.gj.common.constant;

/**
 * rest接口返回码
 *
 * @author ace
 * @version 2017/8/23
 */
public class RestCodeConstants {

    public static final Integer EX_SUCCESS = 200;
    // 用户token异常
    public static final Integer EX_USER_INVALID_CODE = 40101;
    public static final Integer EX_USER_PASS_INVALID_CODE = 40001;
    public static final Integer EX_USER_FORBIDDEN_CODE = 40131;
    // 客户端token异常
    public static final Integer EX_CLIENT_INVALID_CODE = 40301;
    public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
    // 业务异常返回码
    public static final Integer EX_BUSINESS_BASE_CODE = 30101;
    public static final Integer OPEN_ID_NOT_EXISTED = 30201;

    //银联支付
    public static final Integer UMS_PAY_ERROR_CODE = 60001;

    //crm异常
    public static final Integer CRM_ERROR_CODE = 61001;

    //app版本异常，app端需升级版本
    public static final Integer APP_VERSION_ERROR_CODE =10001;


}
