package com.hang.designs.reflection;

import java.lang.annotation.*;

/**
 * @author: hangshuo
 * @date: 2021/04/20 11:01
 * @Description:
 */

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Params {
    String value() default "";
}
