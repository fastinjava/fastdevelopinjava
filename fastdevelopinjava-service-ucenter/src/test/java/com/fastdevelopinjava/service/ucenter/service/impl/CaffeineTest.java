package com.fastdevelopinjava.service.ucenter.service.impl;

import cn.hutool.json.JSONUtil;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.Test;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * caffeine缓存学习
 *
 * <dependency>
 * <groupId>com.github.ben-manes.caffeine</groupId>
 * <artifactId>caffeine</artifactId>
 * <version>2.8.8</version>
 * </dependency>
 * <p>
 * https://github.com/ben-manes/caffeine/wiki/Population-zh-CN
 */
public class CaffeineTest {


    /**
     * 缓存添加——手动加载
     */
    @Test
    public void test1() {
        Cache<String, String> cache = Caffeine.newBuilder().expireAfterWrite(3, TimeUnit.MINUTES).maximumSize(1000).build();
        cache.put("user1", "lifuyong1");
        cache.put("user2", "lifuyong2");
        ConcurrentMap<String, String> map = cache.asMap();
        System.out.println(JSONUtil.toJsonPrettyStr(map));
    }

}
