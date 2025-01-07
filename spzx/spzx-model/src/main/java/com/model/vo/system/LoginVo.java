package com.model.vo.system;

import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/
@Data
public class LoginVo {
    private String token ;
    private String refresh_token ;		// 该字段不会存储对应的值
}
