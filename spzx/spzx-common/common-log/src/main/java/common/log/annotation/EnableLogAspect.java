package common.log.annotation;

import common.log.aspect.LogAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/25
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(value = LogAspect.class)            // 通过Import注解导入日志切面类到Spring容器中
public @interface EnableLogAspect {

}
