package com.fastdevelopinjava.service.system.convert.impl;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoInsertDTO;
import com.fastdevelopinjava.service.system.convert.ApiInfoConvert;
import com.fastdevelopinjava.service.system.mapper.ApplicationDOMapper;
import com.fastdevelopinjava.service.system.model.ApiInfoDO;
import com.fastdevelopinjava.service.system.model.ApplicationDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ApiInfoConvertImpl implements ApiInfoConvert {


    @Resource
    private ApplicationDOMapper applicationDOMapper;

    @Override
    public ApiInfoDO apiInfoInsertDTO2ApiInfoDO(ApiInfoInsertDTO apiInfoInsertDTO) {
        return new ApiInfoDO(apiInfoInsertDTO.getApiId(), apiInfoInsertDTO.getApiCode(), apiInfoInsertDTO.getApiName(), apiInfoInsertDTO.getApiDesc(), apiInfoInsertDTO.getAppId(), apiInfoInsertDTO.getNeedAuth(), apiInfoInsertDTO.getDeleteFlag(), apiInfoInsertDTO.getCreatTime(), apiInfoInsertDTO.getUpdateTime(), apiInfoInsertDTO.getApiUrl());
    }

    @Override
    public ApiInfoDTO apiInfoDO2ApiInfoDTO(ApiInfoDO apiInfoDO) {
        if (null == apiInfoDO) return null;
        ApiInfoDTO apiInfoDTO = new ApiInfoDTO(apiInfoDO.getApiId(), apiInfoDO.getApiCode(), apiInfoDO.getApiName(), apiInfoDO.getApiDesc(), apiInfoDO.getAppId(), apiInfoDO.getNeedAuth(), apiInfoDO.getDeleteFlag(), apiInfoDO.getCreatTime(), apiInfoDO.getUpdateTime(), apiInfoDO.getApiUrl(), apiInfoDO.getApiName());
        if (ObjectUtil.isNotEmpty(apiInfoDO.getAppId())) {
            ApplicationDO applicationDO = applicationDOMapper.selectByPrimaryKey(apiInfoDO.getAppId());
            if (ObjectUtil.isNotEmpty(applicationDO)) {
                apiInfoDTO.setAppName(applicationDO.getAppName());
            }
        }
        return apiInfoDTO;
    }
}
