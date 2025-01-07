package com.manager.config;

import com.manager.interceptor.LoginAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/
@ComponentScan
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginAuthInterceptor loginAuthInterceptor;
    /**
     * 登录校验
     *
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginAuthInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/admin/system/index/login","/admin/system/index/generateValidateCode");
    }

    /**
     * 跨域配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")//拦截映射路径规则
                .allowedHeaders("*")// 允许的头
                .allowedMethods("*")//允许的请求方式
                .allowedOriginPatterns("*")//允许的请求源
                .allowCredentials(true);//是否允许携带cookie
    }
}
