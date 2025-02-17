package com.service.anno;

import com.service.config.UserWebMvcConfiguration;
import com.service.interceptor.UserLoginAuthInterceptor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/16
 **/
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Import(value = {UserLoginAuthInterceptor.class,UserWebMvcConfiguration.class})
public @interface EnableUserWebMvcConfiguration {
}
