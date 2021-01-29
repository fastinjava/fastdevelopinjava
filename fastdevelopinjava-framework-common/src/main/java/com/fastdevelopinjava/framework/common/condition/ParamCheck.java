package com.fastdevelopinjava.framework.common.condition;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamCheck {
    boolean value() default true;
}
