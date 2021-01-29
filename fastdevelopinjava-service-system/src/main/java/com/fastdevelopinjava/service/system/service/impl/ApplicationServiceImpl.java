package com.fastdevelopinjava.service.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationReqDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.service.system.convert.ApplicationConvert;
import com.fastdevelopinjava.service.system.mapper.ApplicationDOMapper;
import com.fastdevelopinjava.service.system.model.ApplicationDO;
import com.fastdevelopinjava.service.system.model.ApplicationDOExample;
import com.fastdevelopinjava.service.system.service.ApplicationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
    public PageDTO<ApplicationDTO> getList(ApplicationReqDTO applicationReqDTO) {
        PageHelper.startPage(
                applicationReqDTO.getPageNum(),
                applicationReqDTO.getPageable() ? applicationReqDTO.getPageSize() : 0,
                true,
                true,
                !applicationReqDTO.getPageable()
        );
        ApplicationDOExample applicationDOExample = this.build(applicationReqDTO);
        List<ApplicationDO> applicationDOList = applicationMapper.selectByExample(applicationDOExample);
        PageInfo<ApplicationDO> pageInfo = new PageInfo<>(applicationDOList);
        List<ApplicationDTO> applicationDTOList = Lists.newArrayList();
        if (CollectionUtil.isNotEmpty(pageInfo.getList())) {
            applicationDTOList = pageInfo.getList().stream()
                    .map(applicationDO -> applicationConvert.applicationDO2ApplicationDTO(applicationDO))
                    .collect(Collectors.toList());
        }
        return new PageDTO<>(pageInfo.getTotal(), applicationDTOList);
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
