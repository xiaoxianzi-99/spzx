package com.service.handle;

import com.model.vo.common.Result;
import com.service.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * 统一异常处理类
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.build(null,201, e.getMessage());
    }
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result error(BusinessException e) {
        e.printStackTrace();
        return Result.build(null,e.getCode(),e.getMessage());
    }
}
