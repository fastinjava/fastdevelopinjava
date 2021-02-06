package com.fastinjava.service.demo2.demo;

import cn.hutool.core.lang.Console;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main4 {
    public static void main(String[] args) {
        Stream<Integer> intStream = Lists.newArrayList(1, 2, 3).stream();
        Integer sum = intStream.reduce(0, Integer::sum);
        Console.log(sum);
    }

    /**
     * Optional:
     * BinaryOperator:
     * public interface BinaryOperator<T> extends BiFunction<T,T,T>
     * Interface BiFunction<T,U,R>
     * consumer的类型是 Interface BiFunction<T,U,R>，有3个类型参数：
     * T - 函数第一个参数的类型（实际为U，accumulator函数返回结果的类型）
     * U - 函数第二个参数的类型（实际为T，stream内元素的类型）
     * R - 函数返回值的类型 （这里实际为U）
     * BiFunction接收参数个数为2
     * <p>
     * Optional<T> reduce(BinaryOperator<T> accumulator);
     */
    @Test
    public void test1() {
        Stream<Integer> intStream = Lists.newArrayList(1, 2, 3).stream();
        Optional<Integer> integerOptional = intStream.reduce((a, b) -> a + b);
        if (integerOptional.isPresent()) {
            Console.log(integerOptional.get());
        }
    }

    @Test
    public void test2() {
        Stream<Integer> intStream = Lists.newArrayList(1, 2, 3).stream();
        Integer sum = intStream.reduce(0, Integer::sum);
        Console.log(sum);
    }

    @Test
    public void test3() {
        Stream<Integer> intStream = Lists.newArrayList(1, 2, 3).stream();
        Integer sum = intStream.reduce(0, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });
        Console.log(sum);
    }

    @Test
    public void test4() {
        List<String> stringList = Lists.newArrayList("lifuyong", "leefuyong", "lify");
        stringList.stream().filter(
                new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return s.startsWith("li");
                    }
                }
        ).forEach(System.out::println);
        Console.log(stringList);
    }

    @Test
    public void test5() {
        List<String> stringList = Lists.newArrayList("lifuyong", "leefuyong", "lify", "lifuyong");
        stringList.stream().distinct().forEach(System.out::println);
        Console.log(stringList);
        /**
         * lifuyong
         * leefuyong
         * lify
         * [lifuyong, leefuyong, lify, lifuyong]
         */
    }

    @Test
    public void test6() {
        List<String> stringList = Lists.newArrayList("lifuyong", "leefuyong", "lify", "lifuyong");
        stringList.stream().skip(2).forEach(System.out::println);
        Console.log(stringList);
        /**
         * lify
         * lifuyong
         * [lifuyong, leefuyong, lify, lifuyong]
         */
    }

}
