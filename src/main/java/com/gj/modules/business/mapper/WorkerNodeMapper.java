package com.gj.modules.business.mapper;


import com.gj.common.entity.WorkerNode;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

public interface WorkerNodeMapper extends BaseMapper<WorkerNode> {
    WorkerNode selectByHostName(@Param("hostName") String hostName);
}
