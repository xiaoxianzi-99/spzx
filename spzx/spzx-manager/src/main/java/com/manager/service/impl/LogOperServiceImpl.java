package com.manager.service.impl;

import com.manager.mapper.SysOperLogMapper;
import com.model.entity.system.SysOperLog;
import common.log.service.LogOperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/25
 **/
@Service
public class LogOperServiceImpl implements LogOperService {
    @Autowired
    private SysOperLogMapper sysOperLogMapper;

    @Override
    @Async
    public void saveLog(SysOperLog sysOperLog) {
        sysOperLogMapper.insert(sysOperLog);
    }
}
