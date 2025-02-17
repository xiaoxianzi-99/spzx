package com.model.entity.user;

import com.model.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@Data
public class UserAddress extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long userId;

    private String name;

    private String phone;

    private String tagName;

    private String provinceCode;

    private String cityCode;

    private String districtCode;

    private String address;

    private String fullAddress;

    private Integer isDefault;
}
