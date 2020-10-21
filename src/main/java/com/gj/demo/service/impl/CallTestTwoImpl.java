package com.gj.demo.service.impl;

import com.gj.demo.service.CallTestBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：gengjian
 * @date ：Created in 2020/8/25
 */
@Slf4j
@Component
public class CallTestTwoImpl extends CallTestBase {

    @Override
    public List<String> getStringTest(String strCode) {
        List<String> str = Arrays.asList("花","草","树",strCode);
        log.info("第二个实现类里字符串执行"+strCode);
        return str;
    }

    @Override
    public List<Integer> getIntegerTest(Integer intCode) {
        List<Integer> ints = Arrays.asList(100,101,102,intCode);
        log.info("第二个实现类里数字执行"+intCode);
        return ints;
    }

    @Override
    public List<Double> getDoubleTest(Double douCode) {
        List<Double> dou = Arrays.asList(100.1,101.1,102.1,douCode);
        log.info("第二个实现类里小数执行"+douCode);
        return dou;
    }
}
