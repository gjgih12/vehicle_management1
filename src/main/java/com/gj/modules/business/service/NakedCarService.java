package com.gj.modules.business.service;

import com.gj.common.entity.car.NakedCarEntity;
import com.gj.common.msg.RestResponse;

import java.util.HashMap;
import java.util.List;

public interface NakedCarService {
    RestResponse queryNakedCar(Integer start,Integer pageSize,NakedCarEntity nakedCarEntity);

    void addNakedCar(NakedCarEntity nakedCarEntity);

    NakedCarEntity oneNakedCar(Integer nakedId);

    HashMap<String, List<Object>> ListcarGroupCount();
}
