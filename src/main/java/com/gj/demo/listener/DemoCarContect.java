package com.gj.demo.listener;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：gengjian
 * @date ：Created in 2021/7/16
 */
@Data
public class DemoCarContect implements Serializable {

    private String carId;

    private String carName;

    private String price;

}
