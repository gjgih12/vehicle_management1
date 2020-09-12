package com.gj.modules.business.controller;

import com.gj.common.entity.car.NakedCarEntity;
import com.gj.modules.business.service.NakedCarService;
import com.gj.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author gengjian
 * @date 2020/1/1
 */
@RestController
@RequestMapping("car/nakedCar")
public class NakedCarController {

    @Autowired
    private NakedCarService nakedCarService;

    /**
     * 查询裸车
     * @return
     */
    @RequestMapping("/queryNakedCar")
    public RestResponse queryNakedCar(Integer start, Integer pageSize, NakedCarEntity nakedCarEntity){

        return nakedCarService.queryNakedCar(start,pageSize,nakedCarEntity);
    }

    /**
     * 新增
     * @param
     */
    @RequestMapping("/addNakedCar")
    public void addNakedCar(NakedCarEntity nakedCarEntity) {

        nakedCarService.addNakedCar(nakedCarEntity);
    }

    /**
     * 修改回显
     * @param nakedId
     * @return
     */
    @GetMapping("/oneNakedCar")
    public RestResponse oneNakedCar(Integer nakedId){
        NakedCarEntity nakedCarEntity = nakedCarService.oneNakedCar(nakedId);
        return RestResponse.success().put("nakedCarEntity",nakedCarEntity);
    }

}
