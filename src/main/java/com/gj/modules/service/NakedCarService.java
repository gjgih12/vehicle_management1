package com.gj.modules.service;

import com.gj.modules.model.NakedCarEntity;
import com.gj.utils.RestResponse;

import java.util.HashMap;
import java.util.List;

public interface NakedCarService {
    RestResponse queryNakedCar(Integer start,Integer pageSize,NakedCarEntity nakedCarEntity);

    void addNakedCar(NakedCarEntity nakedCarEntity);

    NakedCarEntity oneNakedCar(Integer nakedId);

    HashMap<String, List<Object>> ListcarGroupCount();
}
