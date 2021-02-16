package com.fastdevelopinjava.service.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationDTO;
import com.fastdevelopinjava.framework.system.api.dto.ApplicationDeleteDTO;
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
import org.apache.commons.lang3.StringUtils;
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
        if (StringUtils.isNotEmpty(appName)) {
            criteria.andAppNameLike("%" + appName.trim() + "%");
        }
        if (StringUtils.isNotEmpty(appCode)) {
            criteria.andAppCodeEqualTo(appCode);
        }
        return applicationDOExample;
    }

    @Override
    public Boolean delete(ApplicationDeleteDTO applicationDeleteDTO) {
        ApplicationReqDTO applicationReqDTO = new ApplicationReqDTO();
        Integer appId = applicationDeleteDTO.getAppId();
        applicationDeleteDTO.setAppId(appId);
        ApplicationDO applicationDo = new ApplicationDO();
        applicationDo.setAppId(appId);
        applicationDo.setDeleteFlag("1");
        int result = applicationMapper.updateByExampleSelective(applicationDo, this.build(applicationReqDTO));
        return result > 0;
    }

    @Override
    public PageDTO<ApplicationDTO> getList(ApplicationReqDTO applicationReqDTO) {
        PageHelper.startPage(applicationReqDTO.getPageNum(), applicationReqDTO.getPageable() ? applicationReqDTO.getPageSize() : 0, true, true, !applicationReqDTO.getPageable());
        PageInfo<ApplicationDO> pageInfo = new PageInfo<>(applicationMapper.selectByExample(this.build(applicationReqDTO)));
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
        return applicationConvert.applicationDO2ApplicationDTO(applicationDO);
    }
}
