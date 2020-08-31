package com.gj.modules.routecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 裸车列表
 * @author gengjian
 * @date 2020/4/5
 */
@Controller
public class NakedUiController {

    /**
     * 查询裸车列表
     * @return
     */
    @RequestMapping("/toNakedCarShow")
    public String toCouponList(){
        return "naked/NakedCarShow";
    }

    /**
     * 裸车新增与修改的弹框
     * @return
     */
    @RequestMapping("/toAddNakedDialog")
    public String toAddNakedDialog(){
        return "naked/dialogNaked";
    }

    /**
     * 车统计图
     */
    @RequestMapping("/toCarEcharts")
    public String toCarEcharts(){
        return "echarts/CarEcharts";
    }

    /**
     * 登录界面
     * @return
     */
    @RequestMapping("/toLogin")
    public String login(){
        return "index/Login";
    }


}
