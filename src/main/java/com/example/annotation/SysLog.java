package com.example.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: SysLog
 * @Description: 记录系统日志注解
 * @Auther: GuoqiangHuang
 * @Date: 2019/10/11 16:24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String businessName() default "";

    String methodName() default "";

    String desc() default "";
}
