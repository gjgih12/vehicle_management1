package com.gj.modules.mapper;

import com.gj.modules.model.NakedCarEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NakedCarMapper {


    List<NakedCarEntity> nakedCarMapper(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("nakedCar") NakedCarEntity nakedCarEntity);

    Integer countNaked(@Param("nakedCar") NakedCarEntity nakedCarEntity);

    void addNakedCar(@Param("nakedCar") NakedCarEntity nakedCarEntity);

    NakedCarEntity oneNakedCar(Integer nakedId);

    void updNakedCar(@Param("nakedCar") NakedCarEntity nakedCarEntity);

    List<Object> listCarBrand();

    List<Object> listCabrandCount();
}
