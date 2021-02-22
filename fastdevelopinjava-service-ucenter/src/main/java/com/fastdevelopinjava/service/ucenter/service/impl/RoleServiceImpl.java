package com.fastdevelopinjava.service.ucenter.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.service.ucenter.convert.RoleConvert;
import com.fastdevelopinjava.service.ucenter.mapper.RoleDOMapper;
import com.fastdevelopinjava.service.ucenter.model.RoleDO;
import com.fastdevelopinjava.service.ucenter.model.RoleDOExample;
import com.fastdevelopinjava.service.ucenter.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleConvert roleConvert;

    @Resource
    RoleDOMapper roleMapper;

    /**
     * todo 需要改造
     *
     * @return
     */
    private RoleDOExample buildRoleExample(JSONObject jsonObject) {
        RoleDOExample roleDOExample = new RoleDOExample();
        RoleDOExample.Criteria criteria = roleDOExample.createCriteria();

        Integer id = jsonObject.getInteger("id");
        String roleCode = jsonObject.getString("roleCode");
        Integer orgId = jsonObject.getInteger("orgId");

        //条件
        if (id != null) {
            criteria.andIdEqualTo(id);
        }
        if (StringUtils.isNotEmpty(roleCode)) {
            criteria.andRoleCodeEqualTo(roleCode);
        }
        if (ObjectUtil.isNotEmpty(orgId)) {
            criteria.andOrgIdEqualTo(orgId);
        }
        return roleDOExample;
    }

    @Override
    public PageDTO<RoleDTO> getList(RoleReqDTO roleReqDTO) {
        PageHelper.startPage(roleReqDTO.getPageNum(), roleReqDTO.getPageable() ? roleReqDTO.getPageSize() : 0, true, true, !roleReqDTO.getPageable());
        PageInfo<RoleDO> pageInfo = new PageInfo<>(roleMapper.selectByExample(this.buildRoleExample(
                new JSONObject().fluentPut("id", roleReqDTO.getId()).fluentPut("roleCode", roleReqDTO.getRoleCode()).fluentPut("orgId", roleReqDTO.getOrgId())
        )));
        long total = pageInfo.getTotal();
        List<RoleDTO> roleDTOList = Lists.newArrayList();
        if (CollectionUtil.isNotEmpty(pageInfo.getList())) {
            roleDTOList = pageInfo.getList().stream().map(role -> roleConvert.roleDO2RoleDTO(role)).collect(Collectors.toList());
        }
        return new PageDTO<>(total, roleDTOList);
    }

    @Override
    public RoleDTO getOne(RoleReqDTO roleReqDTO) {
        RoleDOExample roleDOExample = this.buildRoleExample(
                new JSONObject().fluentPut("id", roleReqDTO.getId())
        );
        roleDOExample.setOrderByClause("id  limit 1");
        RoleDO roleDO = roleMapper.selectByExample(roleDOExample).stream().findFirst().orElseGet(null);
        return null != roleDO ? roleConvert.roleDO2RoleDTO(roleDO) : null;
    }

    @Override
    public Boolean insert(RoleCreateDTO roleCreateDTO) {
        RoleDO roleDO = roleConvert.roleCreateDTO2RoleDO(roleCreateDTO);
        return roleMapper.insertSelective(roleDO) > 0;
    }

    @Override
    public Boolean update(RoleUpdateDTO roleUpdateDTO) {
        RoleDO roleDO = roleConvert.roleUpdateDTO2RoleDO(roleUpdateDTO);
        return roleMapper.updateByPrimaryKeySelective(roleDO) > 0;
    }


}
