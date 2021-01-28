package com.fastdevelopinjava.service.ucenter.config;

import cn.hutool.json.JSONUtil;
import com.github.benmanes.caffeine.cache.CacheWriter;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.benmanes.caffeine.cache.RemovalCause;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Caffeine 缓存配置
 */
@Slf4j
@Configuration
public class CaffeineCacheConfig {

    @Bean
    public LoadingCache loadingCache() {
        LoadingCache<String, Object> loadingCache = Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(1000)
                //缓存写入/删除监控
                .writer(new CacheWriter<Object, Object>() {
                    @Override
                    public void write(Object key, Object value) { //此方法是同步阻塞的
                        System.out.println("--缓存写入--:key=" + key + ", value=" + JSONUtil.toJsonPrettyStr(value));
                    }

                    @Override
                    public void delete(@NonNull Object key, @Nullable Object value, @NonNull RemovalCause cause) {
                        System.out.println("删除缓存key = " + key);
                    }
                })
                .expireAfterAccess(1, TimeUnit.MINUTES) //过期时间
                .build((String key) -> {
                    System.out.println("执行build方法");
                    return null;
                }); //cacheload实现类,刷新时候调用

        return loadingCache;
    }

}
