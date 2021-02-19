package com.fastdevelopinjava.service.system.service.impl;

import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDeleteDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoInsertDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.service.system.service.ApiInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ApiInfoServiceImpl implements ApiInfoService {
    @Override
    public PageDTO<ApiInfoDTO> getList(ApiInfoReqDTO apiInfoReqDTO) {
        return null;
    }

    @Override
    public ApiInfoDTO getOne(ApiInfoReqDTO apiInfoReqDTO) {
        return null;
    }

    @Override
    public Boolean delete(ApiInfoDeleteDTO apiInfoDeleteDTO) {
        return null;
    }

    @Override
    public Boolean insert(ApiInfoInsertDTO apiInfoInsertDTO) {
        return null;
    }
}
