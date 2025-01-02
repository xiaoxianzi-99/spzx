package com.manager.controller;

import com.manager.service.SysUserService;
import com.model.dto.system.LoginDto;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import com.model.vo.system.LoginVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/
@Tag(name="用户登录")
@RestController
@RequestMapping(value = "/admin/system/index")
//@CrossOrigin(allowCredentials = "true",originPatterns = "*",allowedHeaders = "*")
public class IndexController {
    @Autowired
    private SysUserService sysUserService;
    @Operation(summary = "登录接口")
    @PostMapping(value = "/login")
    public Result login(@RequestBody LoginDto loginDto) {
        LoginVo loginVo = sysUserService.login(loginDto) ;
        return Result.build(loginVo , ResultCodeEnum.SUCCESS) ;
    }
}
