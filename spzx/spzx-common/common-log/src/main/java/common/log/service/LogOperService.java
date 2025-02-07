package common.log.service;

import com.model.entity.system.SysOperLog;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/25
 **/
public interface LogOperService {
    void saveLog(SysOperLog sysOperLog);
}
