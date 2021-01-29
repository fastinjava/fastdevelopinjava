package com.fastdevelopinjava.service.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationReqDTO;
import com.fastdevelopinjava.service.system.convert.ApplicationConvert;
import com.fastdevelopinjava.service.system.mapper.ApplicationDOMapper;
import com.fastdevelopinjava.service.system.model.ApplicationDO;
import com.fastdevelopinjava.service.system.model.ApplicationDOExample;
import com.fastdevelopinjava.service.system.service.ApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApplicationServiceImpl implements ApplicationService {


    @Resource
    private ApplicationDOMapper applicationMapper;


    @Resource
    private ApplicationConvert applicationConvert;


    private ApplicationDOExample build(ApplicationReqDTO applicationReqDTO) {
        ApplicationDOExample applicationDOExample = new ApplicationDOExample();
        ApplicationDOExample.Criteria criteria = applicationDOExample.createCriteria();
        Integer appId = applicationReqDTO.getAppId();
        String appName = applicationReqDTO.getAppName();
        String appCode = applicationReqDTO.getAppCode();
        if (ObjectUtil.isNotEmpty(appId)) {
            criteria.andAppIdEqualTo(appId);
        }
        return applicationDOExample;
    }

    @Override
    public ApplicationDTO getOne(ApplicationReqDTO applicationReqDTO) {
        ApplicationDOExample applicationDOExample = this.build(applicationReqDTO);
        applicationDOExample.setOrderByClause("app_id asc limit 1");
        ApplicationDO applicationDO = applicationMapper.selectByExample(applicationDOExample).stream().findFirst().orElseGet(null);
        ApplicationDTO applicationDTO = applicationConvert.applicationDO2ApplicationDTO(applicationDO);
        return applicationDTO;
    }
}
