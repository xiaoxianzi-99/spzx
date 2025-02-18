package com.model.entity.order;

import com.model.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@Data
public class OrderLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long orderId;

    private String operateUser;

    private Integer processStatus;

    private String note;

}
