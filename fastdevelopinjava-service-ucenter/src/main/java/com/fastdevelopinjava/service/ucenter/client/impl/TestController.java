package com.fastdevelopinjava.service.ucenter.client.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TestController")
public class TestController {

    @GetMapping("/testBigData")
    public String testBigData() {
        return "testBigData";
    }

}
