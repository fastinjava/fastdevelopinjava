package com.fastdevelopinjava.service.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailReqDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsDTO;
import com.fastdevelopinjava.service.system.convert.OauthClientConvert;
import com.fastdevelopinjava.service.system.mapper.OauthDetailsDOMapper;
import com.fastdevelopinjava.service.system.model.OauthDetailsDO;
import com.fastdevelopinjava.service.system.model.OauthDetailsDOExample;
import com.fastdevelopinjava.service.system.service.OauthClientService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OauthClientServiceImpl implements OauthClientService {

    @Resource
    private OauthDetailsDOMapper oauthDetailsDOMapper;
    @Resource
    private OauthClientConvert oauthClientConvert;

    private OauthDetailsDOExample build(JSONObject jsonObject) {

        OauthDetailsDOExample oauthDetailsDOExample = new OauthDetailsDOExample();

        OauthDetailsDOExample.Criteria criteria = oauthDetailsDOExample.createCriteria();

        String clientId = jsonObject.getString("clientId");
        String clientSecret = jsonObject.getString("clientSecret");

        if (StringUtils.isNotEmpty(clientId)) {
            criteria.andClientIdEqualTo(clientId);
        }

        if (StringUtils.isNotEmpty(clientSecret)) {
            criteria.andClientSecretEqualTo(clientSecret);
        }

        return oauthDetailsDOExample;

    }

    @Override
    public OauthDetailsDTO getOne(OauthDetailReqDTO oauthDetailReqDTO) {
        OauthDetailsDO oauthDetailsDO = oauthDetailsDOMapper.selectByExample(build(new JSONObject().fluentPut("clientId", oauthDetailReqDTO.getClientId()))).stream().findFirst().orElse(null);
        OauthDetailsDTO oauthDetailsDTO = oauthClientConvert.oauthDetailsDO2OauthDetailsDTO(oauthDetailsDO);
        return oauthDetailsDTO;
    }
}
