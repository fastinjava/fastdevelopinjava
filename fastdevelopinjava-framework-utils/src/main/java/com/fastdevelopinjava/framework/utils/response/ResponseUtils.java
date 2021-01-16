package com.fastdevelopinjava.framework.utils.response;


import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
public class ResponseUtils {
    public static void jsonResult(HttpServletRequest request, HttpServletResponse response,Object result){
            response.setStatus(HttpStatus.OK.value());
            response.setHeader("Content-Type","application/json;charset=UTF-8");
        try {
            response.getWriter().write(JSONUtil.toJsonStr(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
