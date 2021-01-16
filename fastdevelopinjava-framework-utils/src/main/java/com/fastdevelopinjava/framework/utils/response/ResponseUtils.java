package com.fastdevelopinjava.framework.utils.response;


import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 响应工具类
 */
public class ResponseUtils {
    /**
     * json格式响应
     *
     * @param request
     * @param response
     * @param result   响应的具体数据
     */
    public static void jsonResult(
            HttpServletRequest request,
            HttpServletResponse response,
            Object result
    ) {
        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            response.getWriter().write(JSONUtil.toJsonStr(result));
        } catch (IOException e) {
            Console.log(e.getMessage());
        }
    }
}
