package com.model.entity.system;

import com.model.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/25
 **/
@Data
public class SysOperLog extends BaseEntity {
    private String title;					// 模块标题
    private String method;					// 方法名称
    private String requestMethod;			// 请求方式
    private String operatorType;			// 操作类别（0其它 1后台用户 2手机端用户）
    private Integer businessType ;			// 业务类型（0其它 1新增 2修改 3删除）
    private String operName;				// 操作人员
    private String operUrl;					// 请求URL
    private String operIp;					// 主机地址
    private String operParam;				// 请求参数
    private String jsonResult;				// 返回参数
    private Integer status;					// 操作状态（0正常 1异常）
    private String errorMsg;				// 错误消息
}
