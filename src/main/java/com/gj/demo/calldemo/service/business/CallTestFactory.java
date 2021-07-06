package com.gj.demo.calldemo.service.business;

import com.gj.demo.calldemo.service.AbstractCallTestOne;
import com.gj.demo.calldemo.service.impl.CallTestOneImpl;
import com.gj.demo.calldemo.service.impl.CallTestTwoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：gengjian
 * @date ：Created in 2020/8/25
 */
@Component
public class CallTestFactory {

    @Autowired
    private CallTestTwoImpl callTestTwo;
    @Autowired
    private CallTestOneImpl callTestOne;

    public AbstractCallTestOne selectInterface(Integer choice) {

        if(choice ==1){
            return callTestOne;
        }
        return callTestTwo;
    }
}
