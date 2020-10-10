package com.gj.common.uid;

import com.baidu.fsg.uid.impl.DefaultUidGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UidGenerator {

    @Autowired
    ConfigWorkerIdAssigner configWorkerIdAssigner;

    private DefaultUidGenerator defaultUidGenerator;

    public boolean init() {
        defaultUidGenerator = new DefaultUidGenerator();
        defaultUidGenerator.setTimeBits(30);
        defaultUidGenerator.setWorkerBits(20);
        defaultUidGenerator.setSeqBits(13);
        defaultUidGenerator.setEpochStr("2020-02-01");
        defaultUidGenerator.setWorkerIdAssigner(configWorkerIdAssigner);
        try {
            defaultUidGenerator.afterPropertiesSet();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    public long getUid() {
        return defaultUidGenerator.getUID();
    }
}
