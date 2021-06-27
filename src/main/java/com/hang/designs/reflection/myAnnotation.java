package com.hang.designs.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: hangshuo
 * @date: 2021/04/20 11:35
 * @Description:
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface myAnnotation{
    String value();
    String description() default "方法注解的描述";
}