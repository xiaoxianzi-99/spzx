package com.manager.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.manager.service.ValidateCodeService;
import com.model.vo.system.ValidateCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/2
 **/
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public ValidateCodeVo generateValidateCode() {
        //生成验证码
        CircleCaptcha circleCaptcha= CaptchaUtil.createCircleCaptcha(150,48,4,20);
        String code = circleCaptcha.getCode();
        String codeImage = circleCaptcha.getImageBase64();

        ValidateCodeVo validateCodeVo = new ValidateCodeVo();
        String validateCode = UUID.randomUUID().toString().replace("-", "");
        //将code和validatecode放入redis中
        redisTemplate.opsForValue().set("user:login:validatecode:"+code,validateCode,3, TimeUnit.MINUTES);
        validateCodeVo.setCodeKey(validateCode);
        validateCodeVo.setCodeValue("data:image/png;base64," +codeImage);
        return validateCodeVo;
    }
}
