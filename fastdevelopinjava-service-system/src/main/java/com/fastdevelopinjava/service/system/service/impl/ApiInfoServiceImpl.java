package com.fastdevelopinjava.service.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoDeleteDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoInsertDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApiInfoReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.service.system.convert.ApiInfoConvert;
import com.fastdevelopinjava.service.system.mapper.ApiInfoDOMapper;
import com.fastdevelopinjava.service.system.model.ApiInfoDO;
import com.fastdevelopinjava.service.system.model.ApiInfoDOExample;
import com.fastdevelopinjava.service.system.service.ApiInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ApiInfoServiceImpl implements ApiInfoService {

    @Resource
    private ApiInfoDOMapper apiInfoMapper;

    @Resource
    private ApiInfoConvert apiInfoConvert;


    private ApiInfoDOExample build(
            //apiId
            JSONObject jsonObject
    ) {
        ApiInfoDOExample apiInfoDOExample = new ApiInfoDOExample();
        ApiInfoDOExample.Criteria criteria = apiInfoDOExample.createCriteria();

        Integer apiId = jsonObject.getInteger("apiId");

        if (ObjectUtil.isNotEmpty(apiId)) {
            criteria.andApiIdEqualTo(apiId);
        }
        return apiInfoDOExample;
    }

    @Override
    public PageDTO<ApiInfoDTO> getList(ApiInfoReqDTO apiInfoReqDTO) {
        PageHelper.startPage(apiInfoReqDTO.getPageNum(), apiInfoReqDTO.getPageable() ? apiInfoReqDTO.getPageSize() : 0, true, true, !apiInfoReqDTO.getPageable());
        PageInfo<ApiInfoDO> pageInfo = new PageInfo<>(apiInfoMapper.selectByExample(build(new JSONObject().fluentPut("apiId", apiInfoReqDTO.getApiId()))));
        List<ApiInfoDTO> apiInfoDTOS = Lists.newArrayList();
        if (CollectionUtil.isNotEmpty(pageInfo.getList())) {
            apiInfoDTOS = pageInfo.getList().stream().map(apiInfoDO -> apiInfoConvert.apiInfoDO2ApiInfoDTO(apiInfoDO)).collect(Collectors.toList());
        }
        return new PageDTO<>(pageInfo.getTotal(), apiInfoDTOS);
    }

    @Override
    public ApiInfoDTO getOne(ApiInfoReqDTO apiInfoReqDTO) {
        return apiInfoConvert.apiInfoDO2ApiInfoDTO(apiInfoMapper.selectByExample(this.build(new JSONObject().fluentPut("apiId", apiInfoReqDTO.getApiId()))).stream().findFirst().orElse(null));
    }

    @Override
    public Boolean delete(ApiInfoDeleteDTO apiInfoDeleteDTO) {
        return apiInfoMapper.deleteByExample(this.build(new JSONObject().fluentPut("apiId", apiInfoDeleteDTO.getApiId()))) > 0;
    }

    @Override
    public Boolean insert(ApiInfoInsertDTO apiInfoInsertDTO) {
        return apiInfoMapper.insertSelective(apiInfoConvert.apiInfoInsertDTO2ApiInfoDO(apiInfoInsertDTO)) > 0;
    }
}
