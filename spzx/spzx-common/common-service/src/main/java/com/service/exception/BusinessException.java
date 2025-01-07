package com.service.exception;

import com.model.vo.common.ResultCodeEnum;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/
@Data
public class BusinessException extends RuntimeException {
    //错误状态码
    private Integer code;
    //错误消息
    private String message;
    //封装错误状态码和错误消息
    private ResultCodeEnum resultCodeEnum;
    public BusinessException(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.resultCodeEnum = resultCodeEnum;
    }
    public BusinessException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
