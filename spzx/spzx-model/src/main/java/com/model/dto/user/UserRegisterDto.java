package com.model.dto.user;

import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/14
 **/
@Data
public class UserRegisterDto {
    private String username;

    private String password;

    private String nickName;

    private String code ;
}
