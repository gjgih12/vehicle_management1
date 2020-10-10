package com.gj.common.uid;

import com.baidu.fsg.uid.worker.WorkerIdAssigner;
import com.baidu.fsg.uid.worker.WorkerNodeType;
import com.gj.common.entity.WorkerNode;
import com.gj.modules.business.mapper.WorkerNodeMapper;
import com.gj.utils.DockerUtil;
import com.gj.utils.NetworkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class ConfigWorkerIdAssigner implements WorkerIdAssigner {
    @Autowired
    WorkerNodeMapper workerNodeMapper;

    @Override
    public long assignWorkerId() {
        WorkerNode workerNode = new WorkerNode();
        int type = WorkerNodeType.ACTUAL.value();
        String hostName = "", port = "";
        if (DockerUtil.isDocker()) {
            type = WorkerNodeType.CONTAINER.value();
            hostName = DockerUtil.getDockerHost();
            port = DockerUtil.getDockerPort();
            workerNode.setPort(port);
        } else {
            hostName = NetworkUtil.getLocalAddress();
            Random r = new Random();
            port = System.currentTimeMillis() + "-" + r.nextInt(100000);
        }
        workerNode.setType(type);
        workerNode.setHostName(hostName);

        WorkerNode tmpWorkerNode = workerNodeMapper.selectOne(workerNode);
        if (tmpWorkerNode != null) {
            return tmpWorkerNode.getId();
        }

        workerNode.setPort(port);
        Date curDate = new Date();
        workerNode.setLaunchDate(curDate);
        workerNode.setCreated(curDate);
        workerNodeMapper.insertSelective(workerNode);

        workerNode.setLaunchDate(null);
        workerNode.setCreated(null);
        workerNode = workerNodeMapper.selectOne(workerNode);

        return workerNode.getId();
    }
}
