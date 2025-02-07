package common.log.annotation;

import common.log.enums.OperatorType;

import java.lang.annotation.*;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/24
 **/

/**
 * 元注解：修饰注解的注解
 * Target：当前注解可以修饰的位置
 * TYPE类上
 *Retention 生命周期
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    public String title() ;								// 模块名称
    public OperatorType operatorType() default OperatorType.MANAGE;	// 操作人类别
    public int businessType() ;     // 业务类型（0其它 1新增 2修改 3删除）
    public boolean isSaveRequestData() default true;   // 是否保存请求的参数
    public boolean isSaveResponseData() default true;  // 是否保存响应的参数
}
