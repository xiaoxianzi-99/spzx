package com.user.controller;

import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import com.user.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/14
 **/
@RestController
@RequestMapping("/api/user/sms")
public class SmsController {
    @Autowired
    private SmsService smsService ;
    @GetMapping("/sendCode/{phone}")
    public Result sendValidateCode(@PathVariable String phone) {
        smsService.sendValidateCode(phone);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
}
