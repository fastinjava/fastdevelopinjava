package com.fastinjava.service.demo2.demo;

import java.util.stream.IntStream;

public class MinDemo {

    public static void main(String[] args) {
        int[] nums = {11, 12, 12, 22};
        System.out.println(test1(nums));
        System.out.println(test2(nums));
    }

    //函数式编程找出最小值
    public static int test2(int[] nums) {
        int min = IntStream.of(nums).min().getAsInt();
        return min;
    }

    //命令是编程找出最小值
    public static int test1(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
