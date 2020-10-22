package com.gj.testpojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：gengjian
 * @date ：Created in 2020/9/17
 */
@Data
public class StudentDemo implements Serializable {
    private static final long serialVersionUID = -7473157789814799036L;


    private String id;

    private String name;

    private List<CarDemo> stuCarDemo;


}
