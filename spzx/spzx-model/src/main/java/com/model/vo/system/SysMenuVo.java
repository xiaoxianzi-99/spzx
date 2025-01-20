package com.model.vo.system;

import lombok.Data;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/17
 **/
@Data
public class SysMenuVo {
    private String title;
    private String name;
    private List<SysMenuVo> children;
}
