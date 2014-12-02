package com.atguigu.frame.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * MethodLog
 * 
 * @Description 定义个注解，用于记录该方法的描述
 * @author wg
 * @date 2014年10月12日 上午10:47:10
 *
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodLog {
	String remark() default "";
}