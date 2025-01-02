package com.model.entity.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/
@Data
public class BaseEntity implements Serializable {
    private Long id;
    private Date createTime;
    private Date updateTime;
    private Integer isDeleted;
}
