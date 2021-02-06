package com.fastinjava.service.demo2.demo;

import org.junit.Test;

import java.util.stream.IntStream;

public class Man6 {
    @Test
    public void test() {
        long count = IntStream.rangeClosed(1, 100).parallel().peek(System.out::println).count();
        System.out.println(count);
    }
}
