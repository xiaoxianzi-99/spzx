package com.model.dto.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/10
 **/
@Data
@Schema(description = "请求参数实体类")
public class SysUserDto {
    @Schema(description = "搜索关键字")
    private String keyword;
    @Schema(description = "开始时间")
    private String createTimeBegin;
    @Schema(description = "结束时间")
    private String createTimeEnd;
}
