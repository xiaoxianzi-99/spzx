package com.model.entity.user;

import com.model.entity.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/14
 **/
@Data
public class UserInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String nickName;
    private String avatar;
    private Integer sex;
    private String phone;
    private String memo;
    private String openId;
    private String unionId;
    private String lastLoginIp;
    private Date lastLoginTime;
    private Integer status;
}
