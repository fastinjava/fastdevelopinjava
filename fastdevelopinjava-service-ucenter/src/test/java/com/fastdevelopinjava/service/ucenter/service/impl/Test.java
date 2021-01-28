package com.fastdevelopinjava.service.ucenter.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.File;

public class Test {


    @org.junit.Test
    public void test1() {
        File file = new File("E:\\workspace1\\osg-scp0021.rar");
        String encode = Base64.encode(file);
        StringBuffer sb = new StringBuffer(encode).append(encode).append(encode);
        String id = HttpUtil.createPost("http://localhost:50005/fastdevelopinjava-service-ucenter/TestController/testBigData")
                .body(JSONUtil.toJsonStr(new JSONObject().put("id", sb.toString()))).execute().body();

        System.out.println(encode);
    }

}
