package com.manager.mapper;

import com.model.entity.system.SysOperLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/25
 **/
@Mapper
public interface SysOperLogMapper {
    void insert(SysOperLog sysOperLog);
}
