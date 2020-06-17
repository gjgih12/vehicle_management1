package com.gj.modules.service.impl;

import com.gj.modules.mapper.NakedCarMapper;
import com.gj.modules.model.NakedCarEntity;
import com.gj.modules.service.NakedCarService;
import com.gj.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author gengjian
 * @date 2020/1/1
 */
@Service
public class NakedCarServiceImpl implements NakedCarService {

    @Autowired
    private NakedCarMapper nakedCarMapper;

    /**
     * 查询列表数据
     * @param start
     * @param pageSize
     * @param nakedCarEntity
     * @return
     */
    @Override
    public RestResponse queryNakedCar(Integer start,Integer pageSize,NakedCarEntity nakedCarEntity) {

        Integer nakedCount = nakedCarMapper.countNaked(nakedCarEntity);

        List<NakedCarEntity> nakedCarList = nakedCarMapper.nakedCarMapper(start,pageSize,nakedCarEntity);

        return RestResponse.success().put("rows",nakedCarList).put("total",nakedCount);
    }

    /**
     * 新增数据
     * @param nakedCarEntity
     */
    @Override
    public void addNakedCar(NakedCarEntity nakedCarEntity) {

        if(nakedCarEntity.getId()!=null){
            nakedCarMapper.updNakedCar(nakedCarEntity);
        }else {
            nakedCarMapper.addNakedCar(nakedCarEntity);
        }


    }

    /**
     * 根据id查询单条数据
     * @param nakedId
     * @return
     */
    @Override
    public NakedCarEntity oneNakedCar(Integer nakedId) {

        return nakedCarMapper.oneNakedCar(nakedId);
    }

    @Override
    public HashMap<String, List<Object>> ListcarGroupCount() {

        HashMap<String,List<Object>> eCarMap = new HashMap<>();

        List<Object> brandList = nakedCarMapper.listCarBrand();
        List<Object> brandCountList = nakedCarMapper.listCabrandCount();

        eCarMap.put("brandList",brandList);
        eCarMap.put("brandCountList",brandCountList);

        return eCarMap;
    }
}
