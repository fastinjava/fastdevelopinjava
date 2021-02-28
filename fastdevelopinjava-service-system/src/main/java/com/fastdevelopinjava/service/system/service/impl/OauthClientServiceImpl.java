package com.fastdevelopinjava.service.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailReqDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsInsertDTO;
import com.fastdevelopinjava.framework.system.api.dto.OauthDetailsUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.service.system.convert.OauthClientConvert;
import com.fastdevelopinjava.service.system.mapper.OauthDetailsDOMapper;
import com.fastdevelopinjava.service.system.model.OauthDetailsDO;
import com.fastdevelopinjava.service.system.model.OauthDetailsDOExample;
import com.fastdevelopinjava.service.system.service.OauthClientService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
        String deleteFlag = jsonObject.getString("deleteFlag");

        if (StringUtils.isNotEmpty(clientId)) {
            criteria.andClientIdEqualTo(clientId);
        }

        if (StringUtils.isNotEmpty(clientSecret)) {
            criteria.andClientSecretEqualTo(clientSecret);
        }

        if (StringUtils.isNotEmpty(deleteFlag))
        {
            criteria.andDeleteFlagEqualTo(deleteFlag);
        }

        return oauthDetailsDOExample;

    }

    @Override
    public Boolean insert(OauthDetailsInsertDTO oauthDetailsInsertDTO) {
        OauthDetailsDO oauthDetailsDO = oauthClientConvert.oauthDetailsInsertDTO2OauthDetailsDO(oauthDetailsInsertDTO);
        oauthDetailsDO.setDeleteFlag("0");
        int i = oauthDetailsDOMapper.insertSelective(oauthDetailsDO);
        return i > 0;
    }

    @Override
    public Boolean update(OauthDetailsUpdateDTO oauthDetailsUpdateDTO) {
        OauthDetailsDO oauthDetailsDO = oauthClientConvert.oauthDetailsUpdateDTO2OauthDetailsDO(oauthDetailsUpdateDTO);
        int result = oauthDetailsDOMapper.updateByExampleSelective(oauthDetailsDO, build(new JSONObject().fluentPut("clientId", oauthDetailsUpdateDTO.getClientId())));
        return result > 0;
    }

    @Override
    public PageDTO<OauthDetailsDTO> getList(OauthDetailReqDTO oauthDetailReqDTO) {
        PageHelper.startPage(oauthDetailReqDTO.getPageNum(), oauthDetailReqDTO.getPageable() ? oauthDetailReqDTO.getPageSize() : 0, true, true, !oauthDetailReqDTO.getPageable());
        PageInfo<OauthDetailsDO> pageInfo = new PageInfo<>(oauthDetailsDOMapper.selectByExample(build(
                new JSONObject()
                        .fluentPut("clientId", oauthDetailReqDTO.getClientId())
                        .fluentPut("deleteFlag","0")//未删除的记录
        )));
        List<OauthDetailsDTO> oauthDetailsDTOList = pageInfo.getList().stream().map(oauthDetailsDO -> oauthClientConvert.oauthDetailsDO2OauthDetailsDTO(oauthDetailsDO)).collect(Collectors.toList());
        return new PageDTO<>(pageInfo.getTotal(), oauthDetailsDTOList);
    }

    @Override
    public OauthDetailsDTO getOne(OauthDetailReqDTO oauthDetailReqDTO) {
        OauthDetailsDO oauthDetailsDO = oauthDetailsDOMapper.selectByExample(build(new JSONObject().fluentPut("clientId", oauthDetailReqDTO.getClientId()))).stream().findFirst().orElse(null);
        return oauthClientConvert.oauthDetailsDO2OauthDetailsDTO(oauthDetailsDO);
    }
}
