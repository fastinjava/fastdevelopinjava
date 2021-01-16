package com.fastdevelopinjava.service.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 系统管理微服务
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.fastdevelopinjava")
@MapperScan("com.fastdevelopinjava.service.user.mapper")
public class SystemManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemManageApplication.class);
    }
}
