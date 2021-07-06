package com.gj.demo.calldemo.controller;

import com.gj.demo.calldemo.service.CallTestBusOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：gengjian
 * @date ：Created in 2020/8/25
 */
@RestController
@RequestMapping("/callTest")
public class CallController extends AbstractCallController {

    @Autowired
    private CallTestBusOne callTestBusOne;

    @RequestMapping("/callTestMethod")
    public Map<String,Object> callTestMethod(Integer choice){
        Map<String,Object> map = new HashMap<>();

//        CallTest call = callTestFactory.selectInterface(choice);
//        List<String> code = call.getStringTest("字符串code");
        List<String> code = callTestBusOne.getStringTest(choice ,"字符串code");

        map.put("str",code);
        return map;
    }


}
