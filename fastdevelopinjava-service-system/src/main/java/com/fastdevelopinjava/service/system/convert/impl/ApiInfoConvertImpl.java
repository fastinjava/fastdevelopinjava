package com.fastdevelopinjava.service.system.convert.impl;

import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoInsertDTO;
import com.fastdevelopinjava.service.system.convert.ApiInfoConvert;
import com.fastdevelopinjava.service.system.mapper.ApplicationDOMapper;
import com.fastdevelopinjava.service.system.model.ApiInfoDO;
import com.fastdevelopinjava.service.system.model.ApplicationDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

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
        apiInfoDTO.setAppName(Optional.of(apiInfoDO).map(ApiInfoDO::getAppId).map(appId -> applicationDOMapper.selectByPrimaryKey(appId)).map(ApplicationDO::getAppName).orElse(null));
        return apiInfoDTO;
    }
}
