package com.model.dto.system;

import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/
@Data
public class LoginDto {
    private String userName ;
    private String password ;
    private String captcha ;
    private String codekey ;
}
