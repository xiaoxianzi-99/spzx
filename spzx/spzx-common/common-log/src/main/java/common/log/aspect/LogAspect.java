package common.log.aspect;

import com.model.entity.system.SysOperLog;
import common.log.annotation.Log;
import common.log.service.LogOperService;
import common.log.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/25
 **/
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Autowired
    private LogOperService logOperService;
    @Around(value = "@annotation(sysLog)")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint, Log sysLog) throws Throwable {

        SysOperLog sysOperLog = new SysOperLog();
        LogUtil.beforeHandleLog(sysLog , joinPoint , sysOperLog) ;
        Object proceed = null;
        try {
            // 执行业务方法,执行被增强的方法
            proceed = joinPoint.proceed();
            // 构建响应结果参数
            LogUtil.afterHandlLog(sysLog , proceed , sysOperLog , 0 , null) ;
        }catch (Throwable e){
            e.printStackTrace();
            LogUtil.afterHandlLog(sysLog , proceed , sysOperLog , 1 , e.getMessage());
            throw new RuntimeException();
        }
        // 保存日志
        logOperService.saveLog(sysOperLog);
        // 返回执行结果
        return proceed;
    }
}
