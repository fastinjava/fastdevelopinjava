package com.fastinjava.service.demo2.demo;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main5 {
    /**
     * stream流的创建
     * 1、Collection.stream方法
     * 2、Collection.parallelStream方法
     */
    @Test
    public void test1() {
        List<String> stringList = Lists.newArrayList("lifuyong", "leefuyong", "lify");
        Stream<String> stream = stringList.stream();
        Stream<String> parallelStream = stringList.parallelStream();
    }

    /**
     * Arrays.stream方法
     */
    @Test
    public void test2() {
        Stream<String> stringStream = Arrays.stream(new String[]{"lifuyong", "lifuyong"});
    }

    /**
     * IntStream.range
     * IntStream.rangeClosed
     * Stream.generate
     * new Random().ints().limit(2)
     */
    @Test
    public void test3() {
        IntStream intStream = IntStream.of(1, 2);
//        IntStream.range();
//        IntStream.rangeClosed();
        IntStream intStream1 = new Random().ints().limit(2);
        LongStream longStream = LongStream.of(1, 2);
        Stream.generate(new Supplier<Object>() {
            @Override
            public Object get() {
                return null;
            }
        }).limit(2);
    }

}
