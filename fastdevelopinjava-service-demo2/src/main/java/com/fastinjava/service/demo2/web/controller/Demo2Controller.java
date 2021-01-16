package com.fastinjava.service.demo2.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Demo2Controller {
    @PostMapping("/test2")
    public Object test1(@RequestBody Map<String,Object> params){
        return params;
    }
}
