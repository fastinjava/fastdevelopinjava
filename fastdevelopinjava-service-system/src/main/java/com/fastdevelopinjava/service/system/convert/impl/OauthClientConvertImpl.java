package com.fastdevelopinjava.service.system.convert.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsUpdateDTO;
import com.fastdevelopinjava.service.system.convert.OauthClientConvert;
import com.fastdevelopinjava.service.system.model.OauthDetailsDO;
import org.springframework.stereotype.Component;

@Component
public class OauthClientConvertImpl implements OauthClientConvert {


    @Override
    public OauthDetailsDO oauthDetailsUpdateDTO2OauthDetailsDO(OauthDetailsUpdateDTO oauthDetailsUpdateDTO) {
        OauthDetailsDO oauthDetailsDO = new OauthDetailsDO();
        BeanUtil.copyProperties(oauthDetailsUpdateDTO, oauthDetailsDO);
        return oauthDetailsDO;
    }

    @Override
    public OauthDetailsDTO oauthDetailsDO2OauthDetailsDTO(OauthDetailsDO oauthDetailsDO) {

        if (ObjectUtil.isEmpty(oauthDetailsDO)) return null;

        OauthDetailsDTO oauthDetailsDTO = new OauthDetailsDTO();

        oauthDetailsDTO.setClientId(oauthDetailsDO.getClientId());
        oauthDetailsDTO.setClientSecret(oauthDetailsDO.getClientSecret());
        oauthDetailsDTO.setResourceIds(oauthDetailsDO.getResourceIds());
        oauthDetailsDTO.setScope(oauthDetailsDO.getScope());
        oauthDetailsDTO.setAuthorizedGrantTypes(oauthDetailsDO.getAuthorizedGrantTypes());
        oauthDetailsDTO.setWebServerRedirectUri(oauthDetailsDO.getWebServerRedirectUri());
        oauthDetailsDTO.setAuthorities(oauthDetailsDO.getAuthorities());
        oauthDetailsDTO.setAccessTokenValidity(oauthDetailsDO.getAccessTokenValidity());
        oauthDetailsDTO.setRefreshTokenValidity(oauthDetailsDO.getRefreshTokenValidity());
        oauthDetailsDTO.setAdditionalInformation(oauthDetailsDO.getAdditionalInformation());
        oauthDetailsDTO.setAutoapprove(oauthDetailsDO.getAutoapprove());
        oauthDetailsDTO.setStatus(oauthDetailsDO.getStatus());
        oauthDetailsDTO.setDeleteFlag(oauthDetailsDO.getDeleteFlag());
        oauthDetailsDTO.setCreateTime(oauthDetailsDO.getCreateTime());
        oauthDetailsDTO.setUpdateTime(oauthDetailsDO.getUpdateTime());

        return oauthDetailsDTO;
    }
}
