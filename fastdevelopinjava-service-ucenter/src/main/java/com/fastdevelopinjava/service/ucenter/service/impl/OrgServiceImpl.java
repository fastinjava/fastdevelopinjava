package com.fastdevelopinjava.service.ucenter.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.OrganizationUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.NodeDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.service.ucenter.convert.OrgConvert;
import com.fastdevelopinjava.service.ucenter.mapper.OrganizationDOMapper;
import com.fastdevelopinjava.service.ucenter.model.OrganizationDO;
import com.fastdevelopinjava.service.ucenter.model.OrganizationDOExample;
import com.fastdevelopinjava.service.ucenter.service.OrgService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;



@Slf4j
@Service
public class OrgServiceImpl
        implements OrgService {

    @Resource
    OrganizationDOMapper orgMapper;

    @Resource
    OrgConvert orgConvert;


    /**
     * 根据organizationReqDTO构造example对象
     *
     * @param organizationReqDTO
     * @return
     */
    private OrganizationDOExample build(OrganizationReqDTO organizationReqDTO) {

        log.info(" organizationReqDTO =====> {} ", JSONUtil.toJsonPrettyStr(organizationReqDTO));

        OrganizationDOExample organizationDOExample = new OrganizationDOExample();
        OrganizationDOExample.Criteria criteria = organizationDOExample.createCriteria();
        if (ObjectUtil.isNotEmpty(organizationReqDTO.getOrgId())) {
            criteria.andOrgIdEqualTo(organizationReqDTO.getOrgId());
        }
        if (ObjectUtil.isNotEmpty(organizationReqDTO.getOrgName())) {
            criteria.andOrgNameEqualTo(organizationReqDTO.getOrgName());
        }
        if (ObjectUtil.isNotEmpty(organizationReqDTO.getOrgPid()))
        {
            criteria.andOrgPidEqualTo(organizationReqDTO.getOrgPid());
        }
        if (ObjectUtil.isNotEmpty(organizationReqDTO.getDeleteFlag()))
        {
            criteria.andDeleteFlagEqualTo(organizationReqDTO.getDeleteFlag());
        }
        return organizationDOExample;

    }

    @Override
    public OrganizationDTO getOne(OrganizationReqDTO organizationReqDTO) {
        log.info("=========>从数据库查找 , organizationReqDTO = {} ", JSONUtil.toJsonPrettyStr(organizationReqDTO));
        OrganizationDOExample organizationDOExample = build(organizationReqDTO);
        organizationDOExample.setOrderByClause("org_id asc limit 1");
        List<OrganizationDO> organizationDOList = orgMapper.selectByExample(organizationDOExample);
        OrganizationDO organizationDO = organizationDOList.stream().findFirst().orElseGet(null);
        OrganizationDTO organizationDTO = orgConvert.organizationDO2OrganizationDTO(organizationDO);
        return organizationDTO;
    }

    @Override
    public PageDTO<OrganizationDTO> getList(OrganizationReqDTO organizationReqDTO) {
        PageHelper.startPage(
                organizationReqDTO.getPageNum(),
                organizationReqDTO.getPageable() ? organizationReqDTO.getPageSize() : 0,
                true,
                true,
                !organizationReqDTO.getPageable() //默认分页true，如果不分页false，想要查询全部需要取反，且size=0
        );

        organizationReqDTO.setDeleteFlag("0");
        OrganizationDOExample organizationDOExample = build(organizationReqDTO);
        organizationDOExample.setOrderByClause("org_id asc");
        PageInfo<OrganizationDO> pageInfo = new PageInfo<>(orgMapper.selectByExample(organizationDOExample));
        long total = pageInfo.getTotal();
        List<OrganizationDTO> organizationDTOList = Lists.newArrayList();
        if (CollectionUtil.isNotEmpty(pageInfo.getList())) {
            organizationDTOList = pageInfo.getList().stream()
                    .map(organizationDO -> orgConvert.organizationDO2OrganizationDTO(organizationDO))
                    .collect(Collectors.toList());
        }
        return new PageDTO<>(total, organizationDTOList);
    }

    @Override
    public Boolean insert(OrganizationCreateDTO organizationCreateDTO) {
        OrganizationDO organizationDO = orgConvert.organizationCreateDTO2OrganizationDO(organizationCreateDTO);
        return orgMapper.insertSelective(organizationDO) > 0;
    }

    @Override
    public Boolean update(OrganizationUpdateDTO organizationUpdateDTO) {
        Assert.isTrue(ObjectUtil.isNotEmpty(organizationUpdateDTO) && ObjectUtil.isNotEmpty(organizationUpdateDTO.getOrgId()), () -> "更新时缺失orgId");
        log.info("organizationUpdateDTO =========> {} ", organizationUpdateDTO);
        OrganizationDO organizationDO = orgConvert.organizationUpdateDTO2OrganizationDO(organizationUpdateDTO);
        log.info("organizationDO =========> {} ", organizationDO);
        //如果是软删除，子类如果有任意一个不是被删除状态则不允许当前父组织被软删除
        if (StrUtil.isNotBlank(organizationDO.getDeleteFlag()) && "1".equalsIgnoreCase(organizationDO.getDeleteFlag())) {
            Integer pCount = orgMapper.countByOrgPidAndDeleteFlag(organizationDO.getOrgId(), "0");
            if (ObjectUtil.isNotEmpty(pCount) && pCount > 0) {
                throw new RuntimeException("当前父分类下有子分类，不允许删除");
            }
        }
        return orgMapper.updateByPrimaryKeySelective(organizationDO) > 0;
    }

    @Override
    public List<NodeDTO> listTree(OrganizationReqDTO organizationReqDTO) {
        log.info("organizationReqDTO =========> {} ", organizationReqDTO);
        List<NodeDTO> nodeDTOList = orgMapper.listTree(organizationReqDTO);
        return nodeDTOList;
    }
}
