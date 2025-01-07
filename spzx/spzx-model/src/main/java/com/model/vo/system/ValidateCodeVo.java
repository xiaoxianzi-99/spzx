package com.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/2
 **/
@Data
@Schema(description = "验证码响应结果实体类")
public class ValidateCodeVo {
    @Schema(description = "验证码key")
    private String codeKey;
    @Schema(description = "验证码value")
    private String codeValue; //图片的字节流
}
