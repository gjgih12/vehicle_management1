package com.gj.modules.model;

import lombok.Data;

/**
 * 个推实体
 * @author gengjian
 * @date 2020/7/10
 */
@Data
public class PushMessage {

    private Integer model;

    private String cid;

    private String title;

    private String  content;

    private String iconUrl;

    private Integer msgId;

    private String intent;

    private String goUrl;
}
