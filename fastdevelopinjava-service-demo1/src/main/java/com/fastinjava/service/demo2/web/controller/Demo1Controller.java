package com.fastinjava.service.demo2.web.controller;

import com.fastinjava.service.demo2.service.TestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class Demo1Controller {

    @Resource
    private TestService testService;

    @PostMapping("/test1")
    public Object test1(@RequestBody Map<String, Object> params) {
        params.put("success", true);
        String constStr = "礼服用";
        StringBuilder sb = new StringBuilder();
        sb.append(constStr );
        Object data = testService.test();
        params.put("data", data);
        return params;
    }
}
