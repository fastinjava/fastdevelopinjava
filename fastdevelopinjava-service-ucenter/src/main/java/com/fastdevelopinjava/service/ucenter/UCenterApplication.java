package com.fastdevelopinjava.service.ucenter;

import cn.hutool.json.JSONUtil;
import com.fastdevelopinjava.framework.api.ucenter.model.User;
import com.fastdevelopinjava.service.ucenter.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.fastdevelopinjava.service.ucenter.mapper")
public class UCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UCenterApplication.class);
    }


    @Resource
    private UserMapper userMapper;

    @RestController
    class IndexController {
        @GetMapping("/")
        public String index(){
            User user = userMapper.selectByPrimaryKey(1L);
            return JSONUtil.toJsonPrettyStr(user);
        }
    }

}
