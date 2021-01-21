package com.fastdevelopinjava.service.ucenter.service.impl;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MockTest {

    public String hello(String input) {
        String output = new String();
        return output;
    }

    public Boolean judge(Boolean result){
        return false;
    }

    @Test
    public void test1() {

//        使用 mockito 生成 Mock 对象;

        MockTest mock = mock(MockTest.class);

//        定义(并非录制) Mock 对象的行为和输出(expectations部分);

        when(mock.hello("lifuyong")).thenReturn("lichangjun");

//        调用 Mock 对象方法进行单元测试;

        String result = mock.hello("lifuyong");

        Assert.assertEquals("lichangjun", result);

//        对 Mock 对象的行为进行验证;

        verify(mock).hello("lifuyong");


    }


    @Test
    public void test2(){

    }
}
