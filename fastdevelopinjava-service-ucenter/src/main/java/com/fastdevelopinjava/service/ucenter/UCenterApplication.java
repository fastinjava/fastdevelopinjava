package com.fastdevelopinjava.service.ucenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.fastdevelopinjava.service.ucenter.mapper")
public class UCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UCenterApplication.class);
    }

}
