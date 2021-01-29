package com.fastinjava.service.demo2.demo;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Demo2 {
    public static void main(String[] args) {
//        new Thread(() -> System.out.println("okay")).start();

        Predicate<Integer> predicate = t -> t > 2;
        System.out.println(predicate.test(3));

        Consumer<String> consumer = s -> System.out.println("lifuyong say " + s);
        consumer.accept("i love 刘亦菲");

        /**
         * true
         * lifuyong say i love 刘亦菲
         */
    }
}
