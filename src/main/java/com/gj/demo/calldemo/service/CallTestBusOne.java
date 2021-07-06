package com.gj.demo.calldemo.service;

import com.gj.demo.calldemo.service.business.CallTestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：gengjian
 * @date ：Created in 2021/7/6
 */
@Service
public class CallTestBusOne extends CallTestBase {

    @Autowired
    private CallTestFactory callTestFactory;
//
//    @Autowired
//    private CallTest callTest;

    public List<String> getStringTest(Integer choice, String code) {
        AbstractCallTestOne call = callTestFactory.selectInterface(choice);
        List<String> codes = call.getStringTest(code);

//        List<String> codes = this.getCallTest().getStringTest(code);
//        List<String> codes = callTest.getStringTest(code);

        return codes;
    }
}
