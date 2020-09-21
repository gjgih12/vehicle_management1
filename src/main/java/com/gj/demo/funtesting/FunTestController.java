package com.gj.demo.funtesting;

import com.gj.common.entity.car.NakedCarEntity;
import com.gj.common.msg.ObjectRestResponse;
import com.gj.modules.business.mapper.NakedCarMapper;
import com.gj.modules.business.service.NakedCarService;
import com.gj.utils.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：gengjian
 * @date ：Created in 2020/9/4
 */
@Slf4j
@RestController
@RequestMapping("/funTest")
public class FunTestController {

    @Autowired
    private NakedCarMapper nakedCarMapper;
    @Autowired
    private NakedCarService nakedCarService;

    @GetMapping("/testException")
    public ObjectRestResponse testException(){

        ObjectRestResponse res = new ObjectRestResponse<>();

        log.info("1111111111111111111111");
        log.info("2222222222222222222222");

        Integer[] strArr = {12,23};
        Integer integer;
        try {
            integer = ceshi3(strArr);
            log.info("第三行数据是："+integer);
        }catch (Exception e){
            log.error("数据失败:{}",strArr);
            //throw new BusinessException("失败");
            res.setStatus(501);
            res.setMessage("参数错误");
            res.setData(strArr);
            return res;
        }

        log.info("444444444444444444444444");

        res.setData(strArr);
        return res;
    }

    public Integer ceshi3(Integer[] str){
        return str[5];
    }

    @RequestMapping("/testObject")
    public String testObject(Integer data){

        NakedCarEntity nakedCarEntity = new NakedCarEntity();
        nakedCarEntity.setcBrand(data.toString());

        RestResponse restResponse = nakedCarService.queryNakedCar(0, 10, nakedCarEntity);

        restResponse.get("rows");

        if(restResponse.get("rows")==null){
            return "集合为空";
        }

        //NakedCarEntity nakedCarEntity = nakedCarService.oneNakedCar(data);
        /*if(nakedCarEntity==null){
            return "对象为空";
        }*/
        return  restResponse.get("rows").toString();
    }


}
