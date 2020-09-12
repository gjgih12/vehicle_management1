package com.gj.common.vo.security;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 * @author ：gengjian
 * @date ：Created in 2020/8/31
 */
@Data
public class BaseUserVO implements Serializable {
    private static final long serialVersionUID = -6109980868365297194L;

    private Integer id;
    private String userName;
    private String password;
    private String name;
    private String mobilePhone;
    private String sex;
    private String type;

}
