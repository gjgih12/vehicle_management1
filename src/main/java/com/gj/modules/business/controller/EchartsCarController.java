package com.gj.modules.business.controller;

import com.gj.modules.business.service.NakedCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author gengjian
 * @date 2020/6/12
 */

/**
 * 统计图
 */
@RestController
@RequestMapping("/echartsCar")
public class EchartsCarController {

    @Autowired
    private NakedCarService nakedCarService;

    /**
     * 查询各品牌车与数量
     * @return
     */
    @GetMapping("/carGroupCount")
    public HashMap<String, List<Object>> carGroupCount(){

        HashMap<String, List<Object>> eCarMap = nakedCarService.ListcarGroupCount();

        return eCarMap;
    }


}
