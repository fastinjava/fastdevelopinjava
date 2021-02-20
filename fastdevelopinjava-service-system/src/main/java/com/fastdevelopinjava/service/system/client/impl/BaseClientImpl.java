package com.fastdevelopinjava.service.system.client.impl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;
import com.fastdevelopinjava.framework.ucenter.utils.spring.ClassScanner;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/v/vv")
public class BaseClientImpl {

    @GetMapping(value = "/apilist", name = "接口信息列表")
    public ResultDTO<List<ApiInfoDTO>> apilist() {

        List<ApiInfoDTO> apiInfoDTOList = Lists.newArrayList();

        //得到controller或者restcontroller的class
        Set<Class<?>> clazzList = ClassScanner.scan("com.fastdevelopinjava", RestController.class, Controller.class);
        for (Class<?> aClass : clazzList) {
            RequestMapping requestMapping = aClass.getAnnotation(RequestMapping.class);
            String[] baseUrls = requestMapping.value();
            //获取所有方法
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                buildApiInfoList(apiInfoDTOList, baseUrls, declaredMethod);
            }
        }

        return ResultDTO.success(apiInfoDTOList);

    }

    private void buildApiInfoList(List<ApiInfoDTO> apiInfoDTOList, String[] baseUrls, Method declaredMethod) {
        PostMapping postApi = declaredMethod.getAnnotation(PostMapping.class);
        GetMapping getApi = declaredMethod.getAnnotation(GetMapping.class);
        RequestMapping commonApi = declaredMethod.getAnnotation(RequestMapping.class);

        String apiName = "";
        String[] urls = {};
        if (ObjectUtil.isNotEmpty(postApi)) {
            urls = postApi.value();
            apiName = postApi.name();
        } else if (ObjectUtil.isNotEmpty(getApi)) {
            urls = getApi.value();
            apiName = getApi.name();
        } else if (ObjectUtil.isNotEmpty(commonApi)) {
            urls = commonApi.value();
            apiName = commonApi.name();
        }

        ApiInfoDTO apiInfoDTO = new ApiInfoDTO();

        if (ArrayUtil.isNotEmpty(baseUrls)) {
            StringBuffer urlSb = new StringBuffer(baseUrls[0]);
            if (ArrayUtil.isNotEmpty(urls)) {
                urlSb.append(urls[0]);
                apiInfoDTO.setApiUrl(urlSb.toString());
            }
        }
        apiInfoDTO.setApiName(apiName);
        apiInfoDTOList.add(apiInfoDTO);
        log.info("urls = {} ", urls);
    }


}
