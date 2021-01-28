package com.fastdevelopinjava.service.ucenter.client.impl;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TestController")
public class TestController {

    @PostMapping("/testBigData")
    public void testBigData(@RequestBody JSONObject jsonObject){
        System.out.println(JSONUtil.toJsonPrettyStr(jsonObject));
    }

}
