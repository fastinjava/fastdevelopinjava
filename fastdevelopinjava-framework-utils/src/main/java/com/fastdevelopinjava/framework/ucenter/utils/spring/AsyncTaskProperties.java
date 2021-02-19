/**
 * Copyright (C) 2018-2020
 * All rights reserved, Designed By www.yixiang.co
 * 注意：
 * 本软件为www.yixiang.co开发研制
 */
package com.fastdevelopinjava.framework.ucenter.utils.spring;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 线程池配置属性类
 *
 * @author https://juejin.im/entry/5abb8f6951882555677e9da2
 * @date 2019年10月31日14:58:18
 */
@Data
@Component
public class AsyncTaskProperties {
    // # 核心线程池大小
    private int corePoolSize;
    //# 最大线程数
    private int maxPoolSize;
    //# 活跃时间
    private int keepAliveSeconds;
    //# 队列容量
    private int queueCapacity;


    public AsyncTaskProperties() {
    }

    @PostConstruct
    public void init() {
        this.corePoolSize = 10;
        this.maxPoolSize = 30;
        this.keepAliveSeconds = 60;
        this.queueCapacity = 50;
    }

}
