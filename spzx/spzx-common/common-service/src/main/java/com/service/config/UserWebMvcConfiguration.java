package com.service.config;

import com.service.interceptor.UserLoginAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/16
 **/

public class UserWebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    UserLoginAuthInterceptor userLoginAuthInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLoginAuthInterceptor)
                .addPathPatterns("/api/**");
    }
}
