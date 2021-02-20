package com.fastdevelopinjava.framework.ucenter.utils;

import cn.hutool.core.lang.Assert;

import java.util.function.Consumer;

public class AssertUtil<T> extends Assert {

    private T value;

    private AssertUtil() {
        this.value = null;
    }

    private AssertUtil(T value) {
        this.value = value;
    }

    public static <T> AssertUtil<T> ofNullable(T value) {
        return new AssertUtil<>(value);
    }

    public void whenDo(boolean expression, Consumer<T> consumer) {
        Assert.isTrue(expression);
        consumer.accept(value);
    }
}
