package com.fastdevelopinjava.framework.common.condition;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldNotNull {

}
